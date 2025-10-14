package pilasYcolas.colas;

import org.junit.jupiter.api.Test;
import pilasYcolas.colas.colasExcepciones.EmptyQueueException;
import pilasYcolas.colas.colasExcepciones.QueueOverflowException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueManualTest {

    // Se asegura de que enqueue y dequeue siga el orden First in First Out
    @Test
    void enqueueDequeueDebeMantenerOrdenFIFO() {
        QueueManual<String> cola = new QueueManual<>(3);

        cola.enqueue("uno");
        cola.enqueue("dos");
        cola.enqueue("tres");

        assertEquals("uno", cola.front());
        assertEquals("uno", cola.dequeue());
        assertEquals("dos", cola.dequeue());
        assertEquals(1, cola.size());
    }

    // Verifica si la capacidad ingresada es menos a 0 y espera una excepcion
    @Test
    void capacidadDebeSerMayorACero() {
        assertThrows(IllegalArgumentException.class, () -> {
            QueueManual<Integer> cola = new QueueManual<>(-1);
        });
    }

    // Intenta agregar un objeto mas a la cola estando ya llena
    @Test
    void agregarAUnaColaQueYaEstaLlena() {
        QueueManual<String> cola = new QueueManual<>(3);
        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        assertThrows(QueueOverflowException.class, () -> cola.enqueue("D"));
    }

    // Comprueba si se devuelve el primer valor ingresado utilizando dequeue
    @Test
    void dequeueDevuelveElPrimeroAgregado() {
        QueueManual<String> cola = new QueueManual<>(3);
        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        assertEquals("A", cola.dequeue());
    }

    // Espera un error cuando se intenta eliminar un elemento de una cola vacia
    @Test
    void dequeueEnColaVaciaDebeLanzarExcepcion() {
        QueueManual<Integer> cola = new QueueManual<>(2);
        assertThrows(EmptyQueueException.class, cola::dequeue);
    }
}
