package Procesos;
import Modelo.*;
import Vista.*; 
public class categoriaProcesos extends MoveJFrame {
    
    public void show (frmCategoria f1) {       
        moveFrm(f1, f1.jMenuBar1);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
    }    
    public static Categoria leer (frmCategoria f1) {
        Categoria c = new Categoria();         
        c.setNombrecategoria(f1.txtnombre.getText());        
        return c;
    }
    
}
