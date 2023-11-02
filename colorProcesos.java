package Procesos;
import Modelo.*; 
import Vista.*;

public class colorProcesos extends MoveJFrame {
    
    public void show (frmColor f1) {             
        moveFrm(f1, f1.jMenuBar1);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
    }
    
    public static Color leer (frmColor f1) {
        Color c = new Color();
        c.setNombrecolor(f1.txtnombre.getText());        
        return c;
    }
    
   
    
    
   
    
}
