package algoritmos;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSortConcurrente {

    // Metodo publico que inicia el ordenamiento usando Merge Sort concurrente
    public static int[] mergeSort(int[] array) {
        // Si el arreglo es nulo o tiene un elemento o menos, se retorna tal cual
        if (array == null || array.length <= 1) {
            return array;
        }

        // Se crea un pool de hilos ForkJoin para ejecutar tareas en paralelo
        ForkJoinPool pool = new ForkJoinPool();

        // Se lanza la tarea principal de ordenamiento usando el pool y se obtiene el resultado
        int[] resultado = pool.invoke(new TareaMergeSort(array));

        // Se apaga el pool despues de completar la tarea
        pool.shutdown();

        // Se retorna el arreglo ordenado
        return resultado;
    }

    // Clase interna que representa una tarea recursiva de ordenamiento
    private static class TareaMergeSort extends RecursiveTask<int[]> {
        // Arreglo que se va a ordenar
        private final int[] array;

        // Umbral que define cuando dejar de usar concurrencia y pasar a modo secuencial
        private static final int UMBRAL = 100_000;

        // Constructor que recibe el arreglo
        public TareaMergeSort(int[] array) {
            // Se guarda el arreglo que esta siendo procesado por esta tarea
            this.array = array;
        }

        @Override
        protected int[] compute() {
            // Si el arreglo es pequeno, se ordena secuencialmente para evitar sobrecarga de hilos
            if (array.length <= UMBRAL) {
                // Se crea una copia del arreglo para no modificar el original
                int[] copia = Arrays.copyOf(array, array.length);

                // Se ordena la copia de forma secuencial usando la clase existente
                MergeSortSecuencial.mergeSort(copia);

                // Se retorna el arreglo ordenado
                return copia;
            }

            // Se divide el arreglo en dos mitades
            int medio = array.length / 2;
            int[] izquierda = Arrays.copyOfRange(array, 0, medio);
            int[] derecha = Arrays.copyOfRange(array, medio, array.length);

            // Se crean las tareas para ordenar cada mitad
            TareaMergeSort tareaIzquierda = new TareaMergeSort(izquierda);
            TareaMergeSort tareaDerecha = new TareaMergeSort(derecha);

            // Se lanza la tarea izquierda de forma asincronica (en otro hilo)
            tareaIzquierda.fork();

            // Se ejecuta la tarea derecha en el hilo actual
            int[] ordenadoDerecha = tareaDerecha.compute();

            // Se espera a que termine la tarea izquierda y se obtiene su resultado
            int[] ordenadoIzquierda = tareaIzquierda.join();

            // Se combinan las dos mitades ordenadas y se retorna el resultado
            return MergeUtils.merge(ordenadoIzquierda, ordenadoDerecha);
        }
    }
}
