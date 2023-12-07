package Modelo;

//clase
public class Categoria {    
    
//atributos
    private int idcategoria;
    private String nombre;
    private String descripcion;
    private String indicador;
//constructor
    public Categoria(){}    

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
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
    public Object[] RegistroCategoria(int num) {        
        Object[] fila = {num,idcategoria,nombre,descripcion};
        return fila;
    }    

}//fin class
