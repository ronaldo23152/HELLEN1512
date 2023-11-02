package Procesos;
import Modelo.*;
import Vista.*; 

public class materialProcesos extends MoveJFrame {
    
    public void show (frmMaterial f1) {       
        moveFrm(f1, f1.jMenuBar1);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
    }    
    public static Material leer (frmMaterial f1) {
        Material m = new Material();
        m.setNombrematerial(f1.txtnombre.getText());        
        return m;
    }   
    
}
