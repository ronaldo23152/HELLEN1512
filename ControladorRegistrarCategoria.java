package Controlador;
//librerias
import DAO.DAOCategoria;
import Modelo.Categoria;
import Procesos.ProcesosRegistrarCategoria;
import Vista.ifrmRegistrarCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarCategoria implements ActionListener {
    ifrmRegistrarCategoria ifrm;
    DAOCategoria crud;
    Categoria categoria;
    
    public ControladorRegistrarCategoria(ifrmRegistrarCategoria ifrcategoria) {
        ifrm = ifrcategoria;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ProcesosRegistrarCategoria.Presentacion(ifrm);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            categoria = ProcesosRegistrarCategoria.LeerDatos(ifrm);
            crud = new DAOCategoria();
            crud.Insertar(categoria);
            ProcesosRegistrarCategoria.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }

}//fin class
    