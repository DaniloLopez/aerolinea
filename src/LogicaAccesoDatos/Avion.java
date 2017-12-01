package LogicaAccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo López - dlopezs@unicauca.edu.co
 */
public class Avion {
    
    Conexion con = new Conexion();
    
    public boolean estaMatricula(String matricula){
        try {            
            ResultSet res = con.consulta("select * from avion where avi_matricula = '" + matricula + "'");
            return res.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregar(String matricula, String modelo, String sillas, String ubicacion, String estado) {
        try {
           int res = con.agregar("insert into avion(AVI_MATRICULA,AVI_MODELO,AVI_NUM_SILLAS,AVI_UBICACION,AVI_ESTADO)values('"+matricula+"',"+modelo+","+sillas+",'"+ubicacion+"','"+estado+"')");
           return res == 1;                
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ResultSet consultarAviones() {
        try {            
            ResultSet res = con.consulta("select * from avion");
            return res;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
