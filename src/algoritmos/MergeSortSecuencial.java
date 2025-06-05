package algoritmos;

import java.util.Arrays;

// Clase que implementa el algoritmo MergeSort en forma secuencial
public class MergeSortSecuencial {

    // Metodo que ordena un arreglo usando el algoritmo merge sort de forma recursiva
    public static void mergeSort(int[] array) {
        // Si el arreglo tiene 1 elemento o menos, ya esta ordenado
        if (array.length <= 1) return;

        // Se calcula el indice medio para dividir el arreglo en dos mitades
        int medio = array.length / 2;

        // Se copian los elementos de la mitad izquierda
        int[] izquierda = Arrays.copyOfRange(array, 0, medio);

        // Se copian los elementos de la mitad derecha
        int[] derecha = Arrays.copyOfRange(array, medio, array.length);

        // Se ordena recursivamente la mitad izquierda
        mergeSort(izquierda);

        // Se ordena recursivamente la mitad derecha
        mergeSort(derecha);

        // Se combinan las mitades ordenadas en el arreglo original
        MergeUtils.merge(array, izquierda, derecha);
    }
}
