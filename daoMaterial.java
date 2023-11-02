package DAO;
//librerias
import Format.*;
import Modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class daoMaterial extends ConexiónDB {
    public daoMaterial(){}
    public void MostrarMateriales(JTable t, JLabel l){
        String[] titulos ={"Nro", "ID Material", "Nombre material"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Material m = new Material();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idmaterial, nombre,"
                    + "indicador from materiales where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                m.setIdmaterial(rs.getInt(1));
                m.setNombrematerial(rs.getString(2));
                m.setIndicador(rs.getString(3));
                modelo.addRow(m.RegistroMaterial(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaMateriales(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes1.M1("ERROR no se pueden mostrar los materiales..." + e);
        }
    }    
    public void Insertar (Material m) {
        try {           
            ps = conexion.prepareStatement("insert into materiales (nombre, "
                    + "indicador) values (?,'S');");
            ps.setString(1, m.getNombrematerial());
            ps.executeUpdate();
            Mensajes1.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede insertar los materiales..." + e);
        }        
    }        
    public Material Consultar(int idmat) {        
        Material m = null;
        try {             
            rs = st.executeQuery("select idmaterial,nombre,indicador "+ 
                "from materiales where indicador = 'S' and idmaterial="+idmat+";");
            if (rs.next()){
                m = new Material();
                m.setIdmaterial(rs.getInt(1));
                m.setNombrematerial(rs.getString(2));
                m.setIndicador(rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede consultar el registro..." + e);
        }        
        return m;
    }     
    public void Actualizar (Material m) {
        try {           
            ps = conexion.prepareStatement("UPDATE materiales SET nombre=? WHERE idmaterial=?;");
            ps.setString(1, m.getNombrematerial());
            ps.setInt(2, m.getIdmaterial());
            ps.executeUpdate();
            Mensajes1.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idmat){
        try {             
            ps = conexion.prepareStatement("DELETE FROM materiales where idmaterial=?;");
            ps.setInt(1, idmat);
            ps.executeUpdate();
           Mensajes1.M1("Registro eliminado de la tabla materiales");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
}
    

