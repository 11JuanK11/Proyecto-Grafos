
package grafos;


import java.util.Scanner;

public class ProyectoGrafos {



    

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        String Ver = "", Lad = "";
        
        System.out.println("Ingrese los vertices separadas por comas: ");
        Ver = Leer.next();
        System.out.println("Ingrese los lados separadas por comas: ");
        Lad = Leer.next();
        
        String[] V = Ver.split(",");
        String[] L = Lad.split(",");
        
        
 
        int[][] M = new int[V.length][V.length];
        
        for(int i=0; i<L.length; i+=2){
            M[Integer.parseInt(L[i])-1][Integer.parseInt(L[i+1])-1] = 1;
            M[Integer.parseInt(L[i+1])-1][Integer.parseInt(L[i])-1] = 1;

        }
        
        for (int j=0; j<M.length; j++){
            for (int i = 0; i < M[0].length; i++) {
                System.out.print(M[j][i]);
            }
            System.out.println("");
        }
    }
}
