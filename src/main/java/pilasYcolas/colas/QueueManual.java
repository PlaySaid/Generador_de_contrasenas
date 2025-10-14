package pilasYcolas.colas;
import pilasYcolas.colas.colasExcepciones.EmptyQueueException;
import pilasYcolas.colas.colasExcepciones.QueueOverflowException;

import java.util.Queue;

public class QueueManual<T> {
    private Object[] items;
    private int head, tail, size;

    public QueueManual(int capacidad) {
        if(capacidad <= 0) throw new IllegalArgumentException("LA CAPACIDAD DE LA COLA NO PUEDE SER MENOR A 0");
        this.items = new Object[capacidad];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(T valor) {
        if(size == items.length) throw new QueueOverflowException("LA COLA ESTA LLENA");
        items[tail] = valor;
        tail = (tail + 1) % items.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if(isEmpty()) throw new EmptyQueueException("LA COLA ESTA VACIA");
        T valor = (T) items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        size--;
        return valor;
    }

    @SuppressWarnings("unchecked")
    public T front(){
        if(isEmpty()) throw new EmptyQueueException("LA COLA ESTA VACIA");
        return (T) items[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for(int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        head = 0;
        tail = 0;
        size = 0;
    }
}
