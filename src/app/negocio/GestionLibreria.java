/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

import app.modelo.Libro;
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
    public boolean eliminar(int id) {
        return libDAO.eliminar(id);
    }

    @Override
    public List<Libro> consultarTodos() {
        return libDAO.consultarTodos();
    }

    @Override
    public Libro consultarISBN(String isbn) {
        return libDAO.consultarISBN(isbn);
    }

    @Override
    public List<Libro> consultarTitulo(String titulo) {
        return libDAO.consultarTitulo(titulo);
    }

    @Override
    public boolean modificarPrecio(String isbn, double precio) {
        return libDAO.modificarPrecio(isbn, precio);
    }
    
}
