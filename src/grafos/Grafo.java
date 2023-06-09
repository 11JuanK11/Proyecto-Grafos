package grafos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

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
        
        setM(M);
    }
    
    public void MostrarMatrizAdy(){
        for(int j = 0; j < M.length; j++) {
            for (int i = 0; i < M[0].length; i++) {
                System.out.print(M[j][i]);
            }
            System.out.println("");
        }
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

    public void MostrarListaAdy() {
        Nodo P = null;

        for (int i = 0; i < Vect.length; i++) {
            P = Vect[i];
            while (P != null) {
                System.out.print(P.getDato() + "-->");
                P = P.getLiga();
            }
            System.out.println("");
        }
    }
    
    public void Mostrar_Grafo(String V[]) {
        int[][] Arbol = M;
        String A = "";
        int p = 0;
        for (int i = 0; i < Arbol.length; i++) {
            int j = i+1;
            while (j < Arbol[0].length) {
                if (Arbol[i][j] != 0) {
                    A += ( V[i] + "--" + V[j] + "\n");
                }
                j++;
                
            }
        }
        CrearArchivo(A);
        CrearIMG();
    }

    private void CrearArchivo(String A) {
        try {
            FileWriter a = new FileWriter("ImagenGrafo.txt");
            BufferedWriter escribir = new BufferedWriter(a);
            escribir.write("graph ImagenGrafo\n{\nlayout=neato;\n");
            escribir.write(A);
            escribir.write("}");
            escribir.close();
        } catch (Exception e) {
        }
    }

    private void CrearIMG() {
        try {
            String dotPath = "./src/bin/dot.exe";
            String fileInputPath = "ImagenGrafo.txt";
            String fileOutputPath = "./src/grafos/grafico.jpg";

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {}
        
        
    }
    
    public void MinDistance(int min){
        int dm[][] = new int[M.length][M.length];
        ArrayList<Integer> vis = new ArrayList();
        int i =0, k =0;
        while(k < dm.length){
            for (int j = 0; j < M.length; j++) {
                if(M[i][j] != 0 && !content(j, vis))
                    dm[j][k] = M[i][j] + dm[i][k];
            }
            vis.add(i);
            int d = min;
            for (int j = 0; j < M.length; j++) {
                if(d > dm[j][k] && dm[j][k] != 0 && j != vis.get(k)){
                    d = dm[j][k];
                    i = j;
                }
            }
            if(k == 0){
                dm[i][k+1] = d;
            }else{
                for (int j = 0; j < k; j++) {
                    if(d > dm[i][j] && dm[i][j] != 0 )
                        d = dm[i][j];      
                }
                if (k < M.length-1) 
                    dm[i][k+1] = d;
                
                
            }
            k++;
            if(k == (M.length)-1)
                System.out.println("Distancia minima: " + dm[k][k]);
        }
        
        
        
    }
    
    private boolean content(int j, ArrayList<Integer> vis){
        boolean ban = false;
        for (Integer vi : vis) {
            if( vi.intValue() == j)
                ban = true;
            
        }
        return ban;
    }
    

}
