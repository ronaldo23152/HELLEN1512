package DAO;
//librerias
import Format.*;
import Modelo.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class daoProducto extends ConexiónDB {
    public daoProducto(){}
    public void MostrarProductos(JTable t, JLabel l){
        String[] titulos ={"Nro","id producto","Nombre producto","id categoria","id material","id color","talla","stock","precio"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Producto p = new Producto();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select * from productos where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                p.setIdproducto(rs.getInt(1));
                p.setNombreproducto(rs.getString(2));
                p.setIdcategoria(rs.getInt(3));
                p.setIdmaterial(rs.getInt(4));
                p.setIdcolor(rs.getInt(5));
                p.setTallaproducto(rs.getString(6));
                p.setStockproducto(rs.getInt(7));
                p.setPrecioproducto(rs.getDouble(8));
                p.setIndicador(rs.getString(9));
                modelo.addRow(p.RegistroProducto(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaProductos(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes1.M1("ERROR no se pueden mostrar los productos..." + e);
        }
    }     
    public void Insertar (Producto p) {
        try {            
            ps = conexion.prepareStatement("insert into productos (nombre,idcategoria,idmaterial,idcolor,talla,stock,precio, "
                    + "indicador) values (?,?,?,?,?,?,?,'S');");

            ps.setString(1, p.getNombreproducto());
            ps.setInt(2, p.getIdcategoria());
            ps.setInt(3, p.getIdmaterial());
            ps.setInt(4, p.getIdcolor());
            ps.setString(5, p.getTallaproducto());
            ps.setInt(6, p.getStockproducto());
            ps.setDouble(7, p.getPrecioproducto());
            ps.executeUpdate();
            Mensajes1.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede insertar los productos..." + e);
        }        
    }    
    public Producto Consultar (int idpro) {
        Producto p = null;
        try {
            rs = st.executeQuery("select * FROM productos where indicador = 'S' and idproducto= "+ idpro +";");            
            if (rs.next()) {
                p = new Producto();
                p.setIdproducto(rs.getInt(1));
                p.setNombreproducto(rs.getString(2));
                p.setIdcategoria(rs.getInt(3));
                p.setIdmaterial(rs.getInt(4));
                p.setIdcolor(rs.getInt(5));
                p.setTallaproducto(rs.getString(6));
                p.setStockproducto(rs.getInt(7));
                p.setPrecioproducto(rs.getInt(8));
            }
            rs.close();
        } catch (Exception e) {
            Mensajes1.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return p;   
    }
    
    public void Actualizar(Producto p){
        try {
            ps = conexion.prepareStatement("update productos set nombre=?,idcategoria=?,"
                                          +"idmaterial=?,idcolor=?,talla=?,stock=?,precio=?"
                                          +"where idproducto=?;");
            ps.setString(1, p.getNombreproducto());
            ps.setInt(2, p.getIdcategoria());
            ps.setInt(3, p.getIdmaterial());
            ps.setInt(4, p.getIdcolor());
            ps.setString(5, p.getTallaproducto());
            ps.setInt(6, p.getStockproducto());
            ps.setDouble(7, p.getPrecioproducto());
            ps.setInt(8, p.getIdproducto());
            ps.executeUpdate();
            Mensajes1.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idpro){
        try {             
            ps = conexion.prepareStatement("DELETE FROM productos where idproducto=?;");
            ps.setInt(1, idpro);
            ps.executeUpdate();
           Mensajes1.M1("Registro eliminado de la tabla productos");
            ps.close();
        } catch (Exception ex) {
            Mensajes1.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }   
   
    
}

