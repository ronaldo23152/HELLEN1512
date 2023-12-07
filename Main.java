package Main;

//librerias
import Controlador.*;
import Vista.*;

public class Main {
    //login
    public static frmLogin flogin;
    public static loginControlador cflogin;
    //menu
    public static frmMenu fmenu;
    public static ControladorMenu cfmenu;

    
    //producto
    public static ifrmRegistrarProducto ifrproducto;
    public static ifrmMantenimientoProducto ifmproducto;
    public static ControladorRegistrarProducto crproducto;
    public static ControladorMantenimientoProducto cmproducto;
    
    //categoria
    public static ifrmRegistrarCategoria ifrcategoria;
    public static ifrmMantenimientoCategoria ifmcategoria;
    public static ControladorRegistrarCategoria crcategoria;
    public static ControladorMantenimientoCategoria cmcategoria;
    
    //color
    public static ifrmRegistrarColor ifrcolor;
    public static ifrmMantenimientoColor ifmcolor;
    public static ControladorRegistrarColor crcolor;
    public static ControladorMantenimientoColor cmcolor;
    
    //material
    public static ifrmRegistrarMaterial ifrmaterial;
    public static ifrmMantenimientoMaterial ifmmaterial;
    public static ControladorRegistrarMaterial crmaterial;
    public static ControladorMantenimientoMaterial cmmaterial;
    
    //empleado
    public static ifrmRegistrarEmpleado ifrempleado;
    public static ifrmMantenimientoEmpleado ifmempleado;
    public static ControladorRegistrarEmpleado crempleado;
    public static ControladorMantenimientoEmpleado cmempleado;
    
    //cliente
    public static ifrmRegistrarCliente ifrcliente;
    public static ifrmMantenimientoCliente ifmcliente;
    public static ControladorRegistrarCliente crcliente;
    public static ControladorMantenimientoCliente cmcliente;
    
    //inventario
    public static ifrmInventario ifinventario;
    public static ControladorInventario cinventario;
    
    //ventas
    public static ifrmVentas ifventas;
    public static ControladorVenta cventa;
    //pedidos
    public static ifrmPedidos ifpedidos;
    public static ControladorPedido cpedido;
  
    public static void main(String[] args) {
        flogin = new frmLogin();
        cflogin = new loginControlador(flogin);
       
    }

}
