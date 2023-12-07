package Procesos;
//libreria
import Modelo.Color;
import Vista.ifrmMantenimientoColor;
public class ProcesosMantenimientoColor {
    public static void Presentacion (ifrmMantenimientoColor ifmcolor){
        ifmcolor.setTitle("Mantenimiento de colores");
        ifmcolor.setVisible(true); 
    } 
    public static void LimpiarEntradas(ifrmMantenimientoColor ifmcolor){
        ifmcolor.txtidcolor.setText("");
        ifmcolor.txtnombre.setText("");
        ifmcolor.txtdescripcion.setText("");
        ifmcolor.txtidcolor.requestFocus();
    }
    public static Color LeerDatos(ifrmMantenimientoColor ifmcolor){
        Color color = new Color();
        color.setNombre(ifmcolor.txtnombre.getText());
        color.setNombre(ifmcolor.txtdescripcion.getText());
        color.setIdcolor(Integer.parseInt(ifmcolor.txtidcolor.getText()));
        return color;
    }
    
}
