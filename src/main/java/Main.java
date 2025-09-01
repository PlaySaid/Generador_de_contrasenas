import javax.swing.*;
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
        String input = JOptionPane.showInputDialog("Ingrese la longitud de la contraseña (mínimo 4):");
        int longitud = Integer.parseInt(input);

        if (longitud < 8) {
            JOptionPane.showMessageDialog(null, "La longitud debe ser mayor o igual a 8");
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
        JOptionPane.showMessageDialog(null, "Contraseña generada:\n" + new String(contrasena));
    }
}
