/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;
import app.persistencia.LibrosDAO;
import java.util.List;

/**
 *
 * @author José
 */
public class GestionLibreria implements ItfzGestionLibreria {
    
    private final LibrosDAO libDAO = new LibrosDAO();

    @Override
    public boolean altaLibro(Libro libro) {
        return libDAO.altaLibro(libro);
    }

    @Override
    public boolean eliminar(int id) throws LibroNoEncontradoException {
        boolean eliminado = false;
        try {
            eliminado = libDAO.eliminar(id);
        } catch (LibroNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.getMessage();
        }
        return eliminado;
    }

    @Override
    public List<Libro> consultarTodos() {
        return libDAO.consultarTodos();
    }

    @Override
    public Libro consultarISBN(String isbn) {
        Libro l = null;
        try {
            l = libDAO.consultarISBN(isbn);
        } catch (LibroNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.getMessage();
        }
        return l;
    }

    @Override
    public List<Libro> consultarTitulo(String titulo) {
        return libDAO.consultarTitulo(titulo);
    }

    @Override
    public boolean modificarPrecio(String isbn, double precio) throws LibroNoEncontradoException {
        boolean eliminado = false;
        try {
            libDAO.modificarPrecio(isbn, precio);
        } catch (LibroNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.getMessage();
        }
        return eliminado;
    }
    
}
