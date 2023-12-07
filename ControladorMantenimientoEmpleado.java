package Controlador;

//librerias
import DAO.DAOEmpleado;
import Modelo.Empleado;
import Procesos.ProcesosMantenimientoEmpleado;
import Vista.ifrmMantenimientoEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;

public class ControladorMantenimientoEmpleado implements ActionListener {
    ifrmMantenimientoEmpleado ifrm;
    DAOEmpleado crud;
    Empleado empleado;
    ProcesosMantenimientoEmpleado pmempleado;
    
    public ControladorMantenimientoEmpleado(ifrmMantenimientoEmpleado ifrmempleado){
        ifrm = ifrmempleado;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        pmempleado = new ProcesosMantenimientoEmpleado();
        pmempleado.Presentacion(ifrmempleado);
        ActualizarForma();
    }
       
    void ActualizarForma(){
        crud = new DAOEmpleado();
        crud.MostrarEmpleados(ifrm.tbldatos,ifrm.lblCantidadRegistros);    
        ProcesosMantenimientoEmpleado.LimpiarEntradas(ifrm);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idempleado = Mensajes.M2("Ingrese el ID del empleado");
            crud = new DAOEmpleado();
            empleado = crud.Consultar(idempleado);
            if (empleado==null){
                Mensajes.M1("El ID "+idempleado+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidempleado.setText(Integer.toString(empleado.getIdempleado()));
                ifrm.txtdni.setText(empleado.getDni());
                ifrm.txtnombre.setText(empleado.getNombre());
                ifrm.txtapellido.setText(empleado.getApellido());
                ifrm.txttelefono.setText(empleado.getTelefono());
                ifrm.txtcorreo.setText(empleado.getCorreo());
                ifrm.cbxsexo.setSelectedItem(empleado.getSexo());
                ifrm.txtsueldo.setText(Double.toString(empleado.getSueldo()));
               
                
               
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            empleado = ProcesosMantenimientoEmpleado.LeerDatos(ifrm);
            empleado.setIdempleado(Integer.parseInt(ifrm.txtidempleado.getText()));
            crud = new DAOEmpleado();
            crud.Actualizar(empleado);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idempleado = Integer.parseInt(ifrm.txtidempleado.getText());
                crud = new DAOEmpleado();
                crud.Eliminar(idempleado);
                ActualizarForma();
            }
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(empleado);
                Mensajes.M1("Reporte creado");
            }
    }
    
    
}