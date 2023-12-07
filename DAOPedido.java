package DAO;

import static DAO.Parametros.CLAVE;
import static DAO.Parametros.DRIVER;
import static DAO.Parametros.RUTA;
import static DAO.Parametros.USUARIO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Pedido;
import Modelo.Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class DAOPedido extends ConectarBD {

    public DAOPedido() {
    }
    public void MostrarPedidos(JTable t, JLabel l){
        String[] titulos ={"Nro","idpedido","producto","cliente","empleado","fecha","cantidad","monto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Pedido p = new Pedido();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select * from pedidos where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                p.setIdpedido(rs.getInt(1));
                p.setIdproducto(rs.getInt(2));
                p.setIdcliente(rs.getInt(3));
                p.setIdempleado(rs.getInt(4));
                p.setFecha(rs.getDate(5));
                p.setCantidad(rs.getInt(6));
                p.setMonto(rs.getDouble(7));                
                p.setIndicador(rs.getString(8));
                modelo.addRow(p.RegistroVenta(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaPedidos(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar los pedidos..." + e);
        }
    }
    
    public void Insertar (Pedido p) {
        try {            
            ps = conexion.prepareStatement("insert into pedidos (idproducto,idcliente,idempleado,fecha,cantidad,monto,"
                    + "indicador) values (?,?,?,?,?,?,'S');");

            ps.setInt(1, p.getIdproducto());
            ps.setInt(2, p.getIdcliente());
            ps.setInt(3, p.getIdempleado());
            SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(4,sf.format(p.getFecha()));
            ps.setInt(5, p.getCantidad());
            ps.setDouble(6, p.getMonto());                
            ps.executeUpdate();
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar los pedidos..." + e);
        }        
    } 
    
    public void Procesar (Pedido p) {
        try {            
            ps = conexion.prepareStatement("insert into ventas (idproducto,idcliente,idempleado,fecha,cantidad,monto,"
                    + "indicador) values (?,?,?,?,?,?,'S');");

            ps.setInt(1, p.getIdproducto());
            ps.setInt(2, p.getIdcliente());
            ps.setInt(3, p.getIdempleado());
            SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(4,sf.format(p.getFecha()));
            ps.setInt(5, p.getCantidad());
            ps.setDouble(6, p.getMonto());                
            ps.executeUpdate();
            Mensajes.M1("Datos procesados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede procesar los pedidos..." + e);
        }        
    }    
    public Pedido Consultar (int idp) {
        Pedido p = null;
        try {
            rs = st.executeQuery("select * FROM pedidos where indicador = 'S' and idpedido= "+ idp +";");            
            if (rs.next()) {
                p = new Pedido();
                p.setIdpedido(rs.getInt(1));
                p.setIdproducto(rs.getInt(2));
                p.setIdcliente(rs.getInt(3));
                p.setIdempleado(rs.getInt(4));
                p.setFecha(rs.getDate(5));
                p.setCantidad(rs.getInt(6));
                p.setMonto(rs.getDouble(7));             
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return p;   
    }
    
    public void Actualizar(Pedido p){
        try {
            ps = conexion.prepareStatement("update pedidos set idpedido=?,idcliente=?,idempleado=?,"
                                          +"fecha=?,cantidad=?,monto=?"
                                          +"where idpedido=?;");
            ps.setInt(1, p.getIdproducto());
            ps.setInt(2, p.getIdcliente());
            ps.setInt(3, p.getIdempleado());
            ps.setDate(4, new java.sql.Date(p.getFecha().getTime()));
            ps.setInt(5, p.getCantidad());
            ps.setDouble(6, p.getMonto());            
            ps.setInt(7 , p.getIdpedido());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idv){
        try {             
            ps = conexion.prepareStatement("DELETE FROM pedidos where idpedido=?;");
            ps.setInt(1, idv);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla pedidos");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
    public void Imprimirpdf(Pedido p) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pedidos.pdf"));
        documento.open();

        PdfPTable tabla = new PdfPTable(7);
        tabla.addCell("ID");
        tabla.addCell("Id producto");
        tabla.addCell("Id cliente");
        tabla.addCell("Id empleado");
        tabla.addCell("Fecha");
        tabla.addCell("Cantidad");
        tabla.addCell("Monto");
        
            
        try {            
            try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA, USUARIO, CLAVE);
            st = conexion.createStatement();
        } catch (Exception ex) {
            Mensajes.M1("ERROR, NO SE PUDO CONECTAR A LA BASE DE DATOS" + ex);
        }
            ps = conexion.prepareStatement("SELECT * FROM pedidos");
            rs = ps.executeQuery();
            while (rs.next()) {
                tabla.addCell(rs.getString(1));
                tabla.addCell(rs.getString(2));
                tabla.addCell(rs.getString(3));
                tabla.addCell(rs.getString(4));
                tabla.addCell(rs.getString(5));
                tabla.addCell(rs.getString(6));
                tabla.addCell(rs.getString(7));
                
            }           
            documento.add(tabla);
        } catch (SQLException ex) {
            ex.printStackTrace();   
        } finally {            
            if (rs != null) rs.close();
            if (ps != null) ps.close();          
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            
            if (documento != null && documento.isOpen()) {
                documento.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
    
    
    
    
    
    
    }
    }
    
}
