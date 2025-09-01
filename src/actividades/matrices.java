public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//Mostrar la matriz en forma de tabla//
        System.out.println("Matriz en forma de tabla:");
        for (int x = 0; x < matriz.length; x++) {          // filas
            for (int y = 0; y < matriz[x].length; y++) {   // columnas
                System.out.print(matriz[x][y] + " ");
            }
            System.out.println();
        }

//Recorrer por columnas//
        System.out.println("Recorrido por columnas:");
        for (int x = 0; x < matriz[0].length; x++) {       // columnas
            for (int y = 0; y < matriz.length; y++) {      // filas
                System.out.print(matriz[y][x] + " ");
            }
            System.out.println();
        }
//sumar todos los elementos//
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        System.out.println("Suma de todos los elementos: " + suma);

//intercambia la primera fila por la ultima//
        int[] temp = matriz[0];
        matriz[0] = matriz[matriz.length - 1];
        matriz[matriz.length - 1] = temp;

    }
}

