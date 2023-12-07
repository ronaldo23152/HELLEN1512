package Controlador;
//import
import DAO.DAOProducto;
import Formato.AdministrarClaves;
import Modelo.Producto;
import Procesos.ProcesosMantenimientoProducto;
import Vista.ifrmMantenimientoProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;

public class ControladorMantenimientoProducto implements ActionListener {
    
    ifrmMantenimientoProducto ifrm;
    DAOProducto crud;
    Producto producto;
    ProcesosMantenimientoProducto pmproducto;
    String consulta = "select * from productos where indicador='S'";
    
    public ControladorMantenimientoProducto(ifrmMantenimientoProducto ifmproducto){
    ifrm = ifmproducto;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        ifrm.btnimprimirpdf.addActionListener(this);
        pmproducto = new ProcesosMantenimientoProducto();
        pmproducto.Presentacion(ifmproducto);
        ActualizarForma();
         
           
    }
    
    void ActualizarForma(){
        crud = new DAOProducto();
        crud.MostrarProductos(ifrm.tbldatos,consulta,ifrm.lblCantidadRegistros);     
        ProcesosMantenimientoProducto.LimpiarEntradas(ifrm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idproducto = Mensajes.M2("Ingrese el ID del producto");
            crud = new DAOProducto();
            producto = crud.Consultar(idproducto);
         
            
            if (producto==null){
                Mensajes.M1("El ID "+idproducto+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidproducto.setText(Integer.toString(producto.getIdproducto()));
                ifrm.txtnombre.setText(producto.getNombre());
                ifrm.txtdescripcion.setText(producto.getDescripcion());
                ifrm.txtprecio.setText(Double.toString(producto.getPrecio()));
                ifrm.txtstock.setText(Integer.toString(producto.getStock()));
                ifrm.cbxcategoria.setSelectedItem(producto.getIdcategoria());
                ifrm.cbxcolor.setSelectedItem(producto.getIdcolor());
                ifrm.cbxmaterial.setSelectedItem(producto.getIdmaterial());
                ifrm.cbxtalla.setSelectedItem(producto.getTalla());  
                    
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            producto = ProcesosMantenimientoProducto.LeerDatos(ifrm);
            producto.setIdproducto(Integer.parseInt(ifrm.txtidproducto.getText()));
            crud = new DAOProducto();
            crud.Actualizar(producto);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idproducto = Integer.parseInt(ifrm.txtidproducto.getText());
                crud = new DAOProducto();
                crud.Eliminar(idproducto);
                ActualizarForma();
            }
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(producto);
                Mensajes.M1("Reporte creado");
            }
}
    
}//fin class
