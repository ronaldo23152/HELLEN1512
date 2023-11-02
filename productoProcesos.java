
package Procesos;
import DAO.*;
import Modelo.*;
import Vista.*;
import javax.swing.JOptionPane;


public class productoProcesos extends MoveJFrame {
    
    public void show (frmProducto f1) {      
        moveFrm(f1, f1.jMenuBar1);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
        cbxtalla(f1);
        cbxcategoria(f1);
        cbxmaterial(f1);
        cbxcolor(f1);
    }    
    public static Producto leer(frmProducto f1) {
        Producto p = new Producto();        
              
        p.setNombreproducto(f1.txtnombre.getText());  
        p.setTallaproducto(f1.cbxtalla.getSelectedItem().toString());
        p.setStockproducto(Integer.parseInt(f1.txtstock.getText()));
        p.setPrecioproducto(Double.parseDouble(f1.txtprecio.getText()));
        AdministrarClaves ac =  new AdministrarClaves();        
        p.setIdcategoria(ac.RecuperarID(ac.consultacat,f1.cbxcategoria.getSelectedItem().toString()));
        p.setIdmaterial(ac.RecuperarID(ac.consultamat,f1.cbxmaterial.getSelectedItem().toString()));
        p.setIdcolor(ac.RecuperarID(ac.consultacol,f1.cbxcolor.getSelectedItem().toString()));
        return p;
    }   
    
    public void cbxcategoria (frmProducto f1) {
        f1.cbxcategoria.removeAllItems();
        
        String query = "SELECT Nombre FROM Categorias;";
        
        ConexiónDB connect = new ConexiónDB();
        try {
            
            connect.rs = connect.st.executeQuery(query);
            while (connect.rs.next()) {
                String nombrecategoria = connect.rs.getString(1);
                f1.cbxcategoria.addItem(nombrecategoria);
            }
            connect.conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (connect.conexion != null) {
                try {
                    connect.conexion.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
    public void cbxmaterial (frmProducto f1) {
        f1.cbxmaterial.removeAllItems();
        
        String query = "SELECT Nombre FROM Materiales;";
        
        ConexiónDB connect = new ConexiónDB();
        try {
            
            connect.rs = connect.st.executeQuery(query);
            while (connect.rs.next()) {
                String nombrematerial = connect.rs.getString(1);
                f1.cbxmaterial.addItem(nombrematerial);
            }
            connect.conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (connect.conexion != null) {
                try {
                    connect.conexion.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
    public void cbxcolor (frmProducto f1) {
        f1.cbxcolor.removeAllItems();
        
        String query = "SELECT Nombre FROM Colores;";
        
        ConexiónDB connect = new ConexiónDB();
        try {
            
            connect.rs = connect.st.executeQuery(query);
            while (connect.rs.next()) {
                String nombrecolor = connect.rs.getString(1);
                f1.cbxcolor.addItem(nombrecolor);
            }
            connect.conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (connect.conexion != null) {
                try {
                    connect.conexion.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
   
     public void cbxtalla(frmProducto f1) {
        f1.cbxtalla.removeAllItems();
        String[] talla = {"PEQUEÑO","MEDIO","LARGO","EXTRALARGO"};
        
        for (String x : talla) {
            f1.cbxtalla.addItem(x);
        }
    }
}
