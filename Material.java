package Modelo;

public class Material extends Producto{    
//atributos
    private int idmaterial;
    private String nombre;    
    private String descripcion;
    private String indicador;    
//constructor
    public Material(){}

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
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
    public Object[] RegistroMaterial(int num){
        Object[] fila = {num,idmaterial,nombre,descripcion};
        return fila;
    }

}
//fin class
