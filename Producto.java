package Modelo;

//clase

import Formato.AdministrarClaves;

public class Producto { 
    
//atributos
    private int idproducto;
    private String nombre;
    private String descripcion;
    private int idcategoria;
    private int idmaterial;
    private int idcolor;
    private String talla;
    private int stock;
    private double precio;
    private String indicador;

//contructor
    public Producto(){} 

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    
    
//array
    public Object[] RegistroProducto(int num){
        AdministrarClaves ac1 = new AdministrarClaves();
        String ncategoria = ac1.RecuperarNombre(ac1.cnombrecategoria, idcategoria);
        AdministrarClaves ac2 = new AdministrarClaves();
        String nmaterial = ac2.RecuperarNombre(ac2.cnombrematerial, idmaterial);
        AdministrarClaves ac3 = new AdministrarClaves();
        String ncolor = ac3.RecuperarNombre(ac3.cnombrecolor, idcolor);
        Object[] fila = {num,idproducto,nombre,descripcion,ncategoria,nmaterial,
            ncolor,talla,stock,precio};
        return fila;    }     

}//fin class
    