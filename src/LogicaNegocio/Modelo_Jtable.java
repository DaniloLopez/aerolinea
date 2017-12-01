package LogicaNegocio;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
 


public class Modelo_Jtable{
    
    public DefaultTableModel modelo;
//    public String cabecera[] ={};
//    public String datos[][] ={};
    
    public DefaultTableModel getModelo(String cabecera[]){
        String datos [][] = {};
        modelo = new DefaultTableModel(datos,cabecera);
        
        return modelo;
    }
    
    public void adicionar_Datos_fila(Object datos[]){
        modelo.addRow(datos);
    }

    public void eliminar_fila(int num){
            modelo.removeRow(num);
    }
    
    public void modificar(int fila, int columna,Object obj){
        modelo.setValueAt(obj, fila, columna);
    }
    
    public int cantFilas(){
        return modelo.getRowCount();
    }

    public TableModel getModelo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//con un getCountRow obtenemos el numero total de filas
