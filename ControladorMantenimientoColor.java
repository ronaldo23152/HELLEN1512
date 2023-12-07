package Controlador;
//librerias
import DAO.DAOColor;
import Modelo.Color;
import Procesos.ProcesosMantenimientoColor;
import Vista.ifrmMantenimientoColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;

public class ControladorMantenimientoColor  implements ActionListener {
    ifrmMantenimientoColor ifrm;
    DAOColor crud;
    Color color;
    ProcesosMantenimientoColor pmcolor;
    
    public ControladorMantenimientoColor(ifrmMantenimientoColor ifmcolor){
    ifrm = ifmcolor;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        ifrm.btnimprimirpdf.addActionListener(this);
        ProcesosMantenimientoColor.Presentacion(ifmcolor);
        ActualizarForma();
    }
    
    void ActualizarForma(){
        crud = new DAOColor();
        crud.MostrarColores(ifrm.tbldatos,ifrm.lblCantidadRegistros);        
        ProcesosMantenimientoColor.LimpiarEntradas(ifrm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idcolor = Mensajes.M2("Ingrese el ID del color");
            crud = new DAOColor();
            color = crud.Consultar(idcolor);
            if (color==null){
                Mensajes.M1("El ID "+idcolor+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidcolor.setText(Integer.toString(color.getIdcolor()));
                ifrm.txtnombre.setText(color.getNombre());
                ifrm.txtdescripcion.setText(color.getDescripcion());
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            color = ProcesosMantenimientoColor.LeerDatos(ifrm);
            color.setIdcolor(Integer.parseInt(ifrm.txtidcolor.getText()));
            crud = new DAOColor();
            crud.Actualizar(color);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idcolor = Integer.parseInt(ifrm.txtidcolor.getText());
                crud = new DAOColor();
                crud.Eliminar(idcolor);
                ActualizarForma();
            }
        }   
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(color);
                Mensajes.M1("Reporte creado");
            }
}
    
}//fin class
