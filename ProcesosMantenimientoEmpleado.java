/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Empleado;
import Vista.ifrmMantenimientoEmpleado;
public class ProcesosMantenimientoEmpleado {
    
    public  void Presentacion (ifrmMantenimientoEmpleado ifrmempleado){
        ifrmempleado.setVisible(true);
        ifrmempleado.setTitle("Mantenimiento de empleados");
        cbxsexo(ifrmempleado);
        
    }   
     public static void LimpiarEntradas(ifrmMantenimientoEmpleado ifrmempleado){
        ifrmempleado.txtidempleado.setText("");
        ifrmempleado.txtdni.setText("");
        ifrmempleado.txtnombre.setText("");
        ifrmempleado.txtapellido.setText("");
        ifrmempleado.txttelefono.setText("");
        ifrmempleado.txtcorreo.setText("");        
        ifrmempleado.cbxsexo.setSelectedIndex(0);
        ifrmempleado.txtsueldo.setText("");  
        ifrmempleado.txtidempleado.requestFocus();
        
    }
     public static Empleado LeerDatos(ifrmMantenimientoEmpleado ifrmempleado){
        Empleado e = new Empleado();
        e.setDni(ifrmempleado.txtdni.getText());
        e.setNombre(ifrmempleado.txtnombre.getText());
        e.setApellido(ifrmempleado.txtapellido.getText());
        e.setTelefono(ifrmempleado.txttelefono.getText());
        e.setCorreo(ifrmempleado.txtcorreo.getText());
        e.setSexo(ifrmempleado.cbxsexo.getSelectedItem().toString()); 
        e.setSueldo(Double.parseDouble(ifrmempleado.txtsueldo.getText()));
       return e;
}
     public  void cbxsexo(ifrmMantenimientoEmpleado ifrmempleado) {
        ifrmempleado.cbxsexo.removeAllItems();
        String[] sexo = {"F","M"};
        
        for (String x : sexo) {
            ifrmempleado.cbxsexo.addItem(x);
        }
    }
}