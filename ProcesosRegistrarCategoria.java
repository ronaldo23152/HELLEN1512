package Procesos;
import Modelo.Categoria;
import Vista.ifrmRegistrarCategoria;

public class ProcesosRegistrarCategoria {
    public static void Presentacion (ifrmRegistrarCategoria ifrcategoria){
        ifrcategoria.setTitle("Registro de categorías");
        ifrcategoria.setVisible(true);        
        
    }    
    public static void LimpiarEntradas(ifrmRegistrarCategoria ifrcategoria){        
        ifrcategoria.txtnombre.setText("");
        ifrcategoria.txtdescripcion.setText("");
        ifrcategoria.txtnombre.requestFocus();
    }
    public static Categoria LeerDatos(ifrmRegistrarCategoria ifrcategoria){
        Categoria categoria = new Categoria();
        categoria.setNombre(ifrcategoria.txtnombre.getText());
        categoria.setDescripcion(ifrcategoria.txtdescripcion.getText());        
        return categoria;
    }    
}
