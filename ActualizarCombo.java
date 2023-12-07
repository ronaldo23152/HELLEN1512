package DAO;
//libreria 
import Formato.*;
import javax.swing.JComboBox;
public class ActualizarCombo extends ConectarBD{
    public String ccategoria="select nombre from categorias where indicador='S' order by 1;";
    public String cmaterial="select nombre from materiales where indicador='S' order by 1;";
    public String ccolor="select nombre from colores where indicador='S' order by 1;";
    public String cproducto="select nombre from productos where indicador='S' order by 1;";
    public String ccliente="select nombre from clientes where indicador='S' order by 1;";
    public String cempleado="select nombre from empleados where indicador='S' order by 1;";
    
    public ActualizarCombo(){}
    //metodo que recibe un combobox y una consultay muestra los datos en el combo
    public void CargarDatos(JComboBox combo, String consulta){
        try {
            rs = st.executeQuery(consulta);
            combo.removeAllItems();
            while (rs.next()) {                
                combo.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            Mensajes.M1("ERROR no se puede cargar combo..."+ex);
        }
    }    
}
