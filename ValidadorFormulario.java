import java.awt.*;
import java.util.List;
import javax.swing.*;

public class ValidadorFormulario extends JFrame {

    public ValidadorFormulario(List<CampoConfig> campos) {
        setTitle("Validador de Formulario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(new FormularioPanel(campos));
        pack();
        setMinimumSize(new Dimension(480, getHeight()));
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "2.0");

        List<CampoConfig> campos = List.of(
                new CampoConfig("Codigo Postal", "Ej: 06600", "^\\d{5}$"),
                new CampoConfig("Numero de Telefono", "Ej: 55 1234 5678", "^(\\+52\\s?)?(\\d{2,3}[\\s\\-]?)?\\d{3,4}[\\s\\-]?\\d{4}$"),
                new CampoConfig("Correo Electronico", "Ej: usuario@ejemplo.com", "^[\\w._%+\\-]+@[\\w.\\-]+\\.[a-zA-Z]{2,}$"),
                new CampoConfig("URL", "Ej: https://www.ejemplo.com", "^(https?|ftp)://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?$"),
                new CampoConfig("Contrasena Segura", "Min 8, mayuscula, numero, simbolo", "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$"),
                new CampoConfig("RFC", "Ej: SOPC031030455", "^[A-Z]{4}\\d{6}[A-Z0-9]{3}$")
        );

        SwingUtilities.invokeLater(() -> new ValidadorFormulario(campos).setVisible(true));
    }
}
