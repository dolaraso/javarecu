import java.util.ArrayList;
import java.util.Collections;

public class CircularList {
    private ArrayList<Integer> list;

    public CircularList() {
        list = new ArrayList<>();
    }

    public void insert(int value) {
        list.add(value);  // Agrega el número a la lista
    }

    public boolean delete(int value) {
        return list.remove((Integer) value);  // Elimina el número de la lista
    }

    public boolean search(int value) {
        return list.contains(value);  // Busca el número en la lista
    }

    public void sortAscending() {
        Collections.sort(list);  // Ordena la lista ascendentemente
    }

    @Override
    public String toString() {
        return list.toString();  // Devuelve la lista como cadena de texto
    }
}
