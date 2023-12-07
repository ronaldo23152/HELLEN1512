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
import Modelo.Cliente;
import Modelo.Color;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class DAOColor extends ConectarBD{
       public DAOColor(){}
       public void MostrarColores(JTable t, JLabel l){
        String[] titulos ={"Nro", "idcolor", "nombrecolor","descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Color c = new Color();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idcolor, nombre,descripcion,"
                    + "indicador from colores where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                c.setIdcolor(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setIndicador(rs.getString(4));
                modelo.addRow(c.RegistroColor(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaColores(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los colores..." + e);
        }
    }    
    public void Insertar (Color c) {
        try {           
            ps = conexion.prepareStatement("insert into colores (nombre,descripcion, "
                    + "indicador) values (?,?,'S');");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.executeUpdate();
            Mensajes.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los colores..." + e);
        }
    }      
    public Color Consultar (int idcol) {
        Color c = null;
        try {             
            rs = st.executeQuery("select idcolor,nombre,descripcion,indicador "+ 
                "from colores where indicador = 'S' and idcolor="+idcol+";");
            if (rs.next()){
                c = new Color();
                c.setIdcolor(rs.getInt(1));
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
    public void Actualizar (Color c) {
        try {           
            ps = conexion.prepareStatement("UPDATE colores SET nombre=?,descripcion=? WHERE idcolor=?;");
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getIdcolor());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idcol){
        try {             
            ps = conexion.prepareStatement("DELETE FROM colores where idcolor=?;");
            ps.setInt(1, idcol);
            ps.executeUpdate();
            Mensajes.M1("Registro eliminado de la tabla Colores");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
    public void Imprimirpdf(Color c) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Colores.pdf"));
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
            ps = conexion.prepareStatement("SELECT * FROM colores");
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
