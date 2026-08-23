import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class Ex13_09_RandomTriangles extends JFrame {
    public Ex13_09_RandomTriangles() {
        super("Random Triangles");
        add(new TrianglesPanel());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class TrianglesPanel extends JPanel {
        private final Random random = new Random();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 10; i++) {
                GeneralPath path = new GeneralPath();
                int x1 = random.nextInt(width);
                int y1 = random.nextInt(height);
                path.moveTo(x1, y1);
                path.lineTo(random.nextInt(width), random.nextInt(height));
                path.lineTo(random.nextInt(width), random.nextInt(height));
                path.closePath();

                g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g2d.fill(path);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_09_RandomTriangles().setVisible(true));
    }
}
