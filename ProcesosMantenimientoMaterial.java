package Procesos;
//libreria
import Modelo.Material;
import Vista.ifrmMantenimientoMaterial;
public class ProcesosMantenimientoMaterial {
    public static void Presentacion (ifrmMantenimientoMaterial ifmmaterial){
        ifmmaterial.setTitle("Mantenimiento de categorías");
        ifmmaterial.setVisible(true);
    }   
    public static void LimpiarEntradas(ifrmMantenimientoMaterial ifmmaterial){
        ifmmaterial.txtidmaterial.setText("");
        ifmmaterial.txtnombre.setText("");
        ifmmaterial.txtdescripcion.setText("");
        ifmmaterial.txtidmaterial.requestFocus();
    }
    public static Material LeerDatos(ifrmMantenimientoMaterial ifmmaterial){
        Material material = new Material();
        material.setNombre(ifmmaterial.txtnombre.getText());
        material.setDescripcion(ifmmaterial.txtdescripcion.getText());
        material.setIdmaterial(Integer.parseInt(ifmmaterial.txtidmaterial.getText()));
        return material;
    }
    
}
