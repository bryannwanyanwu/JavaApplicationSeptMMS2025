import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Ex13_12_GridLine2D extends JFrame {
    public Ex13_12_GridLine2D() {
        super("8x8 Grid - Line2D.Double");
        add(new GridPanel());
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class GridPanel extends JPanel {
        private static final int CELLS = 8;
        private static final int CELL_SIZE = 40;
        private static final int MARGIN = 20;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int gridSize = CELLS * CELL_SIZE;

            for (int i = 0; i <= CELLS; i++) {
                int offset = MARGIN + i * CELL_SIZE;
                g2d.draw(new Line2D.Double(offset, MARGIN, offset, MARGIN + gridSize));
                g2d.draw(new Line2D.Double(MARGIN, offset, MARGIN + gridSize, offset));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_12_GridLine2D().setVisible(true));
    }
}
