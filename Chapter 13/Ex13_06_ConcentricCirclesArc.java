import javax.swing.*;
import java.awt.*;

public class Ex13_06_ConcentricCirclesArc extends JFrame {
    public Ex13_06_ConcentricCirclesArc() {
        super("Concentric Circles - drawArc");
        add(new CirclePanel());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int diameter = 20;
            for (int i = 0; i < 8; i++) {
                g.drawArc(10, 10, diameter, diameter, 0, 360);
                diameter += 20; // 10 px separation on each side = 20 px diameter growth
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_06_ConcentricCirclesArc().setVisible(true));
    }
}
