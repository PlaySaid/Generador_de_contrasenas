import pilasYcolas.colas.QueueManual;
import pilasYcolas.pilas.StackManual;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("-- Generador de Contraseñas --");

        StackManual<String> historial = new StackManual<>(10);
        QueueManual<String> solicitudes = new QueueManual<>(10);
        Random random = new Random();

        while (true) {
            String opcion = JOptionPane.showInputDialog("""
                    --- MENÚ PRINCIPAL ---
                    
                    1. Generar nueva contraseña
                    2. Mostrar historial (pila)
                    3. Deshacer última contraseña (pop)
                    4. Procesar solicitudes (cola)
                    5. Salir
                    """);

            if (opcion == null || opcion.equals("5")) break;

            switch (opcion) {
                case "1" -> {
                    String entrada = JOptionPane.showInputDialog("Ingrese la longitud (minimo 8, maximo 50):");
                    int longitud = Integer.parseInt(entrada);

                    if (longitud < 8 || longitud > 50) {
                        JOptionPane.showMessageDialog(null, "La contraseña tiene que ser entre 8 y 50 caracteres");
                        break;
                    }

                    // Encola la solicitud
                    solicitudes.enqueue("Generar contraseña de " + longitud + " caracteres");

                    // Genera la contraseña
                    String nueva = generarPassword(longitud, random);
                    historial.push(nueva);

                    JOptionPane.showMessageDialog(null, "Contraseña generada:\n" + nueva);
                }

                case "2" -> {
                    if (historial.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Historial vacío");
                    } else {
                        JOptionPane.showMessageDialog(null, "Última contraseña: " + historial.peek() +
                                "\nTotal en pila: " + historial.size());
                    }
                }

                case "3" -> {
                    if (historial.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay contraseñas para deshacer");
                    } else {
                        String eliminada = historial.pop();
                        JOptionPane.showMessageDialog(null, "Se eliminó la última contraseña:\n" + eliminada);
                    }
                }

                case "4" -> {
                    if (solicitudes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay solicitudes en la cola");
                    } else {
                        JOptionPane.showMessageDialog(null, "Procesando solicitud:\n" + solicitudes.dequeue() +
                                "\nSolicitudes restantes: " + solicitudes.size());
                    }
                }

                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
    private static String generarPassword(int longitud, Random random) {
        // arreglos de caracteres
        char[] mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numeros = "0123456789".toCharArray();
        char[] simbolos = "!@#$%^&*()_+-=[]{}".toCharArray();

        // asegura al menos un caracter de cada tipo
        char[] contrasena = new char[longitud];
        contrasena[0] = mayusculas[random.nextInt(mayusculas.length)];
        contrasena[1] = minusculas[random.nextInt(minusculas.length)];
        contrasena[2] = numeros[random.nextInt(numeros.length)];
        contrasena[3] = simbolos[random.nextInt(simbolos.length)];

        // une todos los arreglos
        String todos = new String(mayusculas) + new String(minusculas)
                + new String(numeros) + new String(simbolos);
        char[] caracteres = todos.toCharArray();

        // completa el resto
        for (int i = 4; i < longitud; i++) {
            contrasena[i] = caracteres[random.nextInt(caracteres.length)];
        }

        // mezcla los caracteres
        for (int i = 0; i < contrasena.length; i++) {
            int j = random.nextInt(contrasena.length);
            char temp = contrasena[i];
            contrasena[i] = contrasena[j];
            contrasena[j] = temp;
        }

        return new String(contrasena);
    }
}
