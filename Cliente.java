package Modelo;       
        
        
        
public class Cliente {
    
    private int idcliente;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String sexo;
    private String indicador;
    
    public Cliente(){} 

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    
    
    
public Object[] Registro(int num){
           Object[] fila = {num,idcliente,dni,nombre,apellido,telefono,correo,sexo};
        return fila;
    } 
    
}