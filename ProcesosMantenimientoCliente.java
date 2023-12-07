/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Cliente;
import Vista.ifrmMantenimientoCliente;
public class ProcesosMantenimientoCliente {
    
    public  void Presentacion (ifrmMantenimientoCliente ifrmcliente){
        ifrmcliente.setVisible(true);
        ifrmcliente.setTitle("Mantenimiento de clientes");
        cbxsexo(ifrmcliente);
        
    }
     public static void LimpiarEntradas(ifrmMantenimientoCliente ifrmcliente){
        ifrmcliente.txtidcliente.setText("");
        ifrmcliente.txtdni.setText("");
        ifrmcliente.txtnombre.setText("");
        ifrmcliente.txtapellido.setText("");
        ifrmcliente.txttelefono.setText("");
        ifrmcliente.txtcorreo.setText("");        
        ifrmcliente.cbxsexo.setSelectedIndex(0);
        ifrmcliente.txtidcliente.requestFocus();
        
    }
     public static Cliente LeerDatos(ifrmMantenimientoCliente ifrcliente){
        Cliente c = new Cliente();
        c.setDni(ifrcliente.txtdni.getText());
        c.setNombre(ifrcliente.txtnombre.getText());
        c.setApellido(ifrcliente.txtapellido.getText());
        c.setTelefono(ifrcliente.txttelefono.getText());
        c.setCorreo(ifrcliente.txtcorreo.getText());
        c.setSexo(ifrcliente.cbxsexo.getSelectedItem().toString());       
        
        return c;
}
     public  void cbxsexo(ifrmMantenimientoCliente ifrcliente) {
        ifrcliente.cbxsexo.removeAllItems();
        String[] sexo = {"F","M"};
        
        for (String x : sexo) {
            ifrcliente.cbxsexo.addItem(x);
        }
    }
}
