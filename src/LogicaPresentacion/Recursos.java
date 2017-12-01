/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaPresentacion;

import LogicaAccesoDatos.Avion;
import LogicaAccesoDatos.Conexion;
import LogicaAccesoDatos.Persona;
import LogicaAccesoDatos.Vuelo;
import LogicaNegocio.Modelo_Jtable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Danilo
 */
public class Recursos extends javax.swing.JFrame {

    public Modelo_Jtable modAvi = new Modelo_Jtable();
    public Modelo_Jtable modPer = new Modelo_Jtable();
    public Modelo_Jtable modEmp = new Modelo_Jtable();
    public Modelo_Jtable modPil = new Modelo_Jtable();
    public Modelo_Jtable modVue = new Modelo_Jtable();
    
    private Conexion con = new Conexion();
    private Persona acceso_persona = new Persona();
    private Avion acceso_avion = new Avion();
    private Vuelo acceso_vuelo = new Vuelo();
    /**
     * Creates new form inicio
     */
    public Recursos() {        
        try {                                   
            initComponents();
            
            String cabeceraAvi[]={"Matricula","Modelo","Cant Sillas","Ubicacion","Estado"};
            tbl_aviones.setModel(modAvi.getModelo(cabeceraAvi));            
            ResultSet rset = acceso_avion.consultarAviones();
            
            while(rset.next()){
                String matricula = rset.getString(1);
                int modelo = rset.getInt(2);
                int sillas = rset.getInt(3);
                String ubicacion = rset.getString(4);
                String estado = rset.getString(5);                
                Object datos []={matricula,modelo,sillas,ubicacion,estado};
                modAvi.adicionar_Datos_fila(datos);
            }
            
            String cabeceraPer[]={"Cedula","Nombre","apellido","Direccion","Nacionalidad"};
            tbl_personas.setModel(modPer.getModelo(cabeceraPer));            
            //rset = con.consulta("select * from persona");
            rset = acceso_persona.consultarPersonas();
            while(rset.next()){
                String cedula = rset.getString(1);
                String nombre = rset.getString(2);
                String apellido = rset.getString(3);                
                String nacionalidad = rset.getString(4);
                String direccion= rset.getString(5);                
                Object datos []={cedula,nombre,apellido,direccion,nacionalidad};
                modPer.adicionar_Datos_fila(datos);
            }
            
            String cabeceraEmpl[]={"Cedula","Nombre","apellido","Direccion","Nacionalidad","Cargo","Salario","Estado"};
            tbl_empleados.setModel(modEmp.getModelo(cabeceraEmpl));
            rset = acceso_persona.consultarEmpleados();            
            while(rset.next()){
                String cedula = rset.getString(1);
                String nombre = rset.getString(2);
                String apellido = rset.getString(3);                
                String nacionalidad = rset.getString(4);
                String direccion= rset.getString(5);
                String cargo= rset.getString(6);
                Integer salario = rset.getInt(7);
                String estado= rset.getString(8);                
                Object datos []={cedula,nombre,apellido,direccion,nacionalidad,cargo,salario,estado};
                modEmp.adicionar_Datos_fila(datos);
            }
                        
            String cabeceraPil[]={"Cedula","Licencia","Nombre","apellido","Direccion","Nacionalidad","Categoria"};
            tbl_pilotos.setModel(modPil.getModelo(cabeceraPil));
            rset = acceso_persona.consultarPilotos();
            while(rset.next()){
                String cedula = rset.getString(1);
                String nombre = rset.getString(2);
                String apellido = rset.getString(3);                
                String nacionalidad = rset.getString(4);
                String direccion= rset.getString(5);
                String licencia= rset.getString(6);
                String categoria= rset.getString(7);                
                Object datos []={cedula,licencia,nombre,apellido,direccion,nacionalidad,categoria};
                modPil.adicionar_Datos_fila(datos);
            }
            
            String cabeceraVue[]={"Referencia","Fecha","Duracion","Ap Salida","Ap llegada","Millas"};
            tbl_vuelo.setModel(modVue.getModelo(cabeceraVue));
            rset = acceso_vuelo.consultarVuelos();
            while(rset.next()){
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");            
                String fecha = sdf.format(rset.getDate(2));

                String ref = rset.getString(1);
                //Date fecha = rset.getDate(2);
                String duracion = rset.getString(3);                
                String salida = rset.getString(4);
                String llegada = rset.getString(5);
                String millas = rset.getString(6);                
                Object datos []={ref,fecha, duracion, salida,llegada,millas};
                modVue.adicionar_Datos_fila(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_vuelo = new javax.swing.JTable();
        btn_add_vuelo = new javax.swing.JButton();
        btn_mod_vuelo = new javax.swing.JButton();
        btn_eli_vuelo = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btn_eli_persona = new javax.swing.JButton();
        btn_mod_persona = new javax.swing.JButton();
        btn_add_persona = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_personas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_add_aviones = new javax.swing.JButton();
        btn_mod_aviones = new javax.swing.JButton();
        btn_eli_aviones = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_aviones = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_add_empleado = new javax.swing.JButton();
        btn_mod_empleado = new javax.swing.JButton();
        btn_eli_empleado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_empleados = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_add_piloto = new javax.swing.JButton();
        btn_mod_piloto = new javax.swing.JButton();
        btn_eli_piloto = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_pilotos = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("AEROLINEA VUELA-COLOMBIA");

        jTabbedPane6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setText("Gestion de Vuelos");

        jLabel7.setText("Vuelos registrados");

        tbl_vuelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tbl_vuelo);

        btn_add_vuelo.setText("Adicionar");
        btn_add_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_vueloActionPerformed(evt);
            }
        });

