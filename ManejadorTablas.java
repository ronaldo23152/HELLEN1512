package Format;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
public class ManejadorTablas {
    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   //metodo que la da formato a la JTable del tabla categorias
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,100);       
       AnchoColumnas(tabla,1,100);       
       AnchoColumnas(tabla,2,250);
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       
           
   }
   //metodo que le da formato a la JTable de la tabla colores
   public static void FormatoTablaColores(JTable tabla){
       AnchoColumnas(tabla,0,100);       
       AnchoColumnas(tabla,1,100);       
       AnchoColumnas(tabla,2,250);
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
             
   }
   
   //metodo que da formato al JTable de la tabla materiales
   public static void FormatoTablaMateriales(JTable tabla){
       AnchoColumnas(tabla,0,100);       
       AnchoColumnas(tabla,1,100);       
       AnchoColumnas(tabla,2,200);
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
   }
   //metodo que da formato a la tabla productos
   public static void FormatoTablaProductos(JTable tabla){
       AnchoColumnas(tabla,0,80);       
       AnchoColumnas(tabla,1,150);       
       AnchoColumnas(tabla,2,300);
       AnchoColumnas(tabla,3,150);  
       AnchoColumnas(tabla,4,150);  
       AnchoColumnas(tabla,5,150);        
       AnchoColumnas(tabla,6,200);       
       AnchoColumnas(tabla,7,120);       
       AnchoColumnas(tabla,8,120);
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);
       JustificarCelda(tabla,4);
       JustificarCelda(tabla,5);
       JustificarCelda(tabla,6);
       JustificarCelda(tabla,7);
       JustificarCelda(tabla,8);
       
   }
}
