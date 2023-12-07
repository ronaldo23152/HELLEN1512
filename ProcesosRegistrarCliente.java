
package Procesos;

import Modelo.Cliente;
import Vista.ifrmRegistrarCliente;

public class ProcesosRegistrarCliente {
    public  void Presentacion (ifrmRegistrarCliente ifrcliente){
        ifrcliente.setTitle("Registro de clientes");
        ifrcliente.setVisible(true);
        cbxsexo(ifrcliente);
    }    
    public static void LimpiarEntradas(ifrmRegistrarCliente ifrcliente){
        
        ifrcliente.txtdni.setText("");
        ifrcliente.txtnombre.setText("");
        ifrcliente.txtapellido.setText("");
        ifrcliente.txttelefono.setText("");
        ifrcliente.txtcorreo.setText("");
        ifrcliente.cbxsexo.setSelectedIndex(0);
        ifrcliente.txtnombre.requestFocus();
}
    public static Cliente LeerDatos(ifrmRegistrarCliente ifrcliente){
        Cliente c = new Cliente();
        c.setDni(ifrcliente.txtdni.getText());
        c.setNombre(ifrcliente.txtnombre.getText());
        c.setApellido(ifrcliente.txtapellido.getText());
        c.setTelefono(ifrcliente.txttelefono.getText());
        c.setCorreo(ifrcliente.txtcorreo.getText());
        c.setSexo(ifrcliente.cbxsexo.getSelectedItem().toString());   
        return c;
}
    public  void cbxsexo(ifrmRegistrarCliente ifrcliente) {
        ifrcliente.cbxsexo.removeAllItems();
        String[] sexo = {"F","M"};
        
        for (String x : sexo) {
            ifrcliente.cbxsexo.addItem(x);
        }
    }
    
}
