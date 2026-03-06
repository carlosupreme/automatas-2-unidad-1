import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class CampoPanel extends JPanel {

    private static final Color COLOR_VALIDO   = new Color(39, 174, 96);
    private static final Color COLOR_INVALIDO = new Color(192, 57, 43);
    private static final Color COLOR_NEUTRO   = new Color(127, 140, 141);

    public CampoPanel(CampoConfig config) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(245, 245, 245));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 54));

        // --- Input row ---
        JPanel fila = new JPanel(new BorderLayout(8, 0));
        fila.setBackground(new Color(245, 245, 245));

        JTextField campo = new JTextField();
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JLabel estado = new JLabel("●");
        estado.setFont(new Font("SansSerif", Font.BOLD, 18));
        estado.setForeground(COLOR_NEUTRO);
        estado.setPreferredSize(new Dimension(24, 24));
        estado.setHorizontalAlignment(SwingConstants.CENTER);

        fila.add(campo,  BorderLayout.CENTER);
        fila.add(estado, BorderLayout.EAST);

        JLabel hint = new JLabel(config.getPlaceholder());
        hint.setFont(new Font("SansSerif", Font.ITALIC, 11));
        hint.setForeground(COLOR_NEUTRO);

        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = campo.getText().trim();
                if (texto.isEmpty()) {
                    estado.setForeground(COLOR_NEUTRO);
                    hint.setForeground(COLOR_NEUTRO);
                } else if (config.getValidador().validar(texto)) {
                    estado.setForeground(COLOR_VALIDO);
                    hint.setForeground(COLOR_VALIDO);
                } else {
                    estado.setForeground(COLOR_INVALIDO);
                    hint.setForeground(COLOR_INVALIDO);
                }
            }
        });

        add(fila);
        add(hint);
    }
}
