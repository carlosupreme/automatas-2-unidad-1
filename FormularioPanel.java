import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormularioPanel extends JPanel {

    public FormularioPanel(List<CampoConfig> campos) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(20, 30, 20, 30));
        setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("Validador de Datos");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setBorder(new EmptyBorder(0, 0, 20, 0));
        add(titulo);

        for (CampoConfig config : campos) {
            JLabel label = new JLabel(config.getEtiqueta());
            label.setFont(new Font("SansSerif", Font.BOLD, 13));
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(label);

            CampoPanel campoPanel = new CampoPanel(config);
            campoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(campoPanel);
            add(Box.createVerticalStrut(10));
        }
    }
}
