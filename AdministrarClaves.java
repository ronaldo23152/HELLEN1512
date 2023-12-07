package Formato;
import DAO.ConectarBD;


public class AdministrarClaves extends ConectarBD {
    public AdministrarClaves(){}
    
    public String cidcategoria=" select idcategoria from categorias where nombre=?;";
    public String cidmaterial=" select idmaterial from materiales  where nombre=?;";
    public String cidcolor=" select idcolor from colores  where nombre=?;";
    public String cidproducto=" select idproducto from productos  where nombre=?;";
    public String cidcliente=" select idcliente from clientes  where nombre=?;";
    public String cidempleado=" select idempleado from empleados where nombre=?;";
    
    public String cnombrecategoria="select nombre from categorias where idcategoria=?";
    public String cnombrematerial="select nombre from materiales where idmaterial=?";
    public String cnombrecolor="select nombre from colores where idcolor=?";
    public String cnombreproducto="select nombre from productos where idproducto=?";
    public String cnombrecliente="select nombre from clientes where idcliente=?";
    public String cnombreempleado="select nombre from empleados where idempleado=?";

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
            Mensajes.M1("ERROR no se pueden recuperar los nombres..."+ex);
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
            Mensajes.M1("ERROR no se puede recuperar el ID..."+ex);
        }
        return id;
    }
} //finclass
