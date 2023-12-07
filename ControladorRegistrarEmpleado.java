package Controlador;
//librerias
import DAO.DAOEmpleado;
import Modelo.Empleado;
import Procesos.ProcesosRegistrarEmpleado;
import Vista.ifrmRegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarEmpleado implements ActionListener {
    ProcesosRegistrarEmpleado proceso;
    ifrmRegistrarEmpleado ifrm;
    DAOEmpleado crud;
    Empleado empleado;
    
    public ControladorRegistrarEmpleado(ifrmRegistrarEmpleado ifrempleado) {
        ifrm = ifrempleado;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        proceso = new ProcesosRegistrarEmpleado();
        proceso.Presentacion(ifrempleado);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            empleado = ProcesosRegistrarEmpleado.LeerDatos(ifrm);
            crud = new DAOEmpleado();
            crud.Insertar(empleado);
            ProcesosRegistrarEmpleado.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }

}//fin class