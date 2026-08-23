import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ex13_14_GridRectangle2D extends JFrame {
    public Ex13_14_GridRectangle2D() {
        super("10x10 Grid - Rectangle2D.Double");
        add(new GridPanel());
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class GridPanel extends JPanel {
        private static final int CELLS = 10;
        private static final int CELL_SIZE = 35;
        private static final int MARGIN = 20;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int row = 0; row < CELLS; row++) {
                for (int col = 0; col < CELLS; col++) {
                    g2d.draw(new Rectangle2D.Double(
                        MARGIN + col * CELL_SIZE, MARGIN + row * CELL_SIZE, CELL_SIZE, CELL_SIZE));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_14_GridRectangle2D().setVisible(true));
    }
}
