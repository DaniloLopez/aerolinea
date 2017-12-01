package LogicaAccesoDatos;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para manejar la coneccion a la base de datos
 */
public class Conexion {
    
    public String url ;
    public String clave;
    public String usuario;
    public Connection con;
    public Statement stmt;

    public Conexion() {
        url = "jdbc:oracle:thin:@localhost:1521:XE";
        clave = "4321";
        usuario = "JUAN";
    }
    
   
    public void habilitar_Conexion(){
        try {
            //Class.forName("oracle.jdbc.driver.oracledriver");
//        DriverManager.registerDriver(new Oracle.jdbc.Driver.OracleDriver());

            con = DriverManager.getConnection(url, usuario, clave);
            con.setAutoCommit(true);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desabilitar_Conexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet consulta(String consulta) throws ClassNotFoundException, SQLException{
        
        habilitar_Conexion();
        ResultSet rset = stmt.executeQuery(consulta);   
//            while(rset.next()){
//                System.out.println(rset.getString(1));
//            }
//          System.out.println("ok");  
            return rset;
    }
    
    public int agregar(String sql) throws SQLException, ClassNotFoundException{
        habilitar_Conexion();
        return stmt.executeUpdate(sql);
    }
    
}
