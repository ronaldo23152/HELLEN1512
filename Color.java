package Modelo;
//librerias
import lombok.Getter;
import lombok.Setter;
//getter and setter
@Getter
@Setter
//clase
public class Color {
//atributos
    private int idcolor;
    private String nombrecolor;    
    private String indicador;
//constructor

    public Color(){   }
  
    
//array
    public Object[] RegistroColor(int numeracion){
        Object[] fila = {numeracion,idcolor,nombrecolor};
        return fila;
    }  
}
//fin class


