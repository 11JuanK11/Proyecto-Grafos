package grafos;

import java.util.Scanner;

public class ProyectoGrafos {

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        String Ver = "", Lad = "";

        System.out.println("Ingrese los vertices separadas por comas: ");
        Ver = Leer.next();
        System.out.println("Ingrese los lados y su distancia separadas por comas: ");
        Lad = Leer.next();

        String[] V = Ver.split(",");
        String[] L = Lad.split(",");

        int[][] M = new int[V.length][V.length];

        //Para números
//        for (int i = 0; i < L.length; i += 3) {
//            M[Integer.parseInt(L[i]) - 1][Integer.parseInt(L[i + 1]) - 1] = Integer.parseInt(L[i + 2]);
//            M[Integer.parseInt(L[i + 1]) - 1][Integer.parseInt(L[i]) - 1] = Integer.parseInt(L[i + 2]);
//        }

//        for (int j = 0; j < M.length; j++) {
//            for (int i = 0; i < M[0].length; i++) {
//                System.out.print(M[j][i]);
//            }
//            System.out.println("");
//        }

        //Para caracteres
        for (int i = 0; i < L.length; i += 3) {
            int F=0, C=0, j = 0;

            while (j < V.length) {
                if (V[j].equals(L[i])) {
                    F = j;
                }
                j++;
            }
            j=0;
            while (j < V.length) {
                if (V[j].equals(L[i + 1])) {
                    C = j;
                }
                j++;
            }
            
            M[F][C] = Integer.parseInt(L[i + 2]);
            M[C][F] = Integer.parseInt(L[i + 2]);
        }
        
        for (int j = 0; j < M.length; j++) {
            for (int i = 0; i < M[0].length; i++) {
                System.out.print(M[j][i]);
            }
            System.out.println("");
        }

        Grafo G = new Grafo(V.length);

        G.Crear(M, V);
        G.Mostrar();
    }

}
