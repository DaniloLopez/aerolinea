package LogicaAccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo López - dlopezs@unicauca.edu.co
 */
public class Persona {
    Conexion con = new Conexion();
    
    public boolean estaCedula(String cedula){
        try {
            ResultSet res = con.consulta("select * from persona where per_cedula = '" + cedula + "'");
            return res.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean agregarPersona(String cedula, String nombre, String apellido, String direccion, String nacionalidad) {
        try {
            int res = con.agregar("insert into persona(PER_CEDULA,PER_NOMBRE,PER_APELLIDO,PER_NACIONALIDAD,PER_DIRECCION)values('"+cedula+"','"+nombre+"','"+apellido+"','"+nacionalidad+"','"+direccion+"')");
            return res == 1;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public boolean agregarEmpleado(String cedula, String nombre, String apellido, String direccion, String nacionalidad, String salario, String cargo, String estado) {
        try {
            int res = con.agregar("insert into persona(PER_CEDULA,PER_NOMBRE,PER_APELLIDO,PER_NACIONALIDAD,PER_DIRECCION)values('"+cedula+"','"+nombre+"','"+apellido+"','"+nacionalidad+"','"+direccion+"')");
            int res2 = con.agregar("insert into Empleado(PER_CEDULA,EMP_SALARIO,EMP_TIPO_CARGO,EMP_ESTADO)values('"+cedula+"','"+salario+"','"+cargo+"','"+estado+"')");
            return res == 1 && res2 == 1; 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet consultarEmpleados() {        
        try {
            ResultSet res = con.consulta("select PERSONA.per_cedula, per_nombre, per_apellido, per_nacionalidad, per_direccion, emp_tipo_cargo, emp_salario, EMP_ESTADO from PERSONA inner JOIN EMPLEADO on EMPLEADO.PER_CEDULA = PERSONA.PER_CEDULA");
            return res;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public boolean agregarPiloto(String cedula, String nombre, String apellido, String direccion, String nacionalidad, String licencia, String categoria) {
        try {
            int res = con.agregar("insert into persona(PER_CEDULA,PER_NOMBRE,PER_APELLIDO,PER_NACIONALIDAD,PER_DIRECCION)values('"+cedula+"','"+nombre+"','"+apellido+"','"+nacionalidad+"','"+direccion+"')");
            int res2 = con.agregar("insert into Piloto (PER_CEDULA,PIL_LICENCIA,PIL_CATEGORIA)values('" + cedula + "','" + licencia + "','" + categoria + "')");
            return res == 1 && res2 == 1; 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean estaLicenciaPiloto(String licencia) {
        try {
            ResultSet res = con.consulta("select * from piloto where pil_licencia = '" + licencia + "'");
            return res.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }           

    public ResultSet consultarPilotos() {        
        try {
            ResultSet res = con.consulta("select PERSONA.per_cedula, per_nombre, per_apellido, per_nacionalidad, per_direccion, PIL_LICENCIA, PIL_CATEGORIA \n" +
                                            "from PERSONA inner JOIN PILOTO on PILOTO.PER_CEDULA = PERSONA.PER_CEDULA");
            return res;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet consultarPersonas() {
        try {                        
            ResultSet res = con.consulta("select * from persona where per_cedula not in (select per_cedula from piloto) and per_cedula not in (select per_cedula from empleado)");
            return res;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
