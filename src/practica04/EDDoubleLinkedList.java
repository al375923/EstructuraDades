package practica04;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Implementación incompleta de una lista usando una cadena no circular de nodos
 * doblemente enlazados.
 */
public class EDDoubleLinkedList<T> implements List<T> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
        }

        ;
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public EDDoubleLinkedList(Collection<T> col) {
        for (T elem : col) {
            Node n = new Node(elem);
            if (first == null)
                first = last = n;
            else {
                n.prev = last;
                last.next = n;
                last = n;
            }
        }
        size = col.size();
    }


    /**
     * Invierte el orden de los elementos de la lista.
     */
    public void reverse() {
        //TODO Implmentar para la práctica
        if (size == 0) return;
        Node nodeF = first;
        Node nodeL = last;

        for (int i = 0; i < size / 2; i++) {
            T dato = nodeF.data;
            nodeF.data = nodeL.data;
            nodeL.data = dato;
            nodeF = nodeF.next;
            nodeL = nodeL.prev;

        }
    }

    /**
     * Añade los elementos de la lista intercalándolo con la lista actual.
     */
    public void shuffle(List<T> lista) {
        // TODO Implmentar para la práctica

        if (lista.isEmpty() && first == null )
            return;

        if (first == null) {
            if (!lista.isEmpty()) {
                Node n = first;
                //for (int i = 0; i < lista.size(); i++) {
                for(T dades : lista){
                    Node aux = new Node(dades);
                    if (first == null)
                        first = aux;
                    else {
                        aux.prev = n;
                        n.next = aux;
                    }
                    n = aux;
                    size++;

                }
                last = n;
            }
        } else {
            int tam = lista.size();
            Node n = first;
            Node aux = null;

            while (n.next != null && lista.size() != 0) {

                Node nuevo = new Node(lista.remove(0));
                aux = n.next;
                nuevo.prev = n;
                nuevo.next = aux;
                n.next = nuevo;
                aux.prev = nuevo;
                n = aux;
                //last = n;
            }

            while(lista.size() != 0) {
                Node nuevo = new Node(lista.remove(0));
                last.next = nuevo;
                nuevo.prev = last;
                last = nuevo;
            }

            size = size+tam;

        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Object[] v = new Object[size];

        Node n = first;
        int i = 0;
        while (n != null) {
            v[i] = n.data;
            n = n.next;
            i++;
        }

        return v;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");

        if (isEmpty())
            sb.append("[]");
        else {
            sb.append("[");
            Node ref = first;
            while (ref != null) {
                sb.append(ref.data);
                ref = ref.next;
                if (ref == null)
                    sb.append("]");
                else
                    sb.append(", ");
            }
        }

        sb.append(": ");
        sb.append(size);

        return sb.toString();
    }
}
