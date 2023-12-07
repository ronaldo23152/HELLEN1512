package DAO;
//librerias
import java.sql.*;
import Formato.*;

public class ConectarBD implements Parametros{
    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;
    public ResultSetMetaData mdata;
    public ConectarBD(){
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
    }
}
