/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modelo;

/**
 *
 * @author José
 */
public class Libro {
    private int ID;
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private int publicacion;
    private double precio;
    private String descripcion;
    
    public Libro(){};

    public Libro(String titulo, String autor, String editorial, String isbn, int publicacion, double precio, String descripcion) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setIsbn(isbn);
        this.setPublicacion(publicacion);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
    }
    
    public Libro(int id, String titulo, String autor, String editorial, String isbn, int publicacion, double precio, String descripcion) {
        this.setID(id);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setIsbn(isbn);
        this.setPublicacion(publicacion);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() > 50)
            this.titulo = titulo.substring(0, 50);
        else
            this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor.length() > 50)
            this.autor = autor.substring(0, 50);
        else
            this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        if (editorial.length() > 50)
            this.editorial = editorial.substring(0, 50);
        else
            this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn.length() > 20)
            this.isbn = isbn.substring(0, 20);
        else
            this.isbn = isbn;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion.length() > 200)
            this.descripcion = descripcion.substring(0, 200);
        else
            this.descripcion = descripcion;
    }
    
    public void imprimir(){
        System.out.println();
        System.out.println("ID: " + String.valueOf(this.getID()));
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Editorial: " + this.getEditorial());
        System.out.println("ISBN: " + this.getIsbn());
        System.out.println("Publicación: " + String.valueOf(this.getPublicacion()));
        System.out.println("Precio: "+ String.valueOf(this.getPrecio()) + " €");
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println();
        
    }
    
}
