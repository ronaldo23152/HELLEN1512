
package DAO;
import Format.*;
import java.sql.*;


public class ConexiónDB implements parámetros {
    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;
    public ResultSetMetaData mdata;    

    public ConexiónDB() {
        try {       
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
          
        } catch (Exception ex) {
            Mensajes1.M1("Something went wrong... -_-" + ex);
        }
       
    }   

 
}
