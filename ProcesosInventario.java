package Procesos;
import Vista.ifrmInventario;
import Modelo.Inventario;
public class ProcesosInventario {
    public static void Presentacion(ifrmInventario ifinventario){
        ifinventario.setVisible(true);
        ifinventario.setTitle("Inventario");
    }  
    public static void LimpiarEntradas(ifrmInventario ifinventario){
        ifinventario.txtparametro.setText("");
        ifinventario.cbxcriterio.setSelectedIndex(0);
        ifinventario.txtparametro.requestFocus();
    }
    public static Inventario LeerDatos (ifrmInventario ifinventario){
        Inventario inventario = new Inventario();
        inventario.setCriterio(ifinventario.cbxcriterio.getSelectedItem().toString());
        inventario.setParametro(ifinventario.txtparametro.getText());
        return inventario;
    }

    
}
