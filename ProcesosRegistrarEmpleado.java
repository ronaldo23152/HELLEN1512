package Procesos;

import Modelo.Empleado;
import Vista.ifrmRegistrarEmpleado;

public class ProcesosRegistrarEmpleado {
    public  void Presentacion (ifrmRegistrarEmpleado ifrcempleado){
        ifrcempleado.setTitle("Registro de empleados");
        ifrcempleado.setVisible(true);
        cbxsexo(ifrcempleado);
        
    }    
    public static void LimpiarEntradas(ifrmRegistrarEmpleado ifrcempleado){        
        ifrcempleado.txtdni.setText("");
        ifrcempleado.txtnombre.setText("");
        ifrcempleado.txtapellido.setText("");
        ifrcempleado.txttelefono.setText("");
        ifrcempleado.txtcorreo.setText("");
        ifrcempleado.cbxsexo.setSelectedIndex(0);
        ifrcempleado.txtsueldo.setText("");
        ifrcempleado.txtnombre.requestFocus();
}
    public static Empleado LeerDatos(ifrmRegistrarEmpleado ifrcempleado){
        Empleado e = new Empleado();
        e.setDni(ifrcempleado.txtdni.getText());
        e.setNombre(ifrcempleado.txtnombre.getText());
        e.setApellido(ifrcempleado.txtapellido.getText());
        e.setTelefono(ifrcempleado.txttelefono.getText());
        e.setCorreo(ifrcempleado.txtcorreo.getText());
        e.setSexo(ifrcempleado.cbxsexo.getSelectedItem().toString());   
        e.setSueldo(Double.parseDouble(ifrcempleado.txtsueldo.getText()));  
        return e;
}
    public  void cbxsexo(ifrmRegistrarEmpleado ifrcempleado) {
        ifrcempleado.cbxsexo.removeAllItems();
        String[] sexo = {"F","M"};
        
        for (String x : sexo) {
            ifrcempleado.cbxsexo.addItem(x);
        }
    }
    
}