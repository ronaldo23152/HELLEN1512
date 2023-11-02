package Modelo;
//librerias
import lombok.Getter;
import lombok.Setter;
//getter and setter
@Getter
@Setter
//clase
public class Categoria {    
//atributos
    private int idcategoria;
    private String nombrecategoria;
    private String indicador;
//constructor
    public Categoria(){}    
//array
    public Object[] RegistroCategoria(int num) {
        Object[] fila = {num,idcategoria,nombrecategoria};
        return fila;
    }  
}
//fin class
