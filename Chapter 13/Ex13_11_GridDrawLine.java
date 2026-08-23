import javax.swing.*;
import java.awt.*;

public class Ex13_11_GridDrawLine extends JFrame {
    public Ex13_11_GridDrawLine() {
        super("8x8 Grid - drawLine");
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
            int gridSize = CELLS * CELL_SIZE;

            for (int i = 0; i <= CELLS; i++) {
                int offset = MARGIN + i * CELL_SIZE;
                // vertical lines
                g.drawLine(offset, MARGIN, offset, MARGIN + gridSize);
                // horizontal lines
                g.drawLine(MARGIN, offset, MARGIN + gridSize, offset);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_11_GridDrawLine().setVisible(true));
    }
}
