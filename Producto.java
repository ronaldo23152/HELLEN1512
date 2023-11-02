package Modelo;
//librerias
import lombok.Getter;
import lombok.Setter;
//getter and setter
@Getter
@Setter
//clase
public class Producto {    
//atributos
    private int idproducto;
    private String nombreproducto;
    private int idcategoria;
    private int idmaterial;
    private int idcolor;
    private String tallaproducto;
    private int stockproducto;
    private double precioproducto;
    private String indicador;
//contructor
    public Producto(){}    
//array
    public Object[] RegistroProducto(int numeracion){
        Object[] fila = {numeracion,idproducto,nombreproducto,idcategoria,idmaterial,
            idcolor,tallaproducto,stockproducto,precioproducto};
        return fila;
    }    
}

//fin class