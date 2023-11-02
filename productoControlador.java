package Controlador;
//librerias
import DAO.*;
import Format.Mensajes1;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.*;
import java.awt.Button;
import javax.swing.*;

public class productoControlador implements ActionListener {    
    frmProducto frm;
    productoProcesos pro;
    daoProducto crud;
    Producto p;   
    //PARA EL CAMBIO ENTRE VENTANAS    
    frmCategoria frmCategoria;
    categoriaControlador categoriaControlador;
    frmColor frmColor;
    colorControlador colorControlador;   
    frmMaterial frmMaterial;
    materialControlador materialControlador;  
    
    public productoControlador(frmProducto f1) {
        frm=f1;
        frm.btnregistrar.addActionListener(this);
        frm.btnconsultar.addActionListener(this);
        frm.btnactualizar.addActionListener(this);
        frm.btneliminar.addActionListener(this);
        pro = new productoProcesos();
        pro.show(f1);
        ActualizarTabla();
        //PARA EL CAMBIO ENTRE VENTANAS        
        frm.jMenuItemCategoria.addActionListener(this);
        frm.jMenuItemColor.addActionListener(this);
        frm.jMenuItemMaterial.addActionListener(this);
    }
    void ActualizarTabla(){
        crud= new daoProducto();
        crud.MostrarProductos(frm.tbldatos,frm.lblcantidadregistros);
    }

    @Override
    public void actionPerformed(ActionEvent e) {            
        if (e.getSource() == frm.btnregistrar) {
            p = productoProcesos.leer(frm);
            crud= new daoProducto();
            crud.Insertar(p);
            ActualizarTabla();
        }        
        if (e.getSource() == frm.btnconsultar) {
            int idp = Mensajes1.M2( "Escribe el ID del producto a consultar:");
            crud = new daoProducto();
            p = crud.Consultar(idp);            
            if (p == null) {
               Mensajes1.M1("El id "+idp+" no existe en la tabla productos...");
            } else {
                frm.txtid.setText(Integer.toString(p.getIdproducto()));
                frm.txtnombre.setText(p.getNombreproducto());
                frm.cbxcategoria.setSelectedItem(p.getIdcategoria());
                frm.cbxmaterial.setSelectedItem(p.getIdmaterial());
                frm.cbxcolor.setSelectedItem(p.getIdcolor());
                frm.cbxtalla.setSelectedItem(p.getTallaproducto());
                frm.txtstock.setText(Integer.toString(p.getStockproducto()));
                frm.txtprecio.setText(Double.toString(p.getPrecioproducto()));                           
             }                      
        } 
        if (e.getSource() == frm.btnactualizar) {
            p = productoProcesos.leer(frm);
            p.setIdproducto(Integer.parseInt(frm.txtid.getText()));
            crud = new daoProducto();
            crud.Actualizar(p);
            ActualizarTabla();
        }
        if(e.getSource()== frm.btneliminar){            
            int idp = Integer.parseInt(frm.txtid.getText());
            crud= new daoProducto();
            crud.Eliminar(idp);
            ActualizarTabla();           
        }
        //PARA EL CAMBIO ENTRE VENTANAS    
        if (e.getSource() == frm.jMenuItemCategoria) {
            frmCategoria = new frmCategoria();
                categoriaControlador = new categoriaControlador(frmCategoria);
                this.frm.dispose();
        }
        if (e.getSource() == frm.jMenuItemColor) {
            frmColor = new frmColor();
                colorControlador = new colorControlador(frmColor);
                this.frm.dispose();
        }        
        if (e.getSource() == frm.jMenuItemMaterial) {
            frmMaterial = new frmMaterial();
            materialControlador = new materialControlador(frmMaterial);
            this.frm.dispose();
        }            
    }
}