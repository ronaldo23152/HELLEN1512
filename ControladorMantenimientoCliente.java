package Controlador;

//librerias
import DAO.DAOCliente;
import Modelo.Cliente;
import Procesos.ProcesosMantenimientoCliente;
import Vista.ifrmMantenimientoCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;


public class ControladorMantenimientoCliente implements ActionListener {
    ifrmMantenimientoCliente ifrm;
    DAOCliente crud;
    Cliente cliente;
    ProcesosMantenimientoCliente pmcliente;
    
    public ControladorMantenimientoCliente(ifrmMantenimientoCliente ifrmcliente){
        ifrm = ifrmcliente;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        pmcliente = new ProcesosMantenimientoCliente();
        pmcliente.Presentacion(ifrmcliente);
        ActualizarForma();
    }
       
    void ActualizarForma(){
        crud = new DAOCliente();
        crud.MostrarClientes(ifrm.tbldatos,ifrm.lblCantidadRegistros);
        ProcesosMantenimientoCliente.LimpiarEntradas(ifrm);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idcliente = Mensajes.M2("Ingrese el ID del cliente");
            crud = new DAOCliente();
            cliente = crud.Consultar(idcliente);
            if (cliente==null){
                Mensajes.M1("El ID "+idcliente+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidcliente.setText(Integer.toString(cliente.getIdcliente()));
                ifrm.txtdni.setText(cliente.getDni());
                ifrm.txtnombre.setText(cliente.getNombre());
                ifrm.txtapellido.setText(cliente.getApellido());
                ifrm.txttelefono.setText(cliente.getTelefono());
                ifrm.txtcorreo.setText(cliente.getCorreo());
                ifrm.cbxsexo.setSelectedItem(cliente.getSexo());               
                
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            cliente = ProcesosMantenimientoCliente.LeerDatos(ifrm);
            cliente.setIdcliente(Integer.parseInt(ifrm.txtidcliente.getText()));
            crud = new DAOCliente();
            crud.Actualizar(cliente);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idcliente = Integer.parseInt(ifrm.txtidcliente.getText());
                crud = new DAOCliente();
                crud.Eliminar(idcliente);
                ActualizarForma();
            }
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(cliente);
                Mensajes.M1("Reporte creado");
            }
    }
    
    
}