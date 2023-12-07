package DAO;

import static DAO.Parametros.CLAVE;
import static DAO.Parametros.DRIVER;
import static DAO.Parametros.RUTA;
import static DAO.Parametros.USUARIO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Cliente;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class DAOCliente extends ConectarBD {

    public DAOCliente() {
    }
    public void MostrarClientes(JTable t, JLabel l){
        String[] titulos ={"Nro","idcliente","dni","nombre","apellido","telefono","correo","sexo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Cliente c = new Cliente();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select * from clientes where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                c.setIdcliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setSexo(rs.getString(7));
                c.setIndicador(rs.getString(8));
                modelo.addRow(c.Registro(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaClientes(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los clientes..." + e);
        }
    }     
    public void Insertar (Cliente c) {
        try {            
            ps = conexion.prepareStatement("insert into clientes (dni,nombre,apellido,telefono,correo,sexo,"
                    + "indicador) values (?,?,?,?,?,?,'S');");

            ps.setString(1, c.getDni());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getTelefono());
            ps.setString(5, c.getCorreo());
            ps.setString(6, c.getSexo());            
            ps.executeUpdate();
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los clientes..." + e);
        }        
    }    
    public Cliente Consultar (int idc) {
        Cliente c = null;
        try {
            rs = st.executeQuery("select * FROM clientes where indicador = 'S' and idcliente= "+ idc +";");            
            if (rs.next()) {
                c = new Cliente();
                c.setIdcliente(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setSexo(rs.getString(7));
                
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return c;   
    }
    
    public void Actualizar(Cliente emp){
        try {
            ps = conexion.prepareStatement("update clientes set dni=?,nombre=?,apellido=?,"
                                          +"telefono=?,correo=?,sexo=?"
                                          +"where idcliente=?;");
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getSexo());            
            ps.setInt(7, emp.getIdcliente());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idc){
        try {             
            ps = conexion.prepareStatement("DELETE FROM clientes where idcliente=?;");
            ps.setInt(1, idc);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla clientes");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }   
    public void Imprimirpdf(Cliente c) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
        documento.open();

        PdfPTable tabla = new PdfPTable(6);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Apellido");
        tabla.addCell("Telefono");
        tabla.addCell("Correo");
        tabla.addCell("Sexo");       
        try {            
            try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
            ps = conexion.prepareStatement("SELECT * FROM clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
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