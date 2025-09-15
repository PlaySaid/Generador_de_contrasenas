import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();
        Scanner scanner = new Scanner(System.in);

        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros    = "0123456789";
        String simbolos   = "!@#$%^&*()-_=+[]{}";

        String caracteres = mayusculas + minusculas + numeros + simbolos;

        System.out.print("Ingrese la longitud de la contraseña: ");
        int longitud = scanner.nextInt();
        scanner.close();

        if (longitud < 8) {
            System.out.println("La longitud debe ser mayor o igual a 8");
            return;
        }

        List<Character> caracteresDeContrasena = new ArrayList<>();

        // Se asegura 1 de cada tipo
        caracteresDeContrasena.add(mayusculas.charAt(random.nextInt(mayusculas.length())));
        caracteresDeContrasena.add(minusculas.charAt(random.nextInt(minusculas.length())));
        caracteresDeContrasena.add(numeros.charAt(random.nextInt(numeros.length())));
        caracteresDeContrasena.add(simbolos.charAt(random.nextInt(simbolos.length())));

        // Se completa el resto de la contrasena
        IntStream.range(0, longitud - 4).forEach(
                i -> caracteresDeContrasena.add(
                caracteres.charAt(
                        random.nextInt(
                                caracteres.length()))));


        // se randomiza toda la contrasena
        Collections.shuffle(caracteresDeContrasena, random);

        // se unifica al string final
        String contrasena = caracteresDeContrasena.stream()
                        .map(String::valueOf)
                                .collect(Collectors.joining());

        System.out.println("Contraseña generada: " + contrasena);

        // Transforma la contrasena a mayusculas
        String soloMayusculas = contrasena.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toUpperCase)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("En mayusculas: " + soloMayusculas);

        // Filtra solamente los digitos que contiene la contrasena
        String soloDigitos = contrasena.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Solo números: " + soloDigitos);

        // Reduce solamente a los simbolos que tiene la contrasena
        String soloSimbolos = "!@#$%^&*()-_=+[]{}";
        long totalSimbolos = contrasena.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> soloSimbolos.indexOf(ch) >= 0)
                .count();
        System.out.println("Cantidad de símbolos: " + totalSimbolos);

        // Recolecta los caracteres y los transforma en una list
        List<Character> lista = contrasena.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());

        System.out.println("Lista: " + lista);
    }
}
