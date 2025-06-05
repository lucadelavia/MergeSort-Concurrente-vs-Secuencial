package algoritmos;

// Clase con metodos auxiliares para fusionar arreglos ordenados
public class MergeUtils {

    // Metodo para fusionar dos arreglos ordenados y devolver un nuevo arreglo (uso concurrente)
    public static int[] merge(int[] izquierda, int[] derecha) {
        // Se crea un nuevo arreglo con espacio para todos los elementos
        int[] result = new int[izquierda.length + derecha.length];

        // i recorre izquierda, j recorre derecha, k es el indice del arreglo resultado
        int i = 0, j = 0, k = 0;

        // Se comparan elementos de ambos arreglos y se insertan ordenadamente en result
        while (i < izquierda.length && j < derecha.length) {
            result[k++] = (izquierda[i] <= derecha[j]) ? izquierda[i++] : derecha[j++];
        }

        // Si quedan elementos en izquierda, se copian al resultado
        while (i < izquierda.length) result[k++] = izquierda[i++];

        // Si quedan elementos en derecha, se copian al resultado
        while (j < derecha.length) result[k++] = derecha[j++];

        // Se devuelve el arreglo ordenado final
        return result;
    }

    // Metodo para fusionar dos arreglos ordenados directamente en el arreglo result (uso secuencial)
    public static void merge(int[] result, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Se comparan e insertan los elementos ordenadamente en result
        while (i < izquierda.length && j < derecha.length) {
            result[k++] = (izquierda[i] <= derecha[j]) ? izquierda[i++] : derecha[j++];
        }

        // Se copian los elementos restantes de izquierda
        while (i < izquierda.length) result[k++] = izquierda[i++];

        // Se copian los elementos restantes de derecha
        while (j < derecha.length) result[k++] = derecha[j++];
    }
}
