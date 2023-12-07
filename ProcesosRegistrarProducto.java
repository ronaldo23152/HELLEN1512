package Procesos;
//libreria
import DAO.ActualizarCombo;
import DAO.ConectarBD;
import Formato.AdministrarClaves;
import Modelo.Producto;
import Vista.ifrmRegistrarProducto;
import javax.swing.JOptionPane;
public class ProcesosRegistrarProducto  {   
    
    public  void Presentacion (ifrmRegistrarProducto ifrproducto){
        ifrproducto.setTitle("Registro de productos");
        ifrproducto.setVisible(true);
        ActualizarCombo ac = new ActualizarCombo();
       ac.CargarDatos(ifrproducto.cbxcategoria,ac.ccategoria);
        ac.CargarDatos(ifrproducto.cbxmaterial,ac.cmaterial);
        ac.CargarDatos(ifrproducto.cbxcolor,ac.ccolor);
        cbxtalla(ifrproducto);
       
      
    }    
    public static void LimpiarEntradas(ifrmRegistrarProducto ifrproducto){        
        ifrproducto.txtnombre.setText("");
        ifrproducto.txtdescripcion.setText("");
        ifrproducto.txtprecio.setText("");
        ifrproducto.txtstock.setText("");
        ifrproducto.cbxcategoria.setSelectedIndex(0);
        ifrproducto.cbxcolor.setSelectedIndex(0);
        ifrproducto.cbxmaterial.setSelectedIndex(0);
        ifrproducto.cbxtalla.setSelectedIndex(0);
        ifrproducto.txtnombre.requestFocus();
}
    public static Producto LeerDatos(ifrmRegistrarProducto ifrproducto){
        Producto producto = new Producto();
        producto.setNombre(ifrproducto.txtnombre.getText());
        producto.setDescripcion(ifrproducto.txtdescripcion.getText());
        AdministrarClaves ac =  new AdministrarClaves();        
        producto.setIdcategoria(ac.RecuperarID(ac.cidcategoria,ifrproducto.cbxcategoria.getSelectedItem().toString()));
        producto.setIdmaterial(ac.RecuperarID(ac.cidmaterial,ifrproducto.cbxmaterial.getSelectedItem().toString()));
        producto.setIdcolor(ac.RecuperarID(ac.cidcolor,ifrproducto.cbxcolor.getSelectedItem().toString()));
        producto.setPrecio(Double.parseDouble(ifrproducto.txtprecio.getText()));
        producto.setStock(Integer.parseInt(ifrproducto.txtstock.getText()));
        producto.setTalla(ifrproducto.cbxtalla.getSelectedItem().toString());
        return producto;
}    
       public   void cbxtalla(ifrmRegistrarProducto f1) {
        f1.cbxtalla.removeAllItems();
        String[] talla = {"PEQUEÑO","MEDIO","LARGO","EXTRALARGO"};
        
        for (String x : talla) {
            f1.cbxtalla.addItem(x);
        }
    }
      
    }
       
       //public void cmbx(frmEstudiante frmEstudiante) {
        //frmEstudiante.cmbxSeleccionarSalón.removeAllItems();
        //String query =  "SELECT ID_SALÓN "+
                           // "FROM SALÓN;";
       // ConexiónDB connect = new ConexiónDB();
       // try {
         //   connect.statement = connect.getConnection().createStatement();
           // connect.resultSet = connect.statement.executeQuery(query);
           // while (connect.resultSet.next()) {
            //   String classroomID = connect.resultSet.getString(1);
             //   frmEstudiante.cmbxSeleccionarSalón.addItem(classroomID);
          //  }
        //} catch (Exception e) {}
   // }
    

