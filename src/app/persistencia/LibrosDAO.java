/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;
import app.negocio.Constantes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class LibrosDAO implements ItfzLibrosDao {
    private boolean estado;
    private Conexion conex;
    private Connection conn;
    private ResultSet rs;
    private int estadoConsulta;
    private String consulta;
        
    @Override
    public boolean altaLibro(Libro libro) {
        this.estado = false;
        try {
            this.conex = new Conexion(Constantes.DBURL);
            this.conn = conex.getConn();
            Statement s = this.conn.createStatement();
            this.consulta = "INSERT INTO CURSO.LIBROS (TITULO, AUTOR, EDITORIAL, ISBN, PUBLICACION, PRECIO, DESCRIPCION) VALUES"
                    + "('" + libro.getTitulo()+ "','" + libro.getAutor() + "','" + libro.getEditorial() + "','" + libro.getIsbn() + "'," 
                    + libro.getPublicacion() + "," + libro.getPrecio() + ",'" + libro.getDescripcion() + "')";
            this.estadoConsulta = s.executeUpdate(consulta);
            this.estado = (this.estadoConsulta == 1);
        } catch (SQLException ex) {
                System.out.println("Error al añadir el registro: " + ex.getMessage());
        } finally {
            if (conex != null)
                conex.cerrarConexion();
        }
        return this.estado;
    }

    @Override
    public boolean eliminar(int id) throws LibroNoEncontradoException {
        try {
            conex = new Conexion(Constantes.DBURL);
            conn = conex.getConn();
            Statement s = conn.createStatement();
            this.consulta = "DELETE FROM CURSO.LIBROS  WHERE ID = " + id;
            this.estadoConsulta = s.executeUpdate(consulta);
            this.estado = (this.estadoConsulta == 1);
            if (!this.estado) {
                throw new LibroNoEncontradoException("Libro con id " + id + " no encontrado en la BBDD", 0);
            }
        } catch (SQLException ex) {
                System.out.println("Error al elimnar el registro: " + ex.getMessage());
        } finally {
            if (conex != null)
                conex.cerrarConexion();
        }
        return this.estado;
    }

    @Override
    public List<Libro> consultarTodos() {
        List lista = new ArrayList();
        try {
            this.conex = new Conexion(Constantes.DBURL);
            this.conn = this.conex.getConn();
            Statement s = this.conn.createStatement();
            this.consulta = "SELECT * FROM CURSO.LIBROS";
            this.rs = s.executeQuery(consulta);
            while (this.rs.next()){
                int id              = Integer.parseInt(this.rs.getString("ID"));
                String titulo       = this.rs.getString("TITULO");
                String autor        = this.rs.getString("AUTOR");
                String editorial    = this.rs.getString("EDITORIAL");
                String isbn         = this.rs.getString("ISBN");
                int publicacion     = Integer.parseInt(this.rs.getString("PUBLICACION"));
                double precio       = Double.parseDouble(this.rs.getString("PRECIO"));
                String descripcion  = this.rs.getString("DESCRIPCION");
                Libro l = new Libro(id, titulo, autor, editorial, isbn, publicacion, precio, descripcion);
                lista.add(l);
            }
        } catch (SQLException ex) {
                System.out.println("Error al recuperar los registros: " + ex.getMessage());
        } finally {
            if (this.conex != null)
                conex.cerrarConexion();
            if (this.rs != null)
                try {
                    this.rs.close();
                } catch (SQLException ex){
                    System.out.println("Error al cerrar la lista de resultados: " + ex.getMessage());
                }
        }
        return lista; 
    }

    @Override
    public Libro consultarISBN(String isbn) throws LibroNoEncontradoException{
        Libro l = new Libro();
        try {
            this.conex = new Conexion(Constantes.DBURL);
            this.conn = this.conex.getConn();
            Statement s = this.conn.createStatement();
            this.consulta = "SELECT * FROM CURSO.LIBROS WHERE LIBROS.ISBN = '" + isbn + "'";
            this.rs = s.executeQuery(this.consulta);
            if (!rs.next())
                throw new LibroNoEncontradoException("ISBN " + isbn + " no encontrado en la BBDD", 0);
            while (rs.next()) {
                l.setID(Integer.parseInt(this.rs.getString("ID")));
                l.setTitulo(this.rs.getString("TITULO"));
                l.setAutor(this.rs.getString("AUTOR"));
                l.setEditorial(this.rs.getString("EDITORIAL"));
                l.setIsbn(this.rs.getString("ISBN"));
                l.setPublicacion(Integer.parseInt(this.rs.getString("PUBLICACION")));
                l.setPrecio(Double.parseDouble(this.rs.getString("PRECIO")));
                l.setDescripcion(this.rs.getString("DESCRIPCION"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al recuperar los registros: " + ex.getMessage());
        } finally {
            if (this.conex != null)
                conex.cerrarConexion();
            if (this.rs != null)
                try {
                    this.rs.close();
                } catch (SQLException ex){
                    System.out.println("Error al cerrar la lista de resultados: " + ex.getMessage());
                }
        }
        return l;
    }

    @Override
    public List<Libro> consultarTitulo(String titulo) {
        List lista = new ArrayList();
        try {
            this.conex = new Conexion(Constantes.DBURL);
            this.conn = this.conex.getConn();
            Statement s = this.conn.createStatement();
            this.consulta = "SELECT * FROM CURSO.LIBROS WHERE LIBROS.TITULO LIKE '%" + titulo + "%'";
            this.rs = s.executeQuery(consulta);
            while (this.rs.next()){
                int id              = Integer.parseInt(this.rs.getString("ID"));
                String resTitulo    = this.rs.getString("TITULO");
                String autor        = this.rs.getString("AUTOR");
                String editorial    = this.rs.getString("EDITORIAL");
                String isbn         = this.rs.getString("ISBN");
                int publicacion     = Integer.parseInt(this.rs.getString("PUBLICACION"));
                double precio       = Double.parseDouble(this.rs.getString("PRECIO"));
                String descripcion  = this.rs.getString("DESCRIPCION");
                Libro l = new Libro(id, resTitulo, autor, editorial, isbn, publicacion, precio, descripcion);
                lista.add(l);
            }
        } catch (SQLException ex) {
                System.out.println("Error al elimnar el registro: " + ex.getMessage());
        } finally {
            if (this.conex != null)
                this.conex.cerrarConexion();
            if (this.rs != null)
                try {
                    this.rs.close();
                } catch (SQLException ex){
                    System.out.println("Error al cerrar la lista de resultados: " + ex.getMessage());
                }
        }
        return lista; 
    }

    @Override
    public boolean modificarPrecio(String isbn, double precio) throws LibroNoEncontradoException {
        try {
            this.conex = new Conexion(Constantes.DBURL);
            this.conn = conex.getConn();
            Statement s = conn.createStatement();
            this.consulta = "UPDATE CURSO.LIBROS SET LIBROS.PRECIO = " + precio + " WHERE ISBN = '" + isbn + "'";
            this.estadoConsulta = s.executeUpdate(consulta);
            this.estado = (this.estadoConsulta == 1);
            if (!this.estado) {
                throw new LibroNoEncontradoException("ISBN " + isbn + " no encontrado en la BBDD", 0);
            }
        } catch (SQLException ex) {
                System.out.println("Error al cambiar el registro: " + ex.getMessage());
        } finally {
            if (conex != null)
                conex.cerrarConexion();
        }
        return this.estado;   
    }
}
