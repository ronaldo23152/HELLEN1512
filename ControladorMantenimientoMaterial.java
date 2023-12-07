package Controlador;
//librerias
import DAO.DAOMaterial;
import Modelo.Material;
import Procesos.ProcesosMantenimientoMaterial;
import Vista.ifrmMantenimientoMaterial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;

public class ControladorMantenimientoMaterial implements ActionListener {
    ifrmMantenimientoMaterial ifrm;
    DAOMaterial crud;
    Material material;
    ProcesosMantenimientoMaterial pmmaterial;
    
    public ControladorMantenimientoMaterial(ifrmMantenimientoMaterial ifmmaterial){
    ifrm = ifmmaterial;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        ifrm.btnimprimirpdf.addActionListener(this);
        ProcesosMantenimientoMaterial.Presentacion(ifmmaterial);
        ActualizarForma();
    }

    void ActualizarForma(){
        crud = new DAOMaterial();
        crud.MostrarMateriales(ifrm.tbldatos,ifrm.lblCantidadRegistros);
        ProcesosMantenimientoMaterial.LimpiarEntradas(ifrm);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idmaterial = Mensajes.M2("Ingrese el ID del material");
            crud = new DAOMaterial();
            material = crud.Consultar(idmaterial);
            if (material==null){
                Mensajes.M1("El ID "+idmaterial+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidmaterial.setText(Integer.toString(material.getIdmaterial()));
                ifrm.txtnombre.setText(material.getNombre());
                ifrm.txtdescripcion.setText(material.getDescripcion());
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            material = ProcesosMantenimientoMaterial.LeerDatos(ifrm);
            material.setIdmaterial(Integer.parseInt(ifrm.txtidmaterial.getText()));
            crud = new DAOMaterial();
            crud.Actualizar(material);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idmaterial = Integer.parseInt(ifrm.txtidmaterial.getText());
                crud = new DAOMaterial();
                crud.Eliminar(idmaterial);
                ActualizarForma();
            }
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(material);
                Mensajes.M1("Reporte creado");
            }
}
    
}//fin class
