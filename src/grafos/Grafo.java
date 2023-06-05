package grafos;

public class Grafo {

    public Nodo[] Vect;
    public int[][] M;

    public Grafo(Nodo[] Vect, int[][] M) {
        this.Vect = Vect;
        this.M = M;
    }

    public Grafo() {
        Vect = null;
        M = null;
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

    public int[][] getM() {
        return M;
    }

    public void setM(int[][] M) {
        this.M = M;
    }

    public void CrearMatrizAdy(String V[], String L[]) {
        int[][] M = new int[V.length][V.length];

        for (int i = 0; i < L.length; i += 3) {
            int F = 0, C = 0, j = 0;

            while (j < V.length) {
                if (V[j].equals(L[i])) {
                    F = j;
                }
                j++;
            }
            j = 0;
            while (j < V.length) {
                if (V[j].equals(L[i + 1])) {
                    C = j;
                }
                j++;
            }

            M[F][C] = Integer.parseInt(L[i + 2]);
            M[C][F] = Integer.parseInt(L[i + 2]);
        }

        //Mostrar sencilla matriz
        for (int j = 0; j < M.length; j++) {
            for (int i = 0; i < M[0].length; i++) {
                System.out.print(M[j][i]);
            }
            System.out.println("");
        }
         setM(M);
    }

    public void CrearListaAdy(int M[][], String V[]) {
        Nodo P = null;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] != 0) {
                    Nodo X = new Nodo();
                    X.setDato(V[j]);
                    if (Vect[i] != null) {
                        P = Vect[i];
                        while (P.getLiga() != null) {
                            P = P.getLiga();
                        }
                        P.setLiga(X);
                    } else {
                        Vect[i] = X;
                    }
                }
            }
        }
    }

    public void Mostrar() {
        Nodo P = null;

        for (int i = 0; i < Vect.length; i++) {
            P = Vect[i];
            while (P != null) {
                System.out.print(P.getDato() + " ");
                P = P.getLiga();
            }
            System.out.println("");
        }
    }

}
