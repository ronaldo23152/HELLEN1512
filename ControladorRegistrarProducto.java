package Controlador;
import DAO.DAOProducto;
import Modelo.Producto;
import Procesos.ProcesosRegistrarProducto;
import Vista.ifrmRegistrarProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarProducto implements ActionListener {
    ProcesosRegistrarProducto proceso;
    ifrmRegistrarProducto ifrm;
    DAOProducto crud;
    Producto producto;
    
    public ControladorRegistrarProducto(ifrmRegistrarProducto ifrproducto) {
        ifrm = ifrproducto;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        proceso = new ProcesosRegistrarProducto();
        proceso.Presentacion(ifrproducto);
} 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            producto = ProcesosRegistrarProducto.LeerDatos(ifrm);
            crud = new DAOProducto();
            crud.Insertar(producto);
            ProcesosRegistrarProducto.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }

}//fin class
