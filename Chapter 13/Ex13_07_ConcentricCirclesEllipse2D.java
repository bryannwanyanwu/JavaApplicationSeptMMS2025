import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ex13_07_ConcentricCirclesEllipse2D extends JFrame {
    public Ex13_07_ConcentricCirclesEllipse2D() {
        super("Concentric Circles - Ellipse2D.Double");
        add(new CirclePanel());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class CirclePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int diameter = 20;
            for (int i = 0; i < 8; i++) {
                Ellipse2D.Double circle = new Ellipse2D.Double(10, 10, diameter, diameter);
                g2d.draw(circle);
                diameter += 20;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_07_ConcentricCirclesEllipse2D().setVisible(true));
    }
}
