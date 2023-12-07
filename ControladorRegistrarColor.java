package Controlador;
//librerias
import DAO.DAOColor;
import Modelo.Color;
import Procesos.ProcesosRegistrarColor;
import Vista.ifrmRegistrarColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarColor implements ActionListener {
    ifrmRegistrarColor ifrm;
    DAOColor crud;
    Color color;
    
    public ControladorRegistrarColor(ifrmRegistrarColor ifrcolor) {
        ifrm = ifrcolor;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ProcesosRegistrarColor.Presentacion(ifrm);
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            color = ProcesosRegistrarColor.LeerDatos(ifrm);
            crud = new DAOColor();
            crud.Insertar(color);
            ProcesosRegistrarColor.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }
    
}//fin class
