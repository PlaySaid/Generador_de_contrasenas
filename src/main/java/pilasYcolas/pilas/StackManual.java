package pilasYcolas.pilas;

import pilasYcolas.pilas.pilasExcepciones.EmptyStackException;
import pilasYcolas.pilas.pilasExcepciones.StackOverflowException;

public class StackManual<T> {
    private Object[] items;
    private int tamanio;

    public StackManual(int capacidad) {
        if(capacidad <= 0) throw new IllegalArgumentException("LA CAPACIDAD DE LA PILA NO PUEDE SER MENOR A 0");
        this.items = new Object[capacidad];
        this.tamanio = 0;
    }

    public void push(T valor) {
        if(tamanio == items.length) throw new StackOverflowException("LA PILA ESTA LLENA");
        items[tamanio++] = valor;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()) throw new EmptyStackException("LA PILA ESTA VACIA");
        T valor = (T) items[--tamanio];
        items[tamanio] = null;
        return valor;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()) throw new EmptyStackException("LA PILA ESTA VACIA");
        return (T) items[tamanio-1];
    }

    public boolean isEmpty() {
        return tamanio == 0;
    }

    public int size() {
        return tamanio;
    }

    public void clear() {
        for(int i = 0; i < items.length; i++) {
            items[i] = null;
        }
            tamanio = 0;
    }
}
