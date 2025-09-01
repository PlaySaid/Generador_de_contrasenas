import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Random random = new Random();

        // Genera un número random entre 1 y 100 //
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1;
        }

        // Transforma todos los números impares en 0 //
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                numeros[i] = 0;
            }

            // Multiplica el valor por su índice //
            numeros[i] = numeros[i] * i;

        }
        // Recorrido clasico //
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posición " + i + ": " + numeros[i]);

            // Recorrido for each //
            for (int n : numeros) {
                System.out.println(n);
            }

            // Busqueda lineal //
            int valorBuscado = 50;
            boolean encontrado = false;

            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] == valorBuscado) {
                    System.out.println("Valor encontrado en posición " + i);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Valor no encontrado en el arreglo");
            }


        }
    }
}