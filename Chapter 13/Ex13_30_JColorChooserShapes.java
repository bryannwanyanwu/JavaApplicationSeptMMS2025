import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Ex13_30_JColorChooserShapes extends JFrame {

    private final ShapePanel shapePanel = new ShapePanel();

    public Ex13_30_JColorChooserShapes() {
        super("Selecting Shapes - JColorChooser");
        setLayout(new BorderLayout());

        String[] shapeNames = { "Line", "Rectangle", "Oval" };
        JComboBox<String> shapeCombo = new JComboBox<>(shapeNames);
        shapeCombo.addActionListener((ActionEvent e) ->
            shapePanel.setShapeType(shapeCombo.getSelectedIndex()));

        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener((ActionEvent e) -> {
            Color chosen = JColorChooser.showDialog(this, "Choose Shape Color", shapePanel.getShapeColor());
            if (chosen != null) {
                shapePanel.setShapeColor(chosen);
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Shape:"));
        topPanel.add(shapeCombo);
        topPanel.add(colorButton);
        add(topPanel, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class ShapePanel extends JPanel {
        private int shapeType = 0;
        private Color shapeColor = Color.BLACK;
        private final Random random = new Random();

        void setShapeType(int shapeType) {
            this.shapeType = shapeType;
            repaint();
        }

        void setShapeColor(Color color) {
            this.shapeColor = color;
            repaint();
        }

        Color getShapeColor() {
            return shapeColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            g.setColor(shapeColor);
            for (int i = 0; i < 20; i++) {
                int x = random.nextInt(Math.max(width - 50, 1));
                int y = random.nextInt(Math.max(height - 50, 1));
                int w = 10 + random.nextInt(80);
                int h = 10 + random.nextInt(80);

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
        SwingUtilities.invokeLater(() -> new Ex13_30_JColorChooserShapes().setVisible(true));
    }
}
