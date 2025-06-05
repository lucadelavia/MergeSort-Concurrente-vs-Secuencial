package test;

import algoritmos.MergeSortSecuencial;
import algoritmos.MergeSortConcurrente;

import java.util.Random;

public class MergeSortTest {

    public static void main(String[] args) {
        // Se define el tamano del arreglo a ordenar
        int tam = 100000000;

        // Se crea un generador de numeros aleatorios
        Random aleatorio = new Random();

        // Se declaran dos arreglos del mismo tamano
        int[] arraySecuencial = new int[tam];
        int[] arrayConcurrente = new int[tam];

        // Se llenan ambos arreglos con los mismos valores aleatorios
        for (int i = 0; i < tam; i++) {
            // El valor generado se asigna tanto al arreglo secuencial como al concurrente
            arraySecuencial[i] = arrayConcurrente[i] = aleatorio.nextInt(1000);
        }

        // Se imprime encabezado de la prueba secuencial
        System.out.println("Prueba Secuencial:");

        // Se registra el tiempo antes de iniciar el ordenamiento secuencial
        long inicio = System.nanoTime();

        // Se ordena el arreglo de forma secuencial
        MergeSortSecuencial.mergeSort(arraySecuencial);

        // Se registra el tiempo despues de finalizar el ordenamiento
        long fin = System.nanoTime();

        // Se calcula e imprime el tiempo total en milisegundos
        System.out.println("Tiempo secuencial: " + (fin - inicio) / 1_000_000 + " ms");

        // Se imprime encabezado de la prueba concurrente
        System.out.println("\nPrueba Concurrente:");

        // Se registra el tiempo antes de iniciar el ordenamiento concurrente
        inicio = System.nanoTime();

        // Se ordena el arreglo de forma concurrente y se almacena el resultado
        int[] resultado = MergeSortConcurrente.mergeSort(arrayConcurrente);

        // Se registra el tiempo despues de finalizar el ordenamiento
        fin = System.nanoTime();

        // Se calcula e imprime el tiempo total en milisegundos
        System.out.println("Tiempo concurrente: " + (fin - inicio) / 1_000_000 + " ms");
    }
}
