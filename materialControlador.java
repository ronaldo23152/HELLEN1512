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

public class materialControlador implements ActionListener {    
    frmMaterial frm;
    materialProcesos pro;
    daoMaterial crud;
    Material mat;
    //PARA EL CAMBIO ENTRE VENTANAS 
    frmCategoria frmCategoria;
    categoriaControlador categoriaControlador;
    frmColor frmColor;
    colorControlador colorControlador;
    frmProducto frmProducto;
    productoControlador productoControlador;   
    
    public materialControlador (frmMaterial f1) {
        frm=f1;
        frm.btnregistrar.addActionListener(this);
        frm.btnactualizar.addActionListener(this);
        frm.btnconsultar.addActionListener(this);
        frm.btneliminar.addActionListener(this);
        pro = new materialProcesos();
        pro.show(f1);
        ActualizarTabla();
        //PARA EL CAMBIO ENTRE VENTANAS       
        frm.jMenuItemCategoria.addActionListener(this);
        frm.jMenuItemColor.addActionListener(this);
        frm.jMenuItemProducto.addActionListener(this);                
    }//PARA RECUPERAR DATOS DESDE LA BASE DE DATOS AL JTABLE
    void ActualizarTabla(){
        crud= new daoMaterial();
        crud.MostrarMateriales(frm.tbldatos,frm.lblcantidadregistros);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnregistrar) {
            mat= materialProcesos.leer(frm);
            crud = new daoMaterial();
            crud.Insertar(mat);
            ActualizarTabla();
        }
        if (e.getSource() == frm.btnconsultar) {
            int idmat = Mensajes1.M2( "Escribe el ID del material a consultar:");
            crud = new daoMaterial();
            mat= crud.Consultar(idmat);
            if (mat == null){
                Mensajes1.M1("El id "+idmat+" no existe en la tabla materiales...");
            }else{       
                frm.txtid.setText(Integer.toString(mat.getIdmaterial()));  
                frm.txtnombre.setText(mat.getNombrematerial());  
            }
        } 
        if (e.getSource() == frm.btnactualizar) {                  
            mat= materialProcesos.leer(frm);
            mat.setIdmaterial(Integer.parseInt(frm.txtid.getText()));
            crud= new daoMaterial();
            crud.Actualizar(mat);
            ActualizarTabla();
        }
        if(e.getSource()== frm.btneliminar){            
            int idmat = Integer.parseInt(frm.txtid.getText());
            crud= new daoMaterial();
            crud.Eliminar(idmat);
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
        if (e.getSource() == frm.jMenuItemProducto) {
            frmProducto = new frmProducto();
            productoControlador = new productoControlador(frmProducto);
            this.frm.dispose();
        }
    }
}
    

