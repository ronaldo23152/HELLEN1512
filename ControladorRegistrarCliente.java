package Controlador;
//librerias
import DAO.DAOCliente;
import Modelo.Cliente;
import Procesos.ProcesosRegistrarCliente;
import Vista.ifrmRegistrarCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarCliente implements ActionListener {
    ProcesosRegistrarCliente proceso;
    ifrmRegistrarCliente ifrm;
    DAOCliente crud;
    Cliente cliente;
    
    public ControladorRegistrarCliente(ifrmRegistrarCliente ifrmcliente) {
        ifrm = ifrmcliente;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        proceso = new ProcesosRegistrarCliente();
        proceso.Presentacion(ifrmcliente);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            cliente = ProcesosRegistrarCliente.LeerDatos(ifrm);
            crud = new DAOCliente();
            crud.Insertar(cliente);
            ProcesosRegistrarCliente.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }

}//fin class