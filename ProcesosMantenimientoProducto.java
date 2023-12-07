package Procesos;
//libreria
import DAO.ActualizarCombo;
import DAO.ConectarBD;
import Formato.AdministrarClaves;
import Modelo.Producto;
import Vista.ifrmMantenimientoProducto;

import javax.swing.JOptionPane;
public class ProcesosMantenimientoProducto {
    public   void Presentacion (ifrmMantenimientoProducto ifmproducto){
        ifmproducto.setTitle("Mantenimiento de productos");
        ifmproducto.setVisible(true);        
        ActualizarCombo ac = new ActualizarCombo();        
        ac.CargarDatos(ifmproducto.cbxcategoria,ac.ccategoria);
        ac.CargarDatos(ifmproducto.cbxmaterial,ac.cmaterial);
        ac.CargarDatos(ifmproducto.cbxcolor,ac.ccolor);
        cbxtalla(ifmproducto);
            
    }    
    public static void LimpiarEntradas(ifrmMantenimientoProducto ifmproducto){
        ifmproducto.txtidproducto.setText("");
        ifmproducto.txtnombre.setText("");
        ifmproducto.txtdescripcion.setText("");
        ifmproducto.txtprecio.setText("");
        ifmproducto.txtstock.setText("");
        ifmproducto.cbxcategoria.setSelectedIndex(0);
        ifmproducto.cbxcolor.setSelectedIndex(0);
        ifmproducto.cbxmaterial.setSelectedIndex(0);
        ifmproducto.cbxtalla.setSelectedIndex(0);
        ifmproducto.txtidproducto.requestFocus();

    }
    public static Producto LeerDatos(ifrmMantenimientoProducto ifmproducto){
        Producto producto = new Producto();
        producto.setNombre(ifmproducto.txtnombre.getText());
        producto.setDescripcion(ifmproducto.txtdescripcion.getText());
        AdministrarClaves ac =  new AdministrarClaves();        
        producto.setIdcategoria(ac.RecuperarID(ac.cidcategoria,ifmproducto.cbxcategoria.getSelectedItem().toString()));
        producto.setIdmaterial(ac.RecuperarID(ac.cidmaterial,ifmproducto.cbxmaterial.getSelectedItem().toString()));
        producto.setIdcolor(ac.RecuperarID(ac.cidcolor,ifmproducto.cbxcolor.getSelectedItem().toString()));
        producto.setPrecio(Double.parseDouble(ifmproducto.txtprecio.getText()));
        producto.setStock(Integer.parseInt(ifmproducto.txtstock.getText()));
        producto.setTalla(ifmproducto.cbxtalla.getSelectedItem().toString());
        
        return producto;
    }    
   
     public   void cbxtalla(ifrmMantenimientoProducto f1) {
        f1.cbxtalla.removeAllItems();
        String[] talla = {"PEQUEÑO","MEDIO","LARGO","EXTRALARGO"};
        
        for (String x : talla) {
            f1.cbxtalla.addItem(x);
        }
}
        
    
}