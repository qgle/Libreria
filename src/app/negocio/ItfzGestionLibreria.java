/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

import app.modelo.Libro;
import java.util.List;

/**
 *
 * @author José
 */
public interface ItfzGestionLibreria {
        
   public boolean altaLibro(Libro libro);
    
    public boolean eliminar();
    
    public List<Libro> consultarTodos();
    
    public Libro consultarISBN(String isbn);
    
    public List<Libro> consultarTitulo(String titulo);
    
    public boolean modificarPrecio(String isbn, double precio);
    
}
