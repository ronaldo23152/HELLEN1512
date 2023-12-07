
package Controlador;

import DAO.DAOVenta;
import Formato.Mensajes;
import Modelo.Venta;
import Procesos.ProcesosVenta;
import Vista.ifrmVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ControladorVenta implements ActionListener{
    ifrmVentas ifrm;
    DAOVenta crud;
    Venta venta;
    ProcesosVenta pventa;

    public ControladorVenta(ifrmVentas ifventa) {
       ifrm  = ifventa;
       ifrm.btncerrar.addActionListener(this);
       ifrm.btnimprimirpdf.addActionListener(this);
       ifrm.btnconsultar.addActionListener(this);        
       ifrm.btnregistrar.addActionListener(this);
       ifrm.btnactualizar.addActionListener(this);
       ifrm.btneliminar.addActionListener(this);
       ProcesosVenta.Presentacion(ifventa);
       ActualizarForma();
    }
    void ActualizarForma(){
        crud = new DAOVenta();
        crud.MostrarVentas(ifrm.tbldatos,ifrm.lblCantidadRegistros);            
        ProcesosVenta.LimpiarEntradas(ifrm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()==ifrm.btnactualizar){
            venta = ProcesosVenta.LeerDatos(ifrm);
            venta.setIdventa(Integer.parseInt(ifrm.txtidventa.getText()));
            crud = new DAOVenta();
            crud.Actualizar(venta);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btnconsultar){
            int idventa = Mensajes.M2("Ingrese el ID de la venta");
            crud = new DAOVenta();
            venta = crud.Consultar(idventa);
            if (venta==null){
                Mensajes.M1("El ID "+idventa+"no existe dentro de la tabla. ");
            }else {                
                ifrm.txtidventa.setText(Integer.toString(venta.getIdventa()));
                ifrm.cbxproducto.setSelectedItem(venta.getIdproducto());
                ifrm.cbxcliente.setSelectedItem(venta.getIdcliente());
                ifrm.cbxempleado.setSelectedItem(venta.getIdempleado());
                ifrm.dchfecha.setDate(venta.getFecha());
                ifrm.txtcantidad.setText(Integer.toString(venta.getCantidad()));
                ifrm.txtmonto.setText(Double.toString(venta.getMonto()));
            }
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idventa = Integer.parseInt(ifrm.txtidventa.getText());
                crud = new DAOVenta();
                crud.Eliminar(idventa);
                ActualizarForma();
            }
        }
        if (e.getSource() == ifrm.btnregistrar) {
            venta = ProcesosVenta.LeerDatos(ifrm);
            crud = new DAOVenta();
            crud.Insertar(venta);
            ProcesosVenta.LimpiarEntradas(ifrm);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(venta);
                Mensajes.M1("Reporte creado");
            }
    }
    
    
}
