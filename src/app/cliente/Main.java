/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.cliente;

import app.modelo.Libro;
import app.modelo.LibroNoEncontradoException;
import app.negocio.GestionLibreria;

/**
 *
 * @author José
 */
public class Main {
    
    public static void main(String[] args) throws LibroNoEncontradoException {
        GestionLibreria gesLib = new GestionLibreria();
        
        Libro libro = new Libro("Java JDK 6", "W. Clay Richardson", "Anaya", "9788441522206", 3, 61.28, "Sun Microsystems ha lanzado la nueva versión de su plataforma Java SE Development Kit (JDK) 6, la versión para desarrollo en Java.");
        boolean added = gesLib.altaLibro(libro);
        System.out.println(libro.getTitulo() + ((added) ? " añadido" : " no añadido"));
        boolean deleted = gesLib.eliminar(4);
        System.out.println("Libro con id " + 4 + ((deleted) ? " eliminado" : " no eliminado"));
        for(Libro l : gesLib.consultarTodos()) {
            l.imprimir();
        }
        
        Libro l = gesLib.consultarISBN("1517029759");
        if (l != null) {
            l.imprimir();
        }
        
        for(Libro l1 : gesLib.consultarTitulo("la")) {
            l1.imprimir();
        }
        
        boolean modificado = gesLib.modificarPrecio("14919019128", 24.18);
        System.out.println(((modificado) ? "Se ha modificado" : "No se ha modificado") + " el libro con ISBN 1491901942");
        
    }
    
}
