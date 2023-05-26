/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author 57301
 */
public class Nodo {
    private Nodo Liga;
    private int Dato;

    public Nodo(Nodo Liga, int Dato) {
        this.Liga = Liga;
        this.Dato = Dato;
    }
    
    
    public Nodo() {
        Liga = null;
        Dato = 0;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }

    public int getDato() {
        return Dato;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }
    
    
    
}
