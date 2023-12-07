package Formato;
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
   
   //metodo que la da formato a la JTable del tabla Categorias
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);     
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
            
   }
   //metodo que le da formato a la JTable de la tabla Colores
   public static void FormatoTablaColores(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);     
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
            
   }
   public static void FormatoTablaMateriales(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);     
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
            
   }
   public static void FormatoTablaProductos(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);     
       AnchoColumnas(tabla,4,100); 
       AnchoColumnas(tabla,5,100); 
       AnchoColumnas(tabla,6,100); 
       AnchoColumnas(tabla,7,300); 
       AnchoColumnas(tabla,8,200); 
       AnchoColumnas(tabla,9,300);        
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
       JustificarCelda(tabla,4); 
       JustificarCelda(tabla,5); 
       JustificarCelda(tabla,6); 
       JustificarCelda(tabla,7); 
       JustificarCelda(tabla,8); 
       JustificarCelda(tabla,9); 
            
   }
   public static void FormatoTablaVentas(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,100);
       AnchoColumnas(tabla,3,100);     
       AnchoColumnas(tabla,4,100); 
       AnchoColumnas(tabla,5,500); 
       AnchoColumnas(tabla,6,300);   
       AnchoColumnas(tabla,7,300); 
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
       JustificarCelda(tabla,4); 
       JustificarCelda(tabla,5); 
       JustificarCelda(tabla,6);  
       JustificarCelda(tabla,7);  
            
   }
   public static void FormatoTablaPedidos(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,100);
       AnchoColumnas(tabla,3,100);     
       AnchoColumnas(tabla,4,100); 
       AnchoColumnas(tabla,5,500); 
       AnchoColumnas(tabla,6,300);   
       AnchoColumnas(tabla,7,300); 
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
       JustificarCelda(tabla,4); 
       JustificarCelda(tabla,5); 
       JustificarCelda(tabla,6);  
       JustificarCelda(tabla,7);  
            
   }
   public static void FormatoTablaClientes(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,250);     
       AnchoColumnas(tabla,4,250); 
       AnchoColumnas(tabla,5,300); 
       AnchoColumnas(tabla,6,500); 
       AnchoColumnas(tabla,7,100);              
       JustificarCelda(tabla,0);
       JustificarCelda(tabla,1);
       JustificarCelda(tabla,2);
       JustificarCelda(tabla,3);      
       JustificarCelda(tabla,4); 
       JustificarCelda(tabla,5); 
       JustificarCelda(tabla,6); 
       JustificarCelda(tabla,7);        
            
   }
   public static void FormatoTablaEmpleados(JTable tabla){
       AnchoColumnas(tabla,0,100);
       AnchoColumnas(tabla,1,100);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,250);     
       AnchoColumnas(tabla,4,250); 
       AnchoColumnas(tabla,5,300); 
       AnchoColumnas(tabla,6,500); 
       AnchoColumnas(tabla,7,100);  
       AnchoColumnas(tabla,8,400); 
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
