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
public class LibroNoEncontradoException extends Exception {
    private int ID;
    
    public LibroNoEncontradoException (String mensaje, int ID){
        super(mensaje);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
