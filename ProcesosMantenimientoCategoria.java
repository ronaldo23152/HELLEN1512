package Procesos;

//libreria
import Modelo.Categoria;
import Vista.ifrmMantenimientoCategoria;

public class ProcesosMantenimientoCategoria {
    public static void Presentacion (ifrmMantenimientoCategoria ifmcategoria){
        ifmcategoria.setVisible(true);
        ifmcategoria.setTitle("Mantenimiento de categorías");
        
    }   
    public static void LimpiarEntradas(ifrmMantenimientoCategoria ifmcategoria){
        ifmcategoria.txtidcategoria.setText("");
        ifmcategoria.txtnombre.setText("");
        ifmcategoria.txtdescripcion.setText("");
        ifmcategoria.txtidcategoria.requestFocus();
    }
    public static Categoria LeerDatos(ifrmMantenimientoCategoria ifmcategoria){
        Categoria categoria = new Categoria();
        categoria.setNombre(ifmcategoria.txtnombre.getText());
        categoria.setDescripcion(ifmcategoria.txtdescripcion.getText());
       
        return categoria;
    }
    
}
