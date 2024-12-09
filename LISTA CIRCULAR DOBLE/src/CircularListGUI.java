import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircularListGUI {
    // Atributos de la interfaz
    private JPanel panelPrincipal;
    private JTextField textField1; // Campo de texto para ingresar números
    private JTextArea displayArea; // Área de texto para mostrar resultados
    private JButton insertButton, deleteButton, searchButton, sortAscButton, displayButton;

    private CircularList circularList; // Objeto de la lista circular

    public CircularListGUI() {
        circularList = new CircularList(); // Instanciamos la lista circular

        // Configuración de los botones
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try {
                    int value = Integer.parseInt(input);
                    circularList.insert(value);  // Insertamos el valor en la lista circular
                    displayArea.setText(circularList.toString()); // Actualizamos el área de texto
                } catch (NumberFormatException ex) {
                    displayArea.setText("Por favor ingrese un número válido.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try {
                    int value = Integer.parseInt(input);
                    boolean result = circularList.delete(value);  // Intentamos eliminar el valor
                    if (result) {
                        displayArea.setText("Elemento " + value + " eliminado.\n" + circularList.toString());
                    } else {
                        displayArea.setText("Elemento " + value + " no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Por favor ingrese un número válido.");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try {
                    int value = Integer.parseInt(input);
                    boolean found = circularList.search(value);  // Buscamos el valor en la lista
                    if (found) {
                        displayArea.setText("Elemento " + value + " encontrado.");
                    } else {
                        displayArea.setText("Elemento " + value + " no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Por favor ingrese un número válido.");
                }
            }
        });

        sortAscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circularList.sortAscending();  // Ordenamos la lista de forma ascendente
                displayArea.setText("Lista ordenada ascendentemente.\n" + circularList.toString());
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("Contenido de la lista:\n" + circularList.toString());  // Visualizamos la lista
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lista Circular Doble");
        frame.setContentPane(new CircularListGUI().getPanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
