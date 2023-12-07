package Procesos;

//libreria 
import Modelo.Color;
import Vista.ifrmRegistrarColor;

public class ProcesosRegistrarColor {
    public static void Presentacion (ifrmRegistrarColor ifrcolor){
        ifrcolor.setTitle("Registro de colores");
        ifrcolor.setVisible(true); 
    }
    public static void LimpiarEntradas(ifrmRegistrarColor ifrcolor){        
        ifrcolor.txtnombre.setText("");
        ifrcolor.txtdescripcion.setText("");
        ifrcolor.txtnombre.requestFocus();
    }
    public static Color LeerDatos(ifrmRegistrarColor ifrcolor){
        Color color = new Color();
        color.setNombre(ifrcolor.txtnombre.getText());
        color.setDescripcion(ifrcolor.txtdescripcion.getText());        
        return color;
    }
}
