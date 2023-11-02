package DAO;
//librerias
import Format.*;
import Modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class daoColor extends ConexiónDB {
    public daoColor(){}
    public void MostrarColores(JTable t, JLabel l){
        String[] titulos ={"Nro", "ID Color", "Nombre Color"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Color c = new Color();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idcolor, nombre,"
                    + "indicador from colores where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                c.setIdcolor(rs.getInt(1));
                c.setNombrecolor(rs.getString(2));
                c.setIndicador(rs.getString(3));
                modelo.addRow(c.RegistroColor(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaColores(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes1.M1("ERROR no se pueden mostrar los colores..." + e);
        }
    }    
    public void Insertar (Color c) {
        try {           
            ps = conexion.prepareStatement("insert into colores (nombre, "
                    + "indicador) values (?,'S');");
            ps.setString(1, c.getNombrecolor());
            ps.executeUpdate();
            Mensajes1.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede insertar los colores..." + e);
        }
    }      
    public Color Consultar (int idcol) {
        Color c = null;
        try {             
            rs = st.executeQuery("select idcolor,nombre,indicador "+ 
                "from colores where indicador = 'S' and idcolor="+idcol+";");
            if (rs.next()){
                c = new Color();
                c.setIdcolor(rs.getInt(1));
                c.setNombrecolor(rs.getString(2));
                c.setIndicador(rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede consultar el registro..." + e);
        }          
        return c;
    }    
    public void Actualizar (Color c) {
        try {           
            ps = conexion.prepareStatement("UPDATE colores SET nombre=? WHERE idcolor=?;");
            ps.setString(1, c.getNombrecolor());
            ps.setInt(2, c.getIdcolor());
            ps.executeUpdate();
            Mensajes1.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idcol){
        try {             
            ps = conexion.prepareStatement("DELETE FROM colores where idcolor=?;");
            ps.setInt(1, idcol);
            ps.executeUpdate();
            Mensajes1.M1("Registro eliminado de la tabla Colores");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    } 
}
