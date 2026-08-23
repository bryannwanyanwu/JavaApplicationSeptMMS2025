import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

public class Ex13_17_CircleInfo extends JFrame {

    private final JTextField radiusField = new JTextField(6);
    private final JTextField xField = new JTextField(6);
    private final JTextField yField = new JTextField(6);
    private final JLabel infoLabel = new JLabel(" ");
    private final CirclePanel circlePanel = new CirclePanel();

    public Ex13_17_CircleInfo() {
        super("Circle Info - Ellipse2D.Double");
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Radius:"));
        inputPanel.add(radiusField);
        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener((ActionEvent e) -> drawCircle());
        inputPanel.add(drawButton);

        add(inputPanel, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void drawCircle() {
        try {
            double radius = Double.parseDouble(radiusField.getText().trim());
            double x = Double.parseDouble(xField.getText().trim());
            double y = Double.parseDouble(yField.getText().trim());

            double diameter = 2 * radius;
            double circumference = 2 * Math.PI * radius;
            double area = Math.PI * radius * radius;

            infoLabel.setText(String.format(
                "Diameter: %.2f   Circumference: %.2f   Area: %.2f", diameter, circumference, area));

            circlePanel.setCircle(x, y, radius);
        } catch (NumberFormatException ex) {
            infoLabel.setText("Please enter valid numbers for radius, x and y.");
        }
    }

    private static class CirclePanel extends JPanel {
        private Double centerX, centerY, radius;

        void setCircle(double x, double y, double r) {
            this.centerX = x;
            this.centerY = y;
            this.radius = r;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (radius != null) {
                Graphics2D g2d = (Graphics2D) g;
                Ellipse2D.Double circle = new Ellipse2D.Double(
                    centerX - radius, centerY - radius, 2 * radius, 2 * radius);
                g2d.draw(circle);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_17_CircleInfo().setVisible(true));
    }
}
