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
import Modelo.Color;
import Modelo.Material;
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
public class DAOMaterial extends ConectarBD {
    public DAOMaterial(){}
    public void MostrarMateriales(JTable t, JLabel l){
        String[] titulos ={"Nro", "idmaterial", "nombre material","descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Material m = new Material();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idmaterial, nombre,descripcion,"
                    + "indicador from materiales where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                m.setIdmaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setDescripcion(rs.getString(3));
                m.setIndicador(rs.getString(4));
                modelo.addRow(m.RegistroMaterial(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaMateriales(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los materiales..." + e);
        }
    }    
    public void Insertar (Material m) {
        try {           
            ps = conexion.prepareStatement("insert into materiales (nombre,descripcion, "
                    + "indicador) values (?,?,'S');");
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.executeUpdate();
            Mensajes.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los materiales..." + e);
        }        
    }        
    public Material Consultar(int idmat) {        
        Material m = null;
        try {             
            rs = st.executeQuery("select idmaterial,nombre,descripcion,indicador "+ 
                "from materiales where indicador = 'S' and idmaterial="+idmat+";");
            if (rs.next()){
                m = new Material();
                m.setIdmaterial(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setDescripcion(rs.getString(3));
                m.setIndicador(rs.getString(4));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
        }        
        return m;
    }     
    public void Actualizar (Material m) {
        try {           
            ps = conexion.prepareStatement("UPDATE materiales SET nombre=?,descripcion=? WHERE idmaterial=?;");
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.setInt(3, m.getIdmaterial());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idmat){
        try {             
            ps = conexion.prepareStatement("DELETE FROM materiales where idmaterial=?;");
            ps.setInt(1, idmat);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla materiales");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
    public void Imprimirpdf(Material m) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Materiales.pdf"));
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
            ps = conexion.prepareStatement("SELECT * FROM materiales");
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

