package Controlador;

//librerias

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Formato.*;
import Main.*;
import javax.swing.JFrame;

public class ControladorMenu implements ActionListener {
    frmMenu fmenu;
    
    public ControladorMenu (frmMenu fmenu){
        this.fmenu = fmenu;
        this.fmenu.mitemRegistrarProducto.addActionListener(this);
        this.fmenu.mitemRegistrarCategoria.addActionListener(this);
        this.fmenu.mitemRegistrarMaterial.addActionListener(this);
        this.fmenu.mitemRegistrarColor.addActionListener(this);
        this.fmenu.mitemConsultarStock.addActionListener(this);
        this.fmenu.mitemProducto.addActionListener(this);
        this.fmenu.mitemCategoria.addActionListener(this);
        this.fmenu.mitemMaterial.addActionListener(this);
        this.fmenu.mitemColor.addActionListener(this);
        this.fmenu.mitemVentas.addActionListener(this);
        this.fmenu.mitemPedidos.addActionListener(this);
        this.fmenu.mitemRegistrarClientes.addActionListener(this);
        this.fmenu.mitemClientes.addActionListener(this);
        this.fmenu.mitemRegistrarEmpleados.addActionListener(this);
        this.fmenu.mitemEmpleados.addActionListener(this);
        fmenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fmenu.setDefaultCloseOperation(fmenu.EXIT_ON_CLOSE);
        fmenu.setVisible(true);
        fmenu.setTitle("HELLEN1512");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //categorias
        if(e.getSource()==fmenu.mitemRegistrarCategoria){           
            Main.ifrcategoria = new ifrmRegistrarCategoria();
            Main.crcategoria = new ControladorRegistrarCategoria(Main.ifrcategoria);
            fmenu.escritorio.add(Main.ifrcategoria);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrcategoria);
        }
        if(e.getSource()==fmenu.mitemCategoria){
            Main.ifmcategoria = new ifrmMantenimientoCategoria();
            Main.cmcategoria = new ControladorMantenimientoCategoria(Main.ifmcategoria);
            fmenu.escritorio.add(Main.ifmcategoria);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmcategoria);
        }
        
        //productos
        if(e.getSource()==fmenu.mitemRegistrarProducto){
            Main.ifrproducto = new ifrmRegistrarProducto();
            Main.crproducto = new ControladorRegistrarProducto(Main.ifrproducto);
            fmenu.escritorio.add(Main.ifrproducto);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrproducto);
        }
        if(e.getSource()==fmenu.mitemProducto){
            Main.ifmproducto = new ifrmMantenimientoProducto();
            Main.cmproducto = new ControladorMantenimientoProducto(Main.ifmproducto);
            fmenu.escritorio.add(Main.ifmproducto);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmproducto);
        }
        
        //color
        if(e.getSource()==fmenu.mitemRegistrarColor){
            Main.ifrcolor = new ifrmRegistrarColor();
            Main.crcolor = new ControladorRegistrarColor(Main.ifrcolor);
            fmenu.escritorio.add(Main.ifrcolor);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrcolor);
        }
        if(e.getSource()==fmenu.mitemColor){
            Main.ifmcolor = new ifrmMantenimientoColor();
            Main.cmcolor = new ControladorMantenimientoColor(Main.ifmcolor);
            fmenu.escritorio.add(Main.ifmcolor);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmcolor);
        }
        
        //material
        if(e.getSource()==fmenu.mitemRegistrarMaterial){
            Main.ifrmaterial = new ifrmRegistrarMaterial();
            Main.crmaterial = new ControladorRegistrarMaterial(Main.ifrmaterial);
            fmenu.escritorio.add(Main.ifrmaterial);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrmaterial);
        }
        if(e.getSource()==fmenu.mitemMaterial){
            Main.ifmmaterial = new ifrmMantenimientoMaterial();
            Main.cmmaterial = new ControladorMantenimientoMaterial(Main.ifmmaterial);
            fmenu.escritorio.add(Main.ifmmaterial);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmmaterial);
        }
        
        //clientes
        if(e.getSource()==fmenu.mitemRegistrarClientes){
            Main.ifrcliente = new ifrmRegistrarCliente();
            Main.crcliente = new ControladorRegistrarCliente(Main.ifrcliente);
            fmenu.escritorio.add(Main.ifrcliente);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrcliente);
        }
        if(e.getSource()==fmenu.mitemClientes){
            Main.ifmcliente = new ifrmMantenimientoCliente();
            Main.cmcliente = new ControladorMantenimientoCliente(Main.ifmcliente);
            fmenu.escritorio.add(Main.ifmcliente);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmcliente);
        }
        
        //empleados
        if(e.getSource()==fmenu.mitemRegistrarEmpleados){
            Main.ifrempleado = new ifrmRegistrarEmpleado();
            Main.crempleado = new ControladorRegistrarEmpleado(Main.ifrempleado);
            fmenu.escritorio.add(Main.ifrempleado);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifrempleado);
        }
        if(e.getSource()==fmenu.mitemEmpleados){
            Main.ifmempleado = new ifrmMantenimientoEmpleado();
            Main.cmempleado = new ControladorMantenimientoEmpleado(Main.ifmempleado);
            fmenu.escritorio.add(Main.ifmempleado);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifmempleado);
        }
        //ventas
        if(e.getSource()==fmenu.mitemVentas){
            Main.ifventas = new ifrmVentas();
            Main.cventa = new ControladorVenta(Main.ifventas);
            fmenu.escritorio.add(Main.ifventas);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifventas);
        }
        //pedidos
        if(e.getSource()==fmenu.mitemPedidos){
            Main.ifpedidos = new ifrmPedidos();
            Main.cpedido = new ControladorPedido(Main.ifpedidos);
            fmenu.escritorio.add(Main.ifpedidos);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifpedidos);
        }
        
        //inventario
        if(e.getSource()==fmenu.mitemConsultarStock){
            Main.ifinventario = new ifrmInventario();
            Main.cinventario = new ControladorInventario(Main.ifinventario);
            fmenu.escritorio.add(Main.ifinventario);
            CentrarForma.CPanel(fmenu.escritorio, Main.ifinventario);
        }
    }
    
}
