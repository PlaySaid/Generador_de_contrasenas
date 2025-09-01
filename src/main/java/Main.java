import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Generador de Contraseñas --");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // arreglos de caracteres
        char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numeros = "0123456789".toCharArray();

        // pide longitud de la contraseña
        System.out.println("Ingrese la longitud de la contraseña (Minimo 8)");
        int longitud = scanner.nextInt();

        if (longitud < 8) {
            System.out.println("La longitud debe ser mayor o igual a 8");
        }

        // array para guardar la contraseña
        char[] contrasena = new char[longitud];

        // asegura un caracter de cada tipo
        contrasena[0] = mayusculas[random.nextInt(mayusculas.length)];
        contrasena[1] = minusculas[random.nextInt(minusculas.length)];
        contrasena[2] = numeros[random.nextInt(numeros.length)];

        // une todos los arreglos en un solo string
        String todos = new String(mayusculas) + new String(minusculas) + new String(numeros);
        char[] caracteres = todos.toCharArray();

        // comptleta el resto de la contraseña
        for (int i = 8; i < longitud; i++) {
            contrasena[i] = caracteres[random.nextInt(caracteres.length)];
        }

        // mezcla los caracteres del principio para que no siempre empiece en el mismo orden
        for (int i = 0; i < contrasena.length; i++) {
            int j = random.nextInt(contrasena.length);
            char temp = contrasena[i];
            contrasena[i] = contrasena[j];
            contrasena[j] = temp;
        }

        System.out.println("Contraseña generada: " + new String(contrasena));
    }
}
