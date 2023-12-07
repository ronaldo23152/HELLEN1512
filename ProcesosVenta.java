/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;
import DAO.ActualizarCombo;
import Formato.AdministrarClaves;
import Modelo.Venta;
import Vista.ifrmVentas;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class ProcesosVenta {
    public static void Presentacion (ifrmVentas ifventas){
        ifventas.setTitle("Registro de ventas");
        ifventas.setVisible(true);
        ActualizarCombo ac = new ActualizarCombo();
        ac.CargarDatos(ifventas.cbxproducto,ac.cproducto);
        ac.CargarDatos(ifventas.cbxcliente,ac.ccliente);
        ac.CargarDatos(ifventas.cbxempleado,ac.cempleado);
        
    }    
    public static void LimpiarEntradas(ifrmVentas ifventas){        
        ifventas.txtidventa.setText("");
        ifventas.cbxproducto.setSelectedIndex(0);
        ifventas.txtcantidad.setText(""); 
        ifventas.cbxcliente.setSelectedIndex(0);
        ifventas.cbxempleado.setSelectedIndex(0);
        Calendar cal = new GregorianCalendar();
        ifventas.dchfecha.setCalendar(cal);
        ifventas.txtmonto.setText("");          
        ifventas.cbxproducto.requestFocus();
}
    public static Venta LeerDatos(ifrmVentas ifventas){
        Venta v = new Venta();
        v.setFecha(ifventas.dchfecha.getDate());
        v.setCantidad(Integer.parseInt(ifventas.txtcantidad.getText()));
        v.setMonto(Double.parseDouble(ifventas.txtmonto.getText()));
        AdministrarClaves ac = new AdministrarClaves();
        v.setIdproducto(ac.RecuperarID(ac.cidproducto, ifventas.cbxproducto.getSelectedItem().toString()));
        v.setIdcliente(ac.RecuperarID(ac.cidcliente, ifventas.cbxcliente.getSelectedItem().toString()));
        v.setIdempleado(ac.RecuperarID(ac.cidempleado, ifventas.cbxempleado.getSelectedItem().toString()));
                
        return v;
}
    
}
