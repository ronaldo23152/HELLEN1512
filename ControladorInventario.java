package Controlador;
//import

import DAO.*;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Producto;
import Vista.ifrmInventario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorInventario implements ActionListener  {
    ifrmInventario ifrm;
    String consulta = "select idproducto,nombre,descripcion,idcategoria,idmaterial,idcolor,talla,stock,precio from productos where indicador='S'";    
    DAOProducto crud;
    ConectarBD conex;
    Producto producto;
    
    
    public ControladorInventario(ifrmInventario ifinventario){
    ifrm = ifinventario;
        ifrm.btnbuscar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnimprimirpdf.addActionListener(this);
        ifrm.btnmostrartodos.addActionListener(this);
        ActualizarForma();
        ifrm.setVisible(true);
        
    }
    void ActualizarForma(){
        crud = new DAOProducto();
        crud.MostrarProductos(ifrm.tbldatos,consulta,ifrm.lblCantidadRegistros);
       
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()==ifrm.btnmostrartodos){
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
            crud = new DAOProducto();
            
        }
        if (e.getSource() == ifrm.btnbuscar) {   

    String parametro = ifrm.txtparametro.getText();
    if (parametro.equals("")) {
        
        Mensajes.M1("Ingrese un parámetro a buscar...");
    } else {     
        int criterio = ifrm.cbxcriterio.getSelectedIndex(); 
        crud = new DAOProducto();
        
        switch (criterio) {
            case 0:               
                crud.MostrarProductos(ifrm.tbldatos,
                    consulta + " and nombre like '" + parametro + "%';", ifrm.lblCantidadRegistros);
                break;                
            case 1:               
                crud.MostrarProductos(ifrm.tbldatos,
                    consulta + " and stock >= " + parametro + ";", ifrm.lblCantidadRegistros);
                break;
            case 2:               
                crud.MostrarProductos(ifrm.tbldatos,
                    consulta + " and precio >= " + parametro + ";", ifrm.lblCantidadRegistros);
                break;
           case 3:               
                crud.MostrarProductos(ifrm.tbldatos,
                    consulta + " and talla like '" + parametro + "%';", ifrm.lblCantidadRegistros);
                break;
                
                
       }
    }
}
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud = new DAOProducto();
              Object[][] datosActuales = crud.obtenerDatosActuales(ifrm.tbldatos);
              crud.Imprimirpdfactual(datosActuales);              
                Mensajes.M1("Reporte creado");
            }
       

}   }
    

