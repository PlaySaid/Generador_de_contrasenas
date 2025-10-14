package pilasYcolas.pilas;

import org.junit.jupiter.api.Test;
import pilasYcolas.pilas.pilasExcepciones.EmptyStackException;
import pilasYcolas.pilas.pilasExcepciones.StackOverflowException;

import static org.junit.jupiter.api.Assertions.*;


class StackManualTest {

    // Verifica si la capacidad ingresada es menos a 0 y espera una excepcion
    @Test
    void capacidadDebeSerMayorACero() {
        assertThrows(IllegalArgumentException.class, () -> {
            StackManual<Integer> pila = new StackManual<>(-1);
        });
    }

    @Test
    void pushPopPeekDebeFuncionarCorrectamente() {
        StackManual<String> pila = new StackManual<>(3);

        pila.push("A");
        pila.push("B");

        // Verifica si la pila es de verdad de longitud 2, los cuales son los valores ingresados arriba
        assertEquals(2, pila.size());
        assertEquals("B", pila.peek()); // ultimo elemento sin eliminar


        //Verifica el metodo pop, eliminando
        String sacado = pila.pop();
        assertEquals("B", sacado);
        assertEquals("A", pila.peek());
    }

    // crea una pila vacia de 2 espacios, utiliza pop lo cual deberia enviar una excepcion dicindo que la pila esta vacia
    @Test
    void popEnPilaVaciaDebeLanzarExcepcion() {
        StackManual<Integer> pila = new StackManual<>(2);
        assertThrows(EmptyStackException.class, pila::pop);
    }

    // crea una pila vacia de 2 espacios, utiliza push para ingresar 2 valores yy luego se espera una excepcion si se ingresa otro mas
    @Test
    void pushEnPilaLlenaDebeLanzarExcepcion() {
        StackManual<Integer> pila = new StackManual<>(2);
        pila.push(1);
        pila.push(2);
        assertThrows(StackOverflowException.class, () -> pila.push(3));
    }

    // Crea 2 espacios, los llena y confirma si se vacia la pila con clear
    @Test
    void clearDebeVaciarLaPila() {
        StackManual<String> pila = new StackManual<>(2);
        pila.push("A");
        pila.push("B");
        pila.clear();

        assertTrue(pila.isEmpty());
        assertEquals(0, pila.size());
    }
}