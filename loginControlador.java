/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Vista.frmMenu;
import DAO.*;
import Procesos.loginProcesos;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JDLC's Machine
 */
public class loginControlador extends ConectarBD implements ActionListener  {
    
    frmLogin logIn;
    loginProcesos process;
    frmMenu frmMenu;
    ControladorMenu ctrlmenu;    
    ConectarBD connect;
    
    public loginControlador(frmLogin logIn) {
        this.logIn = logIn;
        this.logIn.btningresar.addActionListener(this);
        this.logIn.btnsalir.addActionListener(this);
        process = new loginProcesos();
        process.show(this.logIn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        connect = new ConectarBD();
        
        String USUARIO = logIn.txtuser.getText();
        String PASSWORD = new String(logIn.txtpass.getPassword());
        
        String query =  "SELECT nombre, contraseña "+
                    "FROM usuarios "+ 
                    "WHERE nombre='"+USUARIO+"' AND contraseña='"+PASSWORD+"';";
        if (e.getSource() == this.logIn.btningresar) {
            try {
               
                rs = st.executeQuery(query);
                if (rs.next()){
                    frmMenu = new frmMenu();
                    ctrlmenu = new ControladorMenu(frmMenu);
                    logIn.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == this.logIn.btnsalir) {
            System.exit(0);
        }
    }
    
}
