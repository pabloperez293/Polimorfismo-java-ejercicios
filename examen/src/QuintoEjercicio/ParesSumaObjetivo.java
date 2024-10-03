package examen.src.QuintoEjercicio;

import java.util.ArrayList;
import java.util.List;

public class ParesSumaObjetivo {

    // Metodo para encontrar todos los pares
    public static List<int[]> encontrarPares(int[] lista, int objetivo) {
        List<int[]> pares = new ArrayList<>();

        // Recorremos la lista con dos bucles anidados
        for (int i = 0; i < lista.length; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[i] + lista[j] == objetivo) {
                    pares.add(new int[] { i, j });
                }
            }
        }

        return pares;
    }

    public static void main(String[] args) {
        int[] lista = { 2, 6, 8, 3, 5, 0, 2, 6 };
        int objetivo = 8;

        // Llamamos al método
        List<int[]> pares = encontrarPares(lista, objetivo);

        // Imprime los pares
        for (int[] par : pares) {
            System.out.println("(" + par[0] + ", " + par[1] + ")");
        }
    }
}
