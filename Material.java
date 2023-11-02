package Modelo;
//librerias
import lombok.Getter;
import lombok.Setter;
//getter and setter
@Getter
@Setter
//clase
public class Material {    
//atributos
    private int idmaterial;
    private String nombrematerial;    
    private String indicador;
//constructor
    public Material(){}
//array
    public Object[] RegistroMaterial(int numeracion){
        Object[] fila = {numeracion,idmaterial,nombrematerial};
        return fila;
    }
}
//fin class
