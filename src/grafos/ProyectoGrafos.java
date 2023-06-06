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

        Grafo G = new Grafo(V.length);
        G.CrearMatrizAdy(V, L);
        G.CrearListaAdy(G.getM(), V);
        G.MostrarListaAdy();
        G.Mostrar_Grafo(V);
    }

}
