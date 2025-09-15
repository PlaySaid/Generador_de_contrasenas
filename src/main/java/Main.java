import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Generador de Contraseñas --");
        Random random = new Random();

        // arreglos de caracteres
        char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numeros = "0123456789".toCharArray();
        char[] simbolos = "!@#$%^&*()_+-=[]{}".toCharArray();

        // pide longitud de la contraseña
        String entrada = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña (mínimo 8):");
        int longitud = Integer.parseInt(entrada);

        if (longitud < 8) {
            JOptionPane.showMessageDialog(null, "La longitud debe ser mayor o igual a 8", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (longitud > 50) {
            JOptionPane.showMessageDialog(null, "La longitud debe ser menor o igual a 50", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // array para guardar la contraseña
        char[] contrasena = new char[longitud];

        // asegura un caracter de cada tipo
        contrasena[0] = mayusculas[random.nextInt(mayusculas.length)];
        contrasena[1] = minusculas[random.nextInt(minusculas.length)];
        contrasena[2] = numeros[random.nextInt(numeros.length)];
        contrasena[3] = simbolos[random.nextInt(simbolos.length)];

        // une todos los arreglos en un solo string
        String todos = new String(mayusculas) + new String(minusculas)
                + new String(numeros) + new String(simbolos);
        char[] caracteres = todos.toCharArray();

        // completa el resto de la contraseña
        for (int i = 4; i < longitud; i++) {
            contrasena[i] = caracteres[random.nextInt(caracteres.length)];
        }

        // mezcla los caracteres para que no quede predecible
        for (int i = 0; i < contrasena.length; i++) {
            int j = random.nextInt(contrasena.length);
            char temp = contrasena[i];
            contrasena[i] = contrasena[j];
            contrasena[j] = temp;
        }

        // mostrar la contraseña generada
        JOptionPane.showMessageDialog(null, "Contraseña generada:\n"
                + new String(contrasena), "Exito",JOptionPane.INFORMATION_MESSAGE);


        // Llamando al metodo ordenamiento burbuja
        char[] copia1 = contrasena.clone();
        burbuja(copia1);
        System.out.println("Contraseña ordenada (manual - burbuja): " + new String(copia1));

        // ORDENAMIENTO NATIVO DE JAVA
        char[] copia2 = contrasena.clone();
        Arrays.sort(copia2);
        System.out.println("Contraseña ordenada (nativa - Arrays.sort): " + new String(copia2));

        // Llamando al metodo busqueda lineal
        char buscar = '4';
        int pos1 = busquedaLineal(contrasena, buscar);
        if (pos1 >= 0) {
            System.out.println("Búsqueda manual: '" + buscar + "' encontrado en posición " + pos1);
        } else {
            System.out.println("Búsqueda manual: '" + buscar + "' no está en la contraseña");
        }


    }

    // ORDENAMIENTO BURBUJA
    public static void burbuja(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // BUSQUEDA MANUAL LINEAL
    public static int busquedaLineal(char[] arr, char objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
