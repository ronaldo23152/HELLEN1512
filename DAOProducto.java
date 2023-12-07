package DAO;

//librerias
import static DAO.Parametros.CLAVE;
import static DAO.Parametros.DRIVER;
import static DAO.Parametros.RUTA;
import static DAO.Parametros.USUARIO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Producto;
import Vista.ifrmMantenimientoProducto;
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

public class DAOProducto  extends ConectarBD {
    ifrmMantenimientoProducto ifrm;
    
    public DAOProducto(){}
    public void MostrarProductos (JTable t,String consulta, JLabel l){
        String[] titulos ={"Nro","ID Producto","Nombre","Descripcion","Categoria","Material","Color","Talla","Stock","Precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Producto p = new Producto();
        int cantreg = 0;
        try {                            
            rs = st.executeQuery(consulta);
            while (rs.next()) {                
                cantreg++;
                p.setIdproducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setIdcategoria(rs.getInt(4));
                p.setIdmaterial(rs.getInt(5));
                p.setIdcolor(rs.getInt(6));
                p.setTalla(rs.getString(7));
                p.setStock(rs.getInt(8));
                p.setPrecio(rs.getDouble(9));                
                modelo.addRow(p.RegistroProducto(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaProductos(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los productos..." + e);
        }
    }
    
    public void Insertar (Producto p) {
        try {            
            ps = conexion.prepareStatement("insert into productos (nombre,descripcion,idcategoria,idmaterial,idcolor,talla,stock,precio, "
                    + "indicador) values (?,?,?,?,?,?,?,?,'S');");

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getIdcategoria());
            ps.setInt(4, p.getIdmaterial());
            ps.setInt(5, p.getIdcolor());
            ps.setString(6, p.getTalla());
            ps.setInt(7, p.getStock());
            ps.setDouble(8, p.getPrecio());
            ps.executeUpdate();
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los productos..." + e);
        }        
    }    
    public Producto Consultar (int idpro) {
        Producto p = null;
        try {
            rs = st.executeQuery("select * from productos where indicador = 'S' and idproducto= "+ idpro +";");            
            
            if (rs.next()) {
                p = new Producto();
                p.setIdproducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));                
                p.setIdcategoria(rs.getInt(4));
                p.setIdmaterial(rs.getInt(5));
                p.setIdcolor(rs.getInt(6));
                p.setTalla(rs.getString(7));
                p.setStock(rs.getInt(8));
                p.setPrecio(rs.getInt(9));                
               
               }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return p;   
    }
    
    public void Actualizar(Producto p){
        try {
            ps = conexion.prepareStatement("update productos set nombre=?,descripcion=?,idcategoria=?,"
                                          +"idmaterial=?,idcolor=?,talla=?,stock=?,precio=?"
                                          +"where idproducto=?;");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getIdcategoria());
            ps.setInt(4, p.getIdmaterial());
            ps.setInt(5, p.getIdcolor());
            ps.setString(6, p.getTalla());
            ps.setInt(7, p.getStock());
            ps.setDouble(8, p.getPrecio());
            ps.setInt(9, p.getIdproducto());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idpro){
        try {             
            ps = conexion.prepareStatement("DELETE FROM productos where idproducto=?;");
            ps.setInt(1, idpro);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla productos");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
    public void Imprimirpdf(Producto p) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Productos.pdf"));
        documento.open();

        PdfPTable tabla = new PdfPTable(9);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Descripcion");
        tabla.addCell("Idcategoria");
        tabla.addCell("Idmaterial");
        tabla.addCell("Idcolor");
        tabla.addCell("Talla");
        tabla.addCell("Stock");
        tabla.addCell("Precio");
            
        try {            
            try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
            ps = conexion.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(rs.getString(7));
                tabla.addCell(rs.getString(8));
                tabla.addCell(rs.getString(9));
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
    // Método para imprimir datos en un archivo PDF
    public void Imprimirpdfactual(Object[][] datos) {
        Document documento = new Document();
                

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Inventario.pdf"));
            documento.open();

            // Crear una tabla con la misma cantidad de columnas que datos
            int columnCount = datos[0].length;
            PdfPTable tabla = new PdfPTable(columnCount);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Descripcion");
            tabla.addCell("Idcategoria");
            tabla.addCell("Idmaterial");
            tabla.addCell("Idcolor");
            tabla.addCell("Talla");
            tabla.addCell("Stock");
            tabla.addCell("Precio");

            // Agregar las celdas a la tabla con los datos
            for (Object[] fila : datos) {
                for (Object dato : fila) {
                    tabla.addCell(dato.toString());
                }
            }

            documento.add(tabla);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (documento != null && documento.isOpen()) {
                documento.close();
            }
        }
    }
    public Object[][] obtenerDatosActuales(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();

        Object[][] datos = new Object[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                datos[i][j] = model.getValueAt(i, j);
            }
        }

        return datos;
    }
    
}
    
    

