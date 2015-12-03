/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author José
 */
public class Conexion {
    
    private String nombreBD;
    private Connection conn;
    
    public Conexion(String bdName) {
        try {
            this.nombreBD = bdName;
            this.conn = null;
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(this.nombreBD);
        }   catch (SQLException ex) {
                System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }   catch (Exception ex) {
                System.out.println("Algo ha ido mal: " + ex.getMessage());
                ex.printStackTrace();
        }
    }    

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public Connection getConn() {
        return conn;
    }
    
    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BBDD: " + ex.getMessage());
        }
    }
}
