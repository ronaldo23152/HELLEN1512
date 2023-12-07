package DAO;

import static DAO.Parametros.CLAVE;
import static DAO.Parametros.DRIVER;
import static DAO.Parametros.RUTA;
import static DAO.Parametros.USUARIO;
import Formato.ManejadorTablas;
import Formato.Mensajes;
import Modelo.Pedido;
import Modelo.Venta;
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
public class DAOVenta extends ConectarBD {

    public DAOVenta() {
    }
    public void MostrarVentas(JTable t, JLabel l){
        String[] titulos ={"Nro","idventa","producto","cliente","empleado","fecha","cantidad","monto"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        t.setModel(modelo);
        Venta v = new Venta();
        int cantreg = 0;
        try {
            rs = st.executeQuery("select * from ventas where indicador = 'S';");
            while (rs.next()) {                
                cantreg++;
                v.setIdventa(rs.getInt(1));
                v.setIdproducto(rs.getInt(2));
                v.setIdcliente(rs.getInt(3));
                v.setIdempleado(rs.getInt(4));
                v.setFecha(rs.getDate(5));
                v.setCantidad(rs.getInt(6));
                v.setMonto(rs.getDouble(7));                
                v.setIndicador(rs.getString(8));
                modelo.addRow(v.RegistroVenta(cantreg));
            }//fin while
            ManejadorTablas.FormatoTablaVentas(t);
            l.setText("Cantidad de Registros  :" + cantreg);                        
            conexion.close();
        } catch (Exception e) {
           Mensajes.M1("ERROR no se pueden mostrar las ventas..." + e);
        }
    }     
    public void Insertar (Venta v) {
        try {            
            ps = conexion.prepareStatement("insert into ventas (idproducto,idcliente,idempleado,fecha,cantidad,monto,"
                    + "indicador) values (?,?,?,?,?,?,'S');");

            ps.setInt(1, v.getIdproducto());
            ps.setInt(2, v.getIdcliente());
            ps.setInt(3, v.getIdempleado());
            SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(4,sf.format( v.getFecha()));
            ps.setInt(5, v.getCantidad());
            ps.setDouble(6, v.getMonto());                
            ps.executeUpdate();
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede insertar las ventas..." + e);
        }        
    }    
    public Venta Consultar (int idv) {
        Venta v = null;
        try {
            rs = st.executeQuery("select * FROM ventas where indicador = 'S' and idventa= "+ idv +";");            
            if (rs.next()) {
                v = new Venta();
                v.setIdventa(rs.getInt(1));
                v.setIdproducto(rs.getInt(2));
                v.setIdcliente(rs.getInt(3));
                v.setIdempleado(rs.getInt(4));
                v.setFecha(rs.getDate(5));
                v.setCantidad(rs.getInt(6));
                v.setMonto(rs.getDouble(7));             
            }
            rs.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR no se puede consultar el registro..." + e);
    } 
    return v;   
    }
    
    public void Actualizar(Venta v){
        try {
            ps = conexion.prepareStatement("update ventas set idproducto=?,idcliente=?,idempleado=?,"
                                          +"fecha=?,cantidad=?,monto=?"
                                          +"where idventa=?;");
            ps.setInt(1, v.getIdproducto());
            ps.setInt(2, v.getIdcliente());
            ps.setInt(3, v.getIdempleado());
            ps.setDate(4, new java.sql.Date(v.getFecha().getTime()));
            ps.setInt(5, v.getCantidad());
            ps.setDouble(6, v.getMonto());            
            ps.setInt(7 , v.getIdventa());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    public void Eliminar(int idv){
        try {             
            ps = conexion.prepareStatement("DELETE FROM ventas where idventa=?;");
            ps.setInt(1, idv);
            ps.executeUpdate();
           Mensajes.M1("Registro eliminado de la tabla ventas");
            ps.close();
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede eliminar el registro..."+ex);
        }
    }
    public void Imprimirpdf(Venta v) {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));
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
            ps = conexion.prepareStatement("SELECT * FROM ventas");
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
