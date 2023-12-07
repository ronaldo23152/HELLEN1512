/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.Parametros.CLAVE;
import static DAO.Parametros.DRIVER;
import static DAO.Parametros.RUTA;
import static DAO.Parametros.USUARIO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Empleado;
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
public class DAOEmpleado extends ConectarBD {

    public DAOEmpleado() {
    }
    public void MostrarEmpleados(JTable t, JLabel l){
        String[] titulos ={"Nro","idempleado","dni","nombre","apellido","telefono","correo","sexo","sueldo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Empleado emp = new Empleado();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select * from empleados where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                emp.setIdempleado(rs.getInt(1));
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setApellido(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setCorreo(rs.getString(6));
                emp.setSexo(rs.getString(7));
                emp.setSueldo(rs.getDouble(8));
                emp.setIndicador(rs.getString(9));
                modelo.addRow(emp.Registro(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaEmpleados(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los empleados..." + e);
        }
    }     
    public void Insertar (Empleado emp) {
        try {            
            ps = conexion.prepareStatement("insert into empleados (dni,nombre,apellido,telefono,correo,sexo,sueldo, "
                    + "indicador) values (?,?,?,?,?,?,?,'S');");

            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getSexo());
            ps.setDouble(7, emp.getSueldo());
            ps.executeUpdate();
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los empleados..." + e);
        }        
    }    
    public Empleado Consultar (int idemp) {
        Empleado emp = null;
        try {
            rs = st.executeQuery("select * FROM empleados where indicador = 'S' and idempleado= "+ idemp +";");            
            if (rs.next()) {
                emp = new Empleado();
                emp.setIdempleado(rs.getInt(1));
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setApellido(rs.getString(4));
                emp.setTelefono(rs.getString(5));
                emp.setCorreo(rs.getString(6));
                emp.setSexo(rs.getString(7));
                emp.setSueldo(rs.getDouble(8));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return emp;   
    }
    
    public void Actualizar(Empleado emp){
        try {
            ps = conexion.prepareStatement("update clientes set dni=?,nombre=?,apellido=?,"
                                          +"telefono=?,correo=?,sexo=?,sueldo=?"
                                          +"where idempleado=?;");
            ps.setString(1, emp.getDni());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getSexo());
            ps.setDouble(7, emp.getSueldo());
            ps.setInt(8, emp.getIdempleado());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idemp){
        try {             
            ps = conexion.prepareStatement("DELETE FROM empleados where idempleado=?;");
            ps.setInt(1, idemp);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla empleados");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }   
    public void Imprimirpdf(Empleado e) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Empleados.pdf"));
        documento.open();

        PdfPTable tabla = new PdfPTable(7);
        tabla.addCell("ID");
        tabla.addCell("Nombre");
        tabla.addCell("Apellido");
        tabla.addCell("Telefono");
        tabla.addCell("Correo");
        tabla.addCell("Sexo");
        tabla.addCell("Sueldo");
        try {            
            try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
            ps = conexion.prepareStatement("SELECT * FROM empleados");
            rs = ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(rs.getString(7));
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
