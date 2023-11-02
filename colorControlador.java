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
 
public class colorControlador implements ActionListener {    
    frmColor frm;
    colorProcesos pro; 
    daoColor crud;
    Color col;
    //PARA EL CAMBIO ENTRE VENTANAS
    frmCategoria frmCategoria;
    categoriaControlador categoriaControlador;
    frmProducto frmProducto;
    productoControlador productoControlador;
    frmMaterial frmMaterial;
    materialControlador materialControlador;        
    
    public colorControlador (frmColor f1) {
        frm=f1;        
        frm.btnregistrar.addActionListener(this);        
        frm.btnactualizar.addActionListener(this);
        frm.btnconsultar.addActionListener(this);
        frm.btneliminar.addActionListener(this); 
        pro = new colorProcesos();
        pro.show(f1);
        ActualizarTabla();
        //PARA EL CAMBIO ENTRE VENTANAS
        frm.jMenuItemCategoria.addActionListener(this);
        frm.jMenuItemProducto.addActionListener(this);
        frm.jMenuItemMaterial.addActionListener(this);
    }
    void ActualizarTabla(){
        crud= new daoColor();
        crud.MostrarColores(frm.tbldatos,frm.lblcantidadregistros);
    }   
    @Override
    public void actionPerformed(ActionEvent e) {         
        if (e.getSource() == frm.btnregistrar) {
            col = colorProcesos.leer(frm);
            crud = new daoColor();
            crud.Insertar(col);
            ActualizarTabla();
        }        
        if (e.getSource() == frm.btnconsultar) {
            int idcol = Mensajes1.M2( "Escribe el ID del color a consultar:");
            crud = new daoColor();
            col = crud.Consultar(idcol);            
            if (col == null) {
                Mensajes1.M1("El id "+idcol+" no existe en la tabla colores...");
            } else {
                frm.txtid.setText(Integer.toString(col.getIdcolor()));
                frm.txtnombre.setText(col.getNombrecolor());
            }            
        }
        if (e.getSource() == frm.btnactualizar) {
            col = colorProcesos.leer(frm);
            col.setIdcolor(Integer.parseInt(frm.txtid.getText()));
            crud = new daoColor();
            crud.Actualizar(col);
            ActualizarTabla();
        }
        if(e.getSource()== frm.btneliminar){            
            int idcol = Integer.parseInt(frm.txtid.getText());
            crud= new daoColor();
            crud.Eliminar(idcol);
            ActualizarTabla();           
        }
        //PARA EL CAMBIO ENTRE VENTANAS
        if (e.getSource() == frm.jMenuItemCategoria) {
            frmCategoria = new frmCategoria();
            categoriaControlador = new categoriaControlador(frmCategoria);
            this.frm.dispose();
        }        
        if (e.getSource() == this.frm.jMenuItemProducto) {
            frmProducto= new frmProducto();
            productoControlador = new productoControlador(frmProducto);
            this.frm.dispose();
        }
        if (e.getSource() == this.frm.jMenuItemMaterial) {
            frmMaterial = new frmMaterial();
            materialControlador = new materialControlador(frmMaterial);
            this.frm.dispose();
        }
    }        
}
