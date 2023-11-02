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

public class categoriaControlador implements ActionListener {     
    frmCategoria frm;
    categoriaProcesos pro;  
    daoCategoria crud; 
    Categoria cat;
    //PARA EL CAMBIO ENTRE VENTANAS
    frmColor frmColor;
    colorControlador colorControlador;    
    frmProducto frmProducto;
    productoControlador productoControlador;
    frmMaterial frmMaterial;
    materialControlador materialControlador;      
    
    public categoriaControlador(frmCategoria f1) {
        frm=f1;      
        frm.btnregistrar.addActionListener(this);
        frm.btnconsultar.addActionListener(this);
        frm.btnactualizar.addActionListener(this);        
        frm.btneliminar.addActionListener(this);          
        pro = new categoriaProcesos();
        pro.show(f1);  
        ActualizarTabla();
        //PARA EL CAMBIO ENTRE VENTANAS
        frm.jMenuItemColor.addActionListener(this);
        frm.jMenuItemProducto.addActionListener(this);
        frm.jMenuItemMaterial.addActionListener(this);        
    } //PARA RECUPERAR DATOS DESDE LA BASE DE DATOS AL JTABLE
    void ActualizarTabla(){
        crud= new daoCategoria();
        crud.MostrarCategorias(frm.tbldatos,frm.lblcantidadregistros);
    }    
    @Override
    public void actionPerformed(ActionEvent e) {  
        //CRUD CREATE READ UPDATE DELETE
        if (e.getSource() == frm.btnregistrar) {
            cat= categoriaProcesos.leer(frm);
            crud = new daoCategoria();
            crud.Insertar(cat);
            ActualizarTabla();
        }
        if (e.getSource() == frm.btnconsultar) {
            int idcat = Mensajes1.M2( "Escribe el ID de la categoria a consultar:");
            crud = new daoCategoria();
            cat= crud.Consultar(idcat);
            if (cat == null){
                Mensajes1.M1("El id "+idcat+" no existe en la tabla categorias...");
            }else{       
                frm.txtid.setText(Integer.toString(cat.getIdcategoria()));  
                frm.txtnombre.setText(cat.getNombrecategoria());  
            }
        }      
        if (e.getSource() == frm.btnactualizar) {                  
            cat= categoriaProcesos.leer(frm);
            cat.setIdcategoria(Integer.parseInt(frm.txtid.getText()));
            crud= new daoCategoria();
            crud.Actualizar(cat);
            ActualizarTabla();
        }        
        if(e.getSource()== frm.btneliminar){            
            int idcat = Integer.parseInt(frm.txtid.getText());
            crud= new daoCategoria();
            crud.Eliminar(idcat);
            ActualizarTabla();           
        }
        //PARA EL CAMBIO ENTRE VENTANAS
        if(e.getSource() == frm.jMenuItemColor) {
            frmColor = new frmColor();
            colorControlador = new colorControlador(frmColor);
            this.frm.dispose();
        }                   
        if (e.getSource() == frm.jMenuItemProducto) {
            frmProducto= new frmProducto();
            productoControlador = new productoControlador(frmProducto);
            this.frm.dispose();
        }
        if (e.getSource() == frm.jMenuItemMaterial) {
            frmMaterial = new frmMaterial();
            materialControlador = new materialControlador(frmMaterial);
            this.frm.dispose();
        } 
    }    
}
