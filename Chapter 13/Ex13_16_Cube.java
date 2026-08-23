import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Ex13_16_Cube extends JFrame {
    public Ex13_16_Cube() {
        super("Cube");
        add(new CubePanel());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class CubePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int x = 100, y = 150, side = 150, offset = 60;

            GeneralPath path = new GeneralPath();

            // Front face
            path.moveTo(x, y);
            path.lineTo(x + side, y);
            path.lineTo(x + side, y + side);
            path.lineTo(x, y + side);
            path.closePath();

            // Back face (offset up-right)
            path.moveTo(x + offset, y - offset);
            path.lineTo(x + side + offset, y - offset);
            path.lineTo(x + side + offset, y + side - offset);
            path.lineTo(x + offset, y + side - offset);
            path.closePath();

            // Connecting edges
            path.moveTo(x, y);
            path.lineTo(x + offset, y - offset);

            path.moveTo(x + side, y);
            path.lineTo(x + side + offset, y - offset);

            path.moveTo(x + side, y + side);
            path.lineTo(x + side + offset, y + side - offset);

            path.moveTo(x, y + side);
            path.lineTo(x + offset, y + side - offset);

            g2d.setStroke(new BasicStroke(2));
            g2d.draw(path);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_16_Cube().setVisible(true));
    }
}
