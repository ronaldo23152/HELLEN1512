package DAO;
//librerias
import Format.*;
import Modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class daoCategoria extends ConexiónDB {    
    public daoCategoria(){}
    public void MostrarCategorias(JTable t, JLabel l){
        String[] titulos ={"Nro", "ID_Categoria", "Nombre Categoria"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Categoria c = new Categoria();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select idcategoria, nombre,"
                    + "indicador from categorias where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                c.setIdcategoria(rs.getInt(1));
                c.setNombrecategoria(rs.getString(2));
                c.setIndicador(rs.getString(3));
                modelo.addRow(c.RegistroCategoria(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaCategorias(t);
            l.setText("Cantidad de Registros  :" + cantreg);            
            conexion.close();
        } catch (Exception e) {
           Mensajes1.M1("ERROR no se pueden mostrar las categorias..." + e);
        }
    }   
    public void Insertar(Categoria c) {
        try {           
            ps = conexion.prepareStatement("insert into categorias (nombre, "
                    + "indicador) values (?,'S');");
            ps.setString(1, c.getNombrecategoria());
            ps.executeUpdate();
            Mensajes1.M1("Datos insertados satisfactoriamente.");
            conexion.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede insertar las categorias..." + e);
        }        
    }       
    public Categoria Consultar(int idcat) {        
        Categoria c = null;     
        try {             
            rs = st.executeQuery("select idcategoria,nombre,indicador "+ 
                "from categorias where indicador = 'S' and idcategoria="+idcat+";");
            if (rs.next()){
                c = new Categoria();
                c.setIdcategoria(rs.getInt(1));
                c.setNombrecategoria(rs.getString(2));
                c.setIndicador(rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede consultar el registro..." + e);
        }        
        return c;
    }    
    public void Actualizar (Categoria c) {
        try {           
            ps = conexion.prepareStatement("UPDATE categorias SET nombre=? WHERE idcategoria=?;");
            ps.setString(1, c.getNombrecategoria());
            ps.setInt(2, c.getIdcategoria());
            ps.executeUpdate();
            Mensajes1.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }     
    public void Eliminar(int idcat){
        try {             
            ps = conexion.prepareStatement("DELETE FROM categorias where idcategoria=?;");
            ps.setInt(1, idcat);
            ps.executeUpdate();
           Mensajes1.M1("Registro eliminado de la tabla categorias");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }   
}
