package grafos;

public class Grafo {

    public Nodo[] Vect;

    public Grafo(Nodo[] Vect) {
        this.Vect = Vect;
    }

    public Grafo() {
        Vect = null;
    }
    
    public Grafo(int Tam) {
        Vect = new Nodo[Tam];
    }

    public Nodo[] getVect() {
        return Vect;
    }

    public void setVect(Nodo[] Vect) {
        this.Vect = Vect;
    }

    public void Crear(int M[][]) {
        Nodo P=null;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] != 0) {
                    Nodo X = new Nodo();
                    X.setDato(j+1);
                    if (Vect[i] != null) {
                        P = Vect[i];
                        while (P.getLiga() != null) {
                            P = P.getLiga();
                        }
                        P.setLiga(X);
                    }else{
                        Vect[i] = X;
                    }
                }
            }
        }
    }
    
    public void Mostrar(){
        Nodo P = null;
        
        for (int i = 0; i < Vect.length; i++) {
            P = Vect[i];
            while(P != null){
                System.out.print(P.getDato() + " ");
                P = P.getLiga();
            }
            System.out.println("");
        }
    }

}
