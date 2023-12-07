package Modelo;       
        
        
        
public class Empleado {
    
    private int idempleado;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String sexo;
    private double sueldo;
    private String indicador;
    
    public Empleado(){} 

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
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

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

   

   
    
    
    
public Object[] Registro(int num){
           Object[] fila = {num,idempleado,dni,nombre,apellido,telefono,correo,sexo,sueldo};
        return fila;
    } 
    
}