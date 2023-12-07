package Controlador;

//librerias
import DAO.DAOCategoria;
import Modelo.Categoria;
import Procesos.ProcesosMantenimientoCategoria;
import Vista.ifrmMantenimientoCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formato.Mensajes;


public class ControladorMantenimientoCategoria implements ActionListener {
    ifrmMantenimientoCategoria ifrm;
    DAOCategoria crud;
    Categoria categoria;
    ProcesosMantenimientoCategoria pmcategoria;
    
    public ControladorMantenimientoCategoria(ifrmMantenimientoCategoria ifmcategoria){
        ifrm = ifmcategoria;
        ifrm.btnactualizar.addActionListener(this);
        ifrm.btncerrar.addActionListener(this);
        ifrm.btnconsultar.addActionListener(this);
        ifrm.btneliminar.addActionListener(this);
        ifrm.btnimprimirpdf.addActionListener(this);
        ProcesosMantenimientoCategoria.Presentacion(ifmcategoria);
        ActualizarForma();
    }
       
    void ActualizarForma(){
        crud = new DAOCategoria();
        crud.MostrarCategorias(ifrm.tbldatos,ifrm.lblCantidadRegistros);
        ProcesosMantenimientoCategoria.LimpiarEntradas(ifrm);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ifrm.btnconsultar){
            int idcategoria = Mensajes.M2("Ingrese el ID de la categoria");
            crud = new DAOCategoria();
            categoria = crud.Consultar(idcategoria);
            if (categoria==null){
                Mensajes.M1("El ID "+idcategoria+"no existe dentro de la tabla. ");
            }else {
                ifrm.txtidcategoria.setText(Integer.toString(categoria.getIdcategoria()));
                ifrm.txtnombre.setText(categoria.getNombre());
                ifrm.txtdescripcion.setText(categoria.getDescripcion());
            }
        }
        if(e.getSource()==ifrm.btncerrar){
            ifrm.dispose();
        }
        if(e.getSource()== ifrm.btnactualizar){
            categoria = ProcesosMantenimientoCategoria.LeerDatos(ifrm);
            categoria.setIdcategoria(Integer.parseInt(ifrm.txtidcategoria.getText()));
            crud = new DAOCategoria();
            crud.Actualizar(categoria);
            ActualizarForma();
        }
        if(e.getSource()==ifrm.btneliminar){
            int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
            if (respuesta == 0){
                int idcategoria = Integer.parseInt(ifrm.txtidcategoria.getText());
                crud = new DAOCategoria();
                crud.Eliminar(idcategoria);
                ActualizarForma();
            }
        }
        if(e.getSource()==ifrm.btnimprimirpdf){
              crud.Imprimirpdf(categoria);
                Mensajes.M1("Reporte creado");
            }
        }
    }
    
    

