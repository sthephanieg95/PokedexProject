package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Panel panel = new Panel();

    public Ventana(){
        super("PokeDex");
        setSize(750,570);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);
        Container container = getContentPane();
        container.add(panel);

        setVisible(true);
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }
}
