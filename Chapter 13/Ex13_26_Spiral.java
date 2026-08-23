import javax.swing.*;
import java.awt.*;

public class Ex13_26_Spiral extends JFrame {
    public Ex13_26_Spiral() {
        super("Spiral - drawPolyline");
        add(new SpiralPanel());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class SpiralPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int points = 300;
            int[] xPoints = new int[points];
            int[] yPoints = new int[points];

            double angleStep = Math.toRadians(10); // 10 degrees per point
            double radiusStep = 1.0;

            for (int i = 0; i < points; i++) {
                double angle = i * angleStep;
                double radius = i * radiusStep;
                xPoints[i] = centerX + (int) (radius * Math.cos(angle));
                yPoints[i] = centerY + (int) (radius * Math.sin(angle));
            }

            g.drawPolyline(xPoints, yPoints, points);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_26_Spiral().setVisible(true));
    }
}