        btn_mod_vuelo.setText("Modificar");
        btn_mod_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_vueloActionPerformed(evt);
            }
        });

        btn_eli_vuelo.setText("Eliminar");
        btn_eli_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eli_vueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btn_add_vuelo)
                        .addGap(77, 77, 77)
                        .addComponent(btn_mod_vuelo)
                        .addGap(75, 75, 75)
                        .addComponent(btn_eli_vuelo))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_vuelo)
                            .addComponent(btn_mod_vuelo)
                            .addComponent(btn_eli_vuelo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Vuelos", jPanel1);

        btn_eli_persona.setText("Eliminar");
        btn_eli_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eli_personaActionPerformed(evt);
            }
        });

        btn_mod_persona.setText("Modificar");
        btn_mod_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_personaActionPerformed(evt);
            }
        });

        btn_add_persona.setText("Adicionar");
        btn_add_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_personaActionPerformed(evt);
            }
        });

        tbl_personas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_personas);

        jLabel4.setText("Personas registradas");

        jLabel9.setText("Gestion de Personas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btn_add_persona)
                        .addGap(77, 77, 77)
                        .addComponent(btn_mod_persona)
                        .addGap(75, 75, 75)
                        .addComponent(btn_eli_persona))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_persona)
                            .addComponent(btn_mod_persona)
                            .addComponent(btn_eli_persona)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Personas", jPanel2);

        btn_add_aviones.setText("Adicionar");
        btn_add_aviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_avionesActionPerformed(evt);
            }
        });

        btn_mod_aviones.setText("Modificar");

        btn_eli_aviones.setText("Eliminar");

        jLabel5.setText("Aviones registrados");

        tbl_aviones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbl_aviones);

        jLabel10.setText("Gestion de Aviones");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_aviones)
                        .addGap(77, 77, 77)
                        .addComponent(btn_mod_aviones)
                        .addGap(75, 75, 75)
                        .addComponent(btn_eli_aviones))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_aviones)
                            .addComponent(btn_mod_aviones)
                            .addComponent(btn_eli_aviones)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Aviones", jPanel3);

        btn_add_empleado.setText("Adicionar");
        btn_add_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_empleadoActionPerformed(evt);
            }
        });

        btn_mod_empleado.setText("Modificar");
        btn_mod_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_empleadoActionPerformed(evt);
            }
        });

        btn_eli_empleado.setText("Eliminar");
        btn_eli_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eli_empleadoActionPerformed(evt);
            }
        });

        jLabel6.setText("Empleados registrados");

        tbl_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tbl_empleados);

        jLabel8.setText("Gestion de Empleados");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_empleado)
                        .addGap(77, 77, 77)
                        .addComponent(btn_mod_empleado)
                        .addGap(75, 75, 75)
                        .addComponent(btn_eli_empleado))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_empleado)
                            .addComponent(btn_mod_empleado)
                            .addComponent(btn_eli_empleado)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Empleados", jPanel4);

        jLabel12.setText("Gestion de Pilotos");

        btn_add_piloto.setText("Adicionar");
        btn_add_piloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_pilotoActionPerformed(evt);
            }
        });

        btn_mod_piloto.setText("Modificar");
        btn_mod_piloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mod_pilotoActionPerformed(evt);
            }
        });

        btn_eli_piloto.setText("Eliminar");
        btn_eli_piloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eli_pilotoActionPerformed(evt);
            }
        });

        jLabel13.setText("Pilotos registrados");

        tbl_pilotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tbl_pilotos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add_piloto)
                        .addGap(77, 77, 77)
                        .addComponent(btn_mod_piloto)
                        .addGap(75, 75, 75)
                        .addComponent(btn_eli_piloto))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add_piloto)
                            .addComponent(btn_mod_piloto)
                            .addComponent(btn_eli_piloto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane6.addTab("Pilotos", jPanel5);

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        Inicio as = new Inicio();
        as.setLocationRelativeTo(null);
        as.setTitle("Opciones. Aerolinea Viva-colombia");
        as.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_add_avionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_avionesActionPerformed
        btn_add_avion();
    }//GEN-LAST:event_btn_add_avionesActionPerformed
    private void btn_add_avion(){
        boolean condicion = true;
        ResultSet res;
        JTextField txtMatricula = new JTextField();
        JTextField txtModelo = new JTextField();
        JTextField txtSillas = new JTextField();
        JTextField txtUbicacion = new JTextField();
        String[] estado = {"Seleccione...", "DISPONIBLE", "OCUPADO", "REPARACION"};
        JComboBox jcbEstado = new JComboBox(estado);

        do {
            condicion = false;
            Object[] message = {"Matricula:\t", txtMatricula, "Modelo:\t", txtModelo, "Numero de Sillas:", txtSillas, "Ubicacion:\t", txtUbicacion, "Estado\t", jcbEstado};
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar nuevo Avión", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (!(txtMatricula.getText().equals(""))) {
                    if (!(txtSillas.getText().equals(""))) {
                        if (!(txtModelo.getText().equals(""))) {
                            if (numerico(txtSillas.getText())) {
                                if (numerico(txtModelo.getText())) {
                                    if (!((String) jcbEstado.getSelectedItem()).equals("Seleccione...")) {
                                        if (!acceso_avion.estaMatricula(txtMatricula.getText())) {
                                            String matricula = txtMatricula.getText();
                                            String modelo = txtModelo.getText();
                                            String sillas = txtSillas.getText();
                                            String ubicacion = txtUbicacion.getText();
                                            String estadoInput = (String) jcbEstado.getSelectedItem();
                                            if (acceso_avion.agregar(matricula, modelo, sillas, ubicacion, estadoInput)) {
                                                JOptionPane.showMessageDialog(null, "Avion registrado exitosamente.", "Informe de Estado", JOptionPane.INFORMATION_MESSAGE);
                                                condicion = true;
                                                Object datos[] = {matricula, modelo, sillas, ubicacion, estadoInput};
                                                modAvi.adicionar_Datos_fila(datos);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se pudo completar el registro por un error en la base de datos.\n\nContacte al administrador.", "Informe de estado", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ya Existe un Avion Registrado con la misma Matricula ingresada", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                            txtMatricula.setText("");
                                            condicion = false;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion para el estado del avion", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                        condicion = false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El valor del Modelo debe ser un valor númerico", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                    condicion = false;
                                    txtModelo.setText("");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El número de Sillas debe ser un valor númerico", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                condicion = false;
                                txtSillas.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El campo Modelo no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                            condicion = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo Sillas no debe quedar vacio", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                        condicion = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo Matricula no debe quedar vacio", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
            } else {
                condicion = true;
            }
        } while (!condicion);
    }
    
    private void btn_add_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_personaActionPerformed
        btn_add_persona();
    }//GEN-LAST:event_btn_add_personaActionPerformed
    private void btn_add_persona(){
        boolean condicion;        
        JTextField perCedula = new JTextField();
        JTextField perNombre = new JTextField();
        JTextField perApellido = new JTextField();
        JTextField perDireccion = new JTextField();
        String[] nacionalidad = {"Seleccione...", "COLOMBIA", "PERU", "CHILE", "ARGENTINA", "MEXICO"};
        JComboBox jcbEstado = new JComboBox(nacionalidad);
        do {
            condicion = false;
            Object[] message = {"Cedula:\t", perCedula, "Nombre:\t", perNombre, "Apellido:", perApellido, "Direccion:\t", perDireccion, "Nacionalidad\t", jcbEstado};
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar Persona", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (!(perCedula.getText().equals(""))) {
                    if (!(perNombre.getText().equals(""))) {
                        if (!(perApellido.getText().equals(""))) {
                            if(!((String)jcbEstado.getSelectedItem()).equals("Seleccione...")){
                            if (!acceso_persona.estaCedula(perCedula.getText())) {
                                String cedula = perCedula.getText();
                                String nombre = perNombre.getText();
                                String apellido = perApellido.getText();
                                String direccion = perDireccion.getText();
                                String estadoInput = (String) jcbEstado.getSelectedItem();
                                if (acceso_persona.agregarPersona(cedula, nombre, apellido, direccion, estadoInput)) {
                                    JOptionPane.showMessageDialog(null, "Persona registrada exitosamente.", "Informe de Estado", JOptionPane.INFORMATION_MESSAGE);
                                    condicion = true;
                                    Object datos[] = {cedula, nombre, apellido, direccion, estadoInput};
                                    modPer.adicionar_Datos_fila(datos);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo completar el registro por un error en la base de datos.\n\nContacte al administrador.", "Informe de estado", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Ya Existe una Persona con la misma cedula que ingresó.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                perCedula.setText("");condicion = false;
                            }
                            }else{
                                JOptionPane.showMessageDialog(null,"Debe seleccionar una opción para la nacionalidad de la Persona","Informe de Estado", JOptionPane.ERROR_MESSAGE );
                                condicion = false;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El campo Apellido no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                            condicion = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo Nombre no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                        condicion = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo Cedula no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
            } else {
                condicion = true;
            }
        } while (!condicion);
    }
    
    private void btn_mod_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mod_personaActionPerformed

    private void btn_eli_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eli_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eli_personaActionPerformed

    private void btn_add_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_vueloActionPerformed
        btn_vuelo();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add_vueloActionPerformed
    private void btn_vuelo(){
        boolean condicion;        
        JTextField vueRef = new JTextField();
        JTextField vueDuracion = new JTextField();
        JTextField vueSalida = new JTextField();
        JTextField vueLlegada = new JTextField();        
        JTextField vueMillas = new JTextField();
        
        do {
            condicion = false;
            Object[] message = {"Número de Referencia:\t", vueRef, "Duracion:\t",vueDuracion, "Ap Salida:", vueSalida, "Ap llegada:\t", vueLlegada, "Distancia en Millas:\t", vueMillas};
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar Vuelo", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (!(vueRef.getText().equals(""))) {
                    if (numerico(vueRef.getText())) {
                    if (!(vueDuracion.getText().equals(""))) {
                        if (numerico(vueDuracion.getText())) {                   
                            if (!(vueSalida.getText().equals(""))) {
                                if (!(vueLlegada.getText().equals(""))) {
                                    if (!(vueMillas.getText().equals(""))) {                           
                                        if (numerico(vueMillas.getText())) {                                                                                           
                                            if (!acceso_vuelo.estaNumeroReferancia(vueRef.getText())) {                                
                                                int ref = Integer.parseInt(vueRef.getText());
                                                int duracion = Integer.parseInt(vueDuracion.getText());
                                                String salida = vueSalida.getText();
                                                String llegada = vueLlegada.getText();
                                                int millas = Integer.parseInt(vueMillas.getText());                                
                                                Calendar cal = Calendar.getInstance();
                                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");            
                                                String fecha = sdf.format(cal.getTime());
            
                                                if (acceso_vuelo.agregarVuelo(ref,fecha,duracion,salida,llegada,millas)) {
                                                    JOptionPane.showMessageDialog(null, "Vuelo registrado exitosamente.", "Informe de Estado", JOptionPane.INFORMATION_MESSAGE);
                                                    condicion = true;
                                                    Object datos[] = {ref,fecha,duracion,salida,llegada,millas};
                                                    modVue.adicionar_Datos_fila(datos);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo completar el registro por un error en la base de datos.\n\nContacte al administrador.", "Informe de estado", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Ya Existe un vuelo con la misma referencia que ingresó.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                                vueRef.setText("");condicion = false;
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null,"La cantidad de Millas debe ser un valor numérico","Informe de Estado", JOptionPane.ERROR_MESSAGE );
                                            condicion = false;
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "El campo Millas no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                        condicion = false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El campo AP Llegada Nombre no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                    condicion = false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El campo Ap Salida no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                condicion = false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"El valor del campo Duración debe ser un valor numérico","Informe de Estado", JOptionPane.ERROR_MESSAGE );
                            condicion = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo Duracion no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                        condicion = false;
                    }
                  } else {
                            JOptionPane.showMessageDialog(null,"El Número de Referencia debe ser un valor numérico","Informe de Estado", JOptionPane.ERROR_MESSAGE );
                            condicion = false;
                        }  
                } else {
                    JOptionPane.showMessageDialog(null, "El Número de Referencia no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
            } else {
                condicion = true;
            }
        } while (!condicion);
    }
    
    private void btn_mod_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_vueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mod_vueloActionPerformed

    private void btn_eli_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eli_vueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eli_vueloActionPerformed

    private void btn_add_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_empleadoActionPerformed
        btn_addEmpleado();
    }//GEN-LAST:event_btn_add_empleadoActionPerformed
    public void btn_addEmpleado(){
        boolean condicion;
        JTextField perCedula = new JTextField();
        JTextField perNombre = new JTextField();
        JTextField perApellido = new JTextField();
        JTextField perDireccion = new JTextField();
        String[] nacionalidad = {"Seleccione...", "COLOMBIA", "PERU", "CHILE", "ARGENTINA", "MEXICO"};
        JComboBox jcbNacionalidad = new JComboBox(nacionalidad);
        String[] cargo = {"Seleccione...", "ADMINISTRATIVO", "PILOTO", "TCP"};
        JComboBox jcbCargo = new JComboBox(cargo);
        JTextField perSalario = new JTextField();
        String[] estado = {"Seleccione...", "ACTIVO", "INACTIVO"};
        JComboBox jcbEstado = new JComboBox(estado);

        do {
            condicion = false;
            Object[] message = {"Cedula:\t", perCedula, "Nombre:\t", perNombre, "Apellido:", perApellido, "Direccion:\t", perDireccion, "Nacionalidad\t", jcbNacionalidad, "Cargo\t", jcbCargo, "Salario\t", perSalario, "Estado\t", jcbEstado};
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar Empleado", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (!(perCedula.getText().equals(""))) {
                    if (!(perNombre.getText().equals(""))) {
                        if (!(perApellido.getText().equals(""))) {
                            if (!((String) jcbNacionalidad.getSelectedItem()).equals("Seleccione...")) {
                                if (!((String) jcbCargo.getSelectedItem()).equals("Seleccione...")) {
                                    if (!((String) jcbEstado.getSelectedItem()).equals("Seleccione...")) {
                                        if (!acceso_persona.estaCedula(perCedula.getText())) {
                                            String cedula = perCedula.getText();
                                            String nombre = perNombre.getText();
                                            String apellido = perApellido.getText();
                                            String direccion = perDireccion.getText();
                                            String nacionalidadInput = (String) jcbNacionalidad.getSelectedItem();
                                            String estadoInput = (String) jcbEstado.getSelectedItem();
                                            String cargoInput = (String) jcbCargo.getSelectedItem();
                                            String salario = perSalario.getText();
                                            if (acceso_persona.agregarEmpleado(cedula, nombre, apellido, direccion, nacionalidadInput, salario, cargoInput, estadoInput)) {
                                                JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente.", "Informe de Estado", JOptionPane.INFORMATION_MESSAGE);
                                                condicion = true;
                                                Object datos[] = {cedula, nombre, apellido, direccion, nacionalidadInput, cargoInput, salario, estadoInput};
                                                modEmp.adicionar_Datos_fila(datos);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "No se pudo completar el registro por un error en la base de datos.\n\nContacte al administrador.", "Informe de estado", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ya Existe un Empleado con la misma cedula que ingresó.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                            perCedula.setText("");
                                            condicion = false;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para el Estado del Empleado", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                        condicion = false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para el Cargo del Empleado", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                    condicion = false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para la nacionalidad del Empleado", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                condicion = false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El campo Apellido no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                            condicion = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo Nombre no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                        condicion = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo Cedula no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
            } else {
                condicion = true;
            }
        } while (!condicion);
    }
    
        
    
    private void btn_mod_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mod_empleadoActionPerformed

    private void btn_eli_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eli_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eli_empleadoActionPerformed

    private void btn_add_pilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_pilotoActionPerformed
        btn_addPiloto();
    }//GEN-LAST:event_btn_add_pilotoActionPerformed
    private void btn_addPiloto(){
        boolean condicion;
        JTextField perCedula = new JTextField();
        JTextField perLicencia = new JTextField();        
        JTextField perNombre = new JTextField();
        JTextField perApellido = new JTextField();
        JTextField perDireccion = new JTextField();
        String[] nacionalidad = {"Seleccione...", "COLOMBIA", "PERU", "CHILE", "ARGENTINA", "MEXICO"};
        JComboBox jcbNacionalidad = new JComboBox(nacionalidad);        
        String[] categoria = {"Seleccione...", "A", "B"};
        JComboBox jcbCategoria = new JComboBox(categoria);        

        do {
            condicion = false;
            Object[] message = {"Cedula:\t", perCedula, "Licencia:\t", perLicencia, "Nombre:\t", perNombre, "Apellido:", perApellido, "Direccion:\t", perDireccion, "Nacionalidad\t", jcbNacionalidad, "Categoria\t", jcbCategoria};
            int option = JOptionPane.showConfirmDialog(null, message, "Registrar Empleado", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                if (!(perCedula.getText().equals(""))) {
                    if (!(perLicencia.getText().equals(""))) {
                    if (!(perNombre.getText().equals(""))) {
                        if (!(perApellido.getText().equals(""))) {                            
                            if (!((String) jcbNacionalidad.getSelectedItem()).equals("Seleccione...")) {
                                if (!((String) jcbCategoria.getSelectedItem()).equals("Seleccione...")) {
                                        if (!acceso_persona.estaCedula(perCedula.getText())) {
                                            if(!acceso_persona.estaLicenciaPiloto(perLicencia.getText())){
                                                String cedula = perCedula.getText();
                                                String categoriaInput = (String) jcbCategoria.getSelectedItem();
                                                String nombre = perNombre.getText();
                                                String apellido = perApellido.getText();
                                                String direccion = perDireccion.getText();
                                                String nacionalidadInput = (String) jcbNacionalidad.getSelectedItem();                                            
                                                String licencia = perLicencia.getText();

                                                if (acceso_persona.agregarPiloto(cedula, nombre, apellido, direccion, nacionalidadInput, licencia, categoriaInput)) {
                                                    JOptionPane.showMessageDialog(null, "Piloto registrado exitosamente.", "Informe de Estado", JOptionPane.INFORMATION_MESSAGE);
                                                    condicion = true;
                                                    Object datos[] = {cedula, licencia, nombre, apellido, direccion, nacionalidadInput, categoriaInput};
                                                    modPil.adicionar_Datos_fila(datos);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo completar el registro por un error en la base de datos.\n\nContacte al administrador.", "Informe de estado", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } else {
                                            JOptionPane.showMessageDialog(null, "Ya Existe un Piloto con la misma Licencia que ingresó.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                            perLicencia.setText(""); condicion = false;
                                        }    
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ya Existe un Piloto con la misma cedula que ingresó.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                            perCedula.setText(""); condicion = false;
                                        }                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para la Categoria del Piloto", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                    condicion = false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe seleccionar una opción para la Nacionalidad del Piloto", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                                condicion = false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El campo Apellido no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                            condicion = false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo Nombre no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                        condicion = false;
                    }
                    } else {
                    JOptionPane.showMessageDialog(null, "El campo Licencia no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo Cedula no debe quedar vacio.", "Informe de Estado", JOptionPane.ERROR_MESSAGE);
                    condicion = false;
                }
            } else {
                condicion = true;
            }
        } while (!condicion);
    }
    
    private void btn_mod_pilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mod_pilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mod_pilotoActionPerformed

    private void btn_eli_pilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eli_pilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eli_pilotoActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recursos().setVisible(true);
            }
        });
        
    }

    
    
    
    
    private  boolean numerico(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    private int buscarPocicion(int codigo, JTable tabla, Modelo_Jtable mod){
        int cant = mod.cantFilas();
        for (int i = 0; i < cant; i++) {            
            int valor =  (int) tabla.getValueAt(i, 0);
            if(valor == codigo)
                return i;
        }
        return -1;
    }
    
    private boolean estaCodigo(String tabla, String columna, String valor){
        try {
            ResultSet res = con.consulta("select * from " + tabla + " where " + columna + " codigo = " + valor);
            return res.next();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Recursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_aviones;
    private javax.swing.JButton btn_add_empleado;
    private javax.swing.JButton btn_add_persona;
    private javax.swing.JButton btn_add_piloto;
    private javax.swing.JButton btn_add_vuelo;
    private javax.swing.JButton btn_eli_aviones;
    private javax.swing.JButton btn_eli_empleado;
    private javax.swing.JButton btn_eli_persona;
    private javax.swing.JButton btn_eli_piloto;
    private javax.swing.JButton btn_eli_vuelo;
    private javax.swing.JButton btn_mod_aviones;
    private javax.swing.JButton btn_mod_empleado;
    private javax.swing.JButton btn_mod_persona;
    private javax.swing.JButton btn_mod_piloto;
    private javax.swing.JButton btn_mod_vuelo;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable tbl_aviones;
    private javax.swing.JTable tbl_empleados;
    private javax.swing.JTable tbl_personas;
    private javax.swing.JTable tbl_pilotos;
    private javax.swing.JTable tbl_vuelo;
    // End of variables declaration//GEN-END:variables
}
