package Modelo;

//clase
public class Color{
    
//atributos
    private int idcolor;
    private String nombre;
    private String descripcion;
    private String indicador;
   
//constructor
    public Color(){}

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
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
    
    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
  
//array
    public Object[] RegistroColor(int num){
        Object[] fila = {num,idcolor,nombre,descripcion};
        return fila;
    }  
    
}//fin class
