
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
