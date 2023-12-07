
package DAO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Categoria;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOCategoria extends ConectarBD {
    public DAOCategoria(){}
    
    public void MostrarCategorias(JTable t, JLabel l){
        String[] titulos ={"Nro", "idcategoria", "nombrecategoria","descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Categoria c = new Categoria();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idcategoria, nombre,descripcion,"
                    + "indicador from categorias where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                c.setIdcategoria(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setIndicador(rs.getString(4));
                modelo.addRow(c.RegistroCategoria(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaCategorias(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar las categorias..." + e);
        }
    }   
    public void Insertar(Categoria c) {
        try {           
            ps = conexion.prepareStatement("insert into categorias (nombre,descripcion, "
                    + "indicador) values (?,?,'S');");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.executeUpdate();
            Mensajes.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar las categorias..." + e);
        }        
    }       
    public Categoria Consultar(int idcat) {        
        Categoria c = null;     
        try {             
            rs = st.executeQuery("select idcategoria,nombre,descripcion,indicador "+ 
                "from categorias where indicador = 'S' and idcategoria="+idcat+";");
            if (rs.next()){
                c = new Categoria();
                c.setIdcategoria(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setIndicador(rs.getString(4));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
        }        
        return c;
    }    
    public void Actualizar (Categoria c) {
        try {           
            ps = conexion.prepareStatement("UPDATE categorias SET nombre=?,descripcion=? WHERE idcategoria=?;");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getIdcategoria());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }     
    public void Eliminar(int idcat){
        try {             
            ps = conexion.prepareStatement("DELETE FROM categorias where idcategoria=?;");
            ps.setInt(1, idcat);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla categorias");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }   
    public void Imprimirpdf(Categoria c) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Categorias.pdf"));
        documento.open();

        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Descripcion");
        try {            
            try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
            ps = conexion.prepareStatement("SELECT * FROM categorias");
            rs = ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
            }           
            documento.add(tabla);
        } catch (SQLException ex) {
            ex.printStackTrace();   
        } finally {            
            if (rs != null) rs.close();
            if (ps != null) ps.close();          
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            
            if (documento != null && documento.isOpen()) {
                documento.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
    }
}    
    
}

    
