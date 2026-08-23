import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class Ex13_08_RandomLinesLine2D extends JFrame {
    public Ex13_08_RandomLinesLine2D() {
        super("Random Lines - Line2D.Double");
        add(new LinesPanel());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class LinesPanel extends JPanel {
        private final Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 20; i++) {
                int x1 = random.nextInt(width);
                int y1 = random.nextInt(height);
                int x2 = random.nextInt(width);
                int y2 = random.nextInt(height);

                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                float thickness = 1 + random.nextInt(10);

                g2d.setColor(color);
                g2d.setStroke(new BasicStroke(thickness));
                g2d.draw(new Line2D.Double(x1, y1, x2, y2));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_08_RandomLinesLine2D().setVisible(true));
    }
}
