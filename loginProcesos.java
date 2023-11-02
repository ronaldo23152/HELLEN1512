/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Format.*;

import Vista.login;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class loginProcesos {
    
    login login;
    
    public void show (login login) {
        this.login = login;        
      
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    } 
    
}
