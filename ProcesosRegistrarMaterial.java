package Procesos;
//libreria
import Modelo.Material;
import Vista.ifrmRegistrarMaterial;
public class ProcesosRegistrarMaterial {
    public static void Presentacion (ifrmRegistrarMaterial ifrmaterial){
        ifrmaterial.setTitle("Registro de materiales");
        ifrmaterial.setVisible(true);
    }    
    public static void LimpiarEntradas(ifrmRegistrarMaterial ifrmaterial){        
        ifrmaterial.txtnombre.setText("");
        ifrmaterial.txtdescripcion.setText("");
        ifrmaterial.txtnombre.requestFocus();
}
    public static Material LeerDatos(ifrmRegistrarMaterial ifrmaterial){
        Material material = new Material();
        material.setNombre(ifrmaterial.txtnombre.getText());
        material.setDescripcion(ifrmaterial.txtdescripcion.getText());        
        return material;
}
}
