import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Ex13_28_SelectingShapes extends JFrame {

    private final ShapePanel shapePanel = new ShapePanel();

    public Ex13_28_SelectingShapes() {
        super("Selecting Shapes");
        setLayout(new BorderLayout());

        String[] shapeNames = { "Line", "Rectangle", "Oval" }; // first item = default
        JComboBox<String> shapeCombo = new JComboBox<>(shapeNames);
        shapeCombo.addActionListener((ActionEvent e) ->
            shapePanel.setShapeType(shapeCombo.getSelectedIndex()));

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Shape:"));
        topPanel.add(shapeCombo);
        add(topPanel, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    protected static class ShapePanel extends JPanel {
        protected int shapeType = 0; // default: first item (Line)
        protected final Random random = new Random();

        void setShapeType(int shapeType) {
            this.shapeType = shapeType;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 20; i++) {
                int x = random.nextInt(Math.max(width - 50, 1));
                int y = random.nextInt(Math.max(height - 50, 1));
                int w = 10 + random.nextInt(80);
                int h = 10 + random.nextInt(80);

                setDrawColor(g, i);

                switch (shapeType) {
                    case 0: // Line
                        g.drawLine(x, y, x + w, y + h);
                        break;
                    case 1: // Rectangle
                        g.drawRect(x, y, w, h);
                        break;
                    case 2: // Oval
                        g.drawOval(x, y, w, h);
                        break;
                }
            }
        }

        // Overridden in Exercise 13.29 to use random colors; default is black here
        protected void setDrawColor(Graphics g, int index) {
            g.setColor(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_28_SelectingShapes().setVisible(true));
    }
}
