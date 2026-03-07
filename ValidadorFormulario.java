import java.awt.*;
import java.util.List;
import javax.swing.*;

public class ValidadorFormulario extends JFrame {

    public ValidadorFormulario(List<CampoConfig> campos) {
        setTitle("Validador de Formulario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JScrollPane scroll = new JScrollPane(new FormularioPanel(campos));
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        pack();
        int maxHeight = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getMaximumWindowBounds().height * 85 / 100;
        setSize(Math.max(getWidth(), 480), Math.min(getHeight(), maxHeight));
        setMinimumSize(new Dimension(480, 300));
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "2.0");

        List<CampoConfig> campos = List.of(
                new CampoConfig("Codigo Postal", "Ej: 06600", "^\\d{5}$"),
                new CampoConfig("Numero de Telefono", "Ej: 55 1234 5678", "^(\\+52\\s?)?(\\d{2,3}[\\s\\-]?)?\\d{3,4}[\\s\\-]?\\d{4}$"),
                new CampoConfig("Correo Electronico", "Ej: usuario@ejemplo.com", "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$"),
                new CampoConfig("URL", "Ej: https://www.ejemplo.com", "^[-a-zA-Z0-9@:%_\\+.~#?&/=]{2,256}\\.[a-z]{2,4}\\b(/[-a-zA-Z0-9@:%_\\+.~#?&/=]*)?$"),
                new CampoConfig("Contrasena", "Min 8, mayuscula, minuscula, numero", "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"),
                new CampoConfig("Direccion IP", "Ej: 192.168.1.1", "^(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])$"),
                new CampoConfig("Fecha (dd/mm/aaaa)", "Ej: 31/12/2024", "^(0?[1-9]|[12]\\d|3[01])/(0?[1-9]|1[0-2])/(19|20)\\d{2}$"),
                new CampoConfig("Tarjeta Visa", "Ej: 4111111111111111", "^4[0-9]{12}(?:[0-9]{3})?$"),
                new CampoConfig("Tarjeta Mastercard", "Ej: 5100000000000000", "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"),
                new CampoConfig("Codigo de Barras EAN-13", "Ej: 7501000000000", "^[0-9]{13}$"),
                new CampoConfig("RFC Persona Fisica", "Ej: SOPC031030455", "^[A-Z]{4}\\d{6}[A-Z0-9]{3}$"),
                new CampoConfig("RFC Persona Moral", "Ej: SAT930101L71", "^[A-Z]{3}\\d{6}[A-Z0-9]{3}$"),
                new CampoConfig("Clave de Elector", "Ej: GRLPDT85030622H", "^[A-Z]{6}\\d{6}[HM]\\d{5}$"),
                new CampoConfig("Medida de Llanta", "Ej: 205/55R16", "^\\d{3}/\\d{2,3}[RBD]\\d{2}$"),
                new CampoConfig("Placa Mexicana", "Ej: TJJ-718-C", "^[A-Z]{3}-\\d{3}-[A-Z]{1}$")
        );

        SwingUtilities.invokeLater(() -> new ValidadorFormulario(campos).setVisible(true));
    }
}
