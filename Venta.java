/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Formato.AdministrarClaves;
import java.util.Date;
/**
 *
 * @author Lenovo
 */
public class Venta {
    private int idventa;
    private int idproducto;
    private int idcliente;
    private int idempleado;
    private Date fecha;
    private int cantidad;
    private double monto;
    private String indicador;

    public Venta() {    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    
    
    public Object[] RegistroVenta(int num){
        AdministrarClaves ac1 = new AdministrarClaves();
        String nproducto = ac1.RecuperarNombre(ac1.cnombreproducto, idproducto);
        AdministrarClaves ac2 = new AdministrarClaves();
        String ncliente = ac2.RecuperarNombre(ac2.cnombrecliente, idcliente);
        AdministrarClaves ac3 = new AdministrarClaves();
        String nempleado = ac3.RecuperarNombre(ac3.cnombreempleado, idempleado);
        Object[] fila = {num,idventa,nproducto,ncliente,nempleado,fecha,cantidad,monto};
        return fila;
    } 
    
    
    
    
}
