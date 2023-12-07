package Controlador;
//librerias
import DAO.DAOMaterial;
import Modelo.Material;
import Procesos.ProcesosRegistrarMaterial;
import Vista.ifrmRegistrarMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRegistrarMaterial implements ActionListener {
    ifrmRegistrarMaterial ifrm;
    DAOMaterial crud;
    Material material;
    
    public ControladorRegistrarMaterial(ifrmRegistrarMaterial ifrmaterial) {
        ifrm = ifrmaterial;
        ifrm.btnregistrar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ProcesosRegistrarMaterial.Presentacion(ifrm);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ifrm.btnregistrar) {
            material = ProcesosRegistrarMaterial.LeerDatos(ifrm);
            crud = new DAOMaterial();
            crud.Insertar(material);
            ProcesosRegistrarMaterial.LimpiarEntradas(ifrm);
        }
        if (e.getSource()==ifrm.btncerrar) {
            ifrm.dispose();
        }
    }
    
}
