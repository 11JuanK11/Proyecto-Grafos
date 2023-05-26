/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

public class Grafo {
    private Nodo[] Vect;

    public Grafo(Nodo[] Vect) {
        this.Vect = Vect;
    }
    
    public Grafo() {
        Vect = null;
    }

    public Nodo[] getVect() {
        return Vect;
    }

    public void setVect(Nodo[] Vect) {
        this.Vect = Vect;
    }
    
    
}
