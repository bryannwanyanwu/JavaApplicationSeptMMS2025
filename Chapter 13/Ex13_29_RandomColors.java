import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Ex13_29_RandomColors extends JFrame {

    private final ShapePanel shapePanel = new ShapePanel();

    public Ex13_29_RandomColors() {
        super("Selecting Shapes - Random Colors");
        setLayout(new BorderLayout());

        String[] shapeNames = { "Line", "Rectangle", "Oval" };
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

    private static class ShapePanel extends JPanel {
        private int shapeType = 0;
        private final Random random = new Random();

        // All 13 predefined Color constants
        private static final Color[] COLORS = {
            Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
        };

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

                g.setColor(COLORS[random.nextInt(COLORS.length)]);

                switch (shapeType) {
                    case 0:
                        g.drawLine(x, y, x + w, y + h);
                        break;
                    case 1:
                        g.drawRect(x, y, w, h);
                        break;
                    case 2:
                        g.drawOval(x, y, w, h);
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_29_RandomColors().setVisible(true));
    }
}
