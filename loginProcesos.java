
package Procesos;

import Vista.frmLogin;

public class loginProcesos {    
    frmLogin login;    
    public void show (frmLogin login) {
        this.login = login;              
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    } 
    
}
