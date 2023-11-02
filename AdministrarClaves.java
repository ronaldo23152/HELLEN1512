package DAO;
import Format.*;

public class AdministrarClaves extends ConexiónDB {
    public AdministrarClaves(){}
    
    public String consultacat=" select idcategoria from categorias where nombre=?;";
    public String consultamat=" select idmaterial from materiales where nombre=?;";
    public String consultacol=" select idcolor from colores where nombre=?;";
    
    public String consulta1="select nombre from categorias where idcategoria=?";
    public String consulta2="select nombre from proveedores where idproveedor=?";
    public String consulta3="select nombre from productos where idproducto=?";

    public String RecuperarNombre(String consulta,int parametro){
        String nombre="";
        try{
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, parametro);
            rs = ps.executeQuery();
            if(rs.next()){
                nombre = rs.getString(1);
            }
            conexion.close();
        }catch(Exception ex){
            Mensajes1.M1("ERROR no se pueden recuperar los nombres..."+ex);
        }
        return nombre;
    }
    public int RecuperarID(String consulta,String parametro){
        int id=0;
        try{
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, parametro);
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }    
        }catch(Exception ex){
            Mensajes1.M1("ERROR no se puede recuperar el ID..."+ex);
        }
        return id;
    }
} //finclass
