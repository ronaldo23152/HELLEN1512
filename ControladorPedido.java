
package Controlador;

import DAO.DAOPedido;
import Formato.Mensajes;
import Modelo.Pedido;
import Modelo.Venta;
import Procesos.ProcesosPedido;
import Vista.ifrmPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ControladorPedido implements ActionListener{
    ifrmPedidos ifrm;
    DAOPedido crud;    
    Pedido pedido;
    Venta venta;
    ProcesosPedido ppedido;

    public ControladorPedido(ifrmPedidos ifpedido) {
       ifrm  = ifpedido;
       ifrm.btncerrar.addActionListener(this);
       ifrm.btnimprimirpdf.addActionListener(this);
       ifrm.btnconsultar.addActionListener(this);        
       ifrm.btnregistrar.addActionListener(this);
       ifrm.btnactualizar.addActionListener(this);
       ifrm.btneliminar.addActionListener(this);
       ifrm.btnprocesar.addActionListener(this);
       ProcesosPedido.Presentacion(ifpedido);
       ActualizarForma();
    }
    void ActualizarForma(){
        crud = new DAOPedido();
        crud.MostrarPedidos(ifrm.tbldatos,ifrm.lblCantidadRegistros);            
        ProcesosPedido.LimpiarEntradas(ifrm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()==ifrm.btnactualizar){
            pedido = ProcesosPedido.LeerDatos(ifrm);
            pedido.setIdpedido(Integer.parseInt(ifrm.txtidpedido.getText()));
            crud = new DAOPedido();
            crud.Actualizar(pedido);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btnconsultar){
            int idpedido = Mensajes.M2("Ingrese el ID del pedido");
            crud = new DAOPedido();
            pedido = crud.Consultar(idpedido);
            if (pedido==null){
                Mensajes.M1("El ID "+idpedido+"no existe dentro de la tabla. ");
            }else {                
                ifrm.txtidpedido.setText(Integer.toString(pedido.getIdpedido()));
                ifrm.cbxproducto.setSelectedItem(pedido.getIdproducto());
                ifrm.cbxcliente.setSelectedItem(pedido.getIdcliente());
                ifrm.cbxempleado.setSelectedItem(pedido.getIdempleado());
                ifrm.dchfecha.setDate(pedido.getFecha());
                ifrm.txtcantidad.setText(Integer.toString(pedido.getCantidad()));
                ifrm.txtmonto.setText(Double.toString(pedido.getMonto()));
            }
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idpedido = Integer.parseInt(ifrm.txtidpedido.getText());
                crud = new DAOPedido();
                crud.Eliminar(idpedido);
                ActualizarForma();
            }
        }
        if (e.getSource() == ifrm.btnregistrar) {
            pedido = ProcesosPedido.LeerDatos(ifrm);
            crud = new DAOPedido();
            crud.Insertar(pedido);
            ProcesosPedido.LimpiarEntradas(ifrm);
            ActualizarForma();
        }
        if (e.getSource() == ifrm.btnprocesar) {
            int respuesta = Mensajes.M3("Confirmar", "¿Desea procesar el pedido?");
            if (respuesta == 0){
                //registrar el pedido en la tabla ventas, mediante crud.procesar
                pedido = ProcesosPedido.LeerDatos(ifrm);
                crud = new DAOPedido();
                crud.Procesar(pedido);        
                //eliminar el pedido
                int idpedido = Integer.parseInt(ifrm.txtidpedido.getText());
                crud = new DAOPedido();
                crud.Eliminar(idpedido);         
                ActualizarForma();
        }
        
    }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(pedido);
                Mensajes.M1("Reporte creado");
            }
        
    
    }
}
