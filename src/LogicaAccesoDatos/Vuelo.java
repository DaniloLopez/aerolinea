package LogicaAccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo López - dlopezs@unicauca.edu.co
 */
public class Vuelo {

    Conexion con = new Conexion();
    
    public boolean estaNumeroReferancia(String ref){
        try {            
            ResultSet res = con.consulta("select * from vuelo where vue_num_ref = '" + ref + "'");
            return res.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarVuelo(int ref,String fecha, int duracion, String salida, String llegada, int millas) {
        try {                                               
            int res = con.agregar("INSERT INTO VUELO(VUE_NUM_REF,VUE_FECHA,VUE_DURACION,VUE_AP_SALIDA,VUE_AP_LLEGADA,VUE_MILLAS)VALUES("+ref+",'"+fecha+"',"+duracion+",'"+salida+"','"+llegada+"',"+millas+")");
            return res == 1;                
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet consultarVuelos() {
        try {            
            return con.consulta("select * from vuelo");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public boolean agregarVuelo(int ref, int duracion, String salida, String llegada, int millas) {                
//        try {            
//            Calendar fecha = new GregorianCalendar();
//            int res = con.agregar("INSERT INTO VUELO(VUE_NUM_REF,VUE_FECHA,VUE_DURACION,VUE_AP_SALIDA,VUE_AP_LLEGADA,VUE_MILLAS)VALUES( "+ref+",'"+fecha.getTime()+"',"+duracion+",'"+salida+"','"+llegada+"',"+millas+")");
//            return res == 1;
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(Vuelo.class.getName()).log(Level.SEVERE, null, ex);            
//            return false;
//        }
//    }
}
