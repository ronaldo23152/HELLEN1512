/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;
import DAO.ActualizarCombo;
import Formato.AdministrarClaves;
import Modelo.Pedido;
import Vista.ifrmPedidos;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ProcesosPedido {
    public static void Presentacion (ifrmPedidos ifpedidos){
        ifpedidos.setTitle("Registro de pedidos");
        ifpedidos.setVisible(true);
        ActualizarCombo ac = new ActualizarCombo();
        ac.CargarDatos(ifpedidos.cbxproducto,ac.cproducto);
        ac.CargarDatos(ifpedidos.cbxcliente,ac.ccliente);
        ac.CargarDatos(ifpedidos.cbxempleado,ac.cempleado);
        
    }    
    public static void LimpiarEntradas(ifrmPedidos ifpedidos){        
        ifpedidos.txtidpedido.setText("");
        ifpedidos.cbxproducto.setSelectedIndex(0);
        ifpedidos.txtcantidad.setText(""); 
        ifpedidos.cbxcliente.setSelectedIndex(0);
        ifpedidos.cbxempleado.setSelectedIndex(0);
        Calendar cal = new GregorianCalendar();
        ifpedidos.dchfecha.setCalendar(cal);
        ifpedidos.txtmonto.setText("");          
        ifpedidos.cbxproducto.requestFocus();
}
    public static Pedido LeerDatos(ifrmPedidos ifpedidos){
        Pedido p = new Pedido();
        p.setFecha(ifpedidos.dchfecha.getDate());
        p.setCantidad(Integer.parseInt(ifpedidos.txtcantidad.getText()));
        p.setMonto(Double.parseDouble(ifpedidos.txtmonto.getText()));
        AdministrarClaves ac = new AdministrarClaves();
        p.setIdproducto(ac.RecuperarID(ac.cidproducto, ifpedidos.cbxproducto.getSelectedItem().toString()));
        p.setIdcliente(ac.RecuperarID(ac.cidcliente, ifpedidos.cbxcliente.getSelectedItem().toString()));
        p.setIdempleado(ac.RecuperarID(ac.cidempleado, ifpedidos.cbxempleado.getSelectedItem().toString()));
                
        return p;
}
    
}
