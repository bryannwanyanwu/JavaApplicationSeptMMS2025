import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Arc2D;

public class Ex13_27_PieChart extends JFrame {

    private final JTextField[] valueFields = new JTextField[4];
    private final PiePanel piePanel = new PiePanel();

    private static final Color[] SLICE_COLORS = {
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW
    };

    public Ex13_27_PieChart() {
        super("Pie Chart");
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            inputPanel.add(new JLabel("Value " + (i + 1) + ":"));
            valueFields[i] = new JTextField(5);
            inputPanel.add(valueFields[i]);
        }

        JButton drawButton = new JButton("Draw Pie Chart");
        drawButton.addActionListener((ActionEvent e) -> drawChart());
        inputPanel.add(drawButton);

        add(inputPanel, BorderLayout.NORTH);
        add(piePanel, BorderLayout.CENTER);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void drawChart() {
        try {
            double[] values = new double[4];
            for (int i = 0; i < 4; i++) {
                values[i] = Double.parseDouble(valueFields[i].getText().trim());
            }
            piePanel.setValues(values);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter four valid numbers.");
        }
    }

    private static class PiePanel extends JPanel {
        private double[] values;

        void setValues(double[] values) {
            this.values = values;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (values == null) return;

            Graphics2D g2d = (Graphics2D) g;

            double total = 0;
            for (double v : values) total += v;
            if (total <= 0) return;

            int diameter = Math.min(getWidth(), getHeight()) - 40;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            double startAngle = 0;
            for (int i = 0; i < values.length; i++) {
                double sweepAngle = (values[i] / total) * 360.0;
                Arc2D.Double slice = new Arc2D.Double(x, y, diameter, diameter,
                    startAngle, sweepAngle, Arc2D.PIE);
                g2d.setColor(SLICE_COLORS[i % SLICE_COLORS.length]);
                g2d.fill(slice);
                g2d.setColor(Color.BLACK);
                g2d.draw(slice);
                startAngle += sweepAngle;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_27_PieChart().setVisible(true));
    }
}
