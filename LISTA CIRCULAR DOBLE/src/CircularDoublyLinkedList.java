public class CircularDoublyLinkedList {
    private Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    // Nodo interno para la lista
    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    // Inserción de un elemento al final
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head.prev = head;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
        size++;
    }

    // Eliminación de un elemento específico
    public void delete(int data) {
        if (head == null) return;

        Node current = head;
        do {
            if (current.data == data) {
                if (current == head) {
                    head = head.next;
                    head.prev = current.prev;
                    current.prev.next = head;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Búsqueda avanzada de un elemento
    public boolean search(int data) {
        if (head == null) return false;

        Node current = head;
        do {
            if (current.data == data) return true;
            current = current.next;
        } while (current != head);
        return false;
    }

    // Algoritmo de ordenamiento ascendente (Bubble Sort)
    public void sortAsc() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            do {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            } while (current != head);
        } while (swapped);
    }

    // Mostrar la lista
    public String displayList() {
        if (head == null) return "List is empty.";

        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.data).append(" ");
            current = current.next;
        } while (current != head);
        return sb.toString();
    }
}
