import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Ex13_22_ScreenSaverJava2D extends JFrame {

    private final ScreenSaverPanel screenSaverPanel = new ScreenSaverPanel();
    private final JTextField countField = new JTextField("100", 6);

    public Ex13_22_ScreenSaverJava2D() {
        super("Screen Saver (Java 2D gradients)");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Number of shapes before clearing:"));
        topPanel.add(countField);
        add(topPanel, BorderLayout.NORTH);
        add(screenSaverPanel, BorderLayout.CENTER);

        countField.addActionListener(new CountFieldHandler());

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private class CountFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                int newMax = Integer.parseInt(countField.getText().trim());
                if (newMax > 0) {
                    screenSaverPanel.setMaxShapes(newMax);
                }
            } catch (NumberFormatException ex) {
                // ignore invalid input
            }
        }
    }

    private static class ScreenSaverPanel extends JPanel implements ActionListener {
        private final Random random = new Random();
        private int shapeCount = 0;
        private int maxShapes = 100;
        private final Timer timer;

        public ScreenSaverPanel() {
            timer = new Timer(1000, this);
            timer.start();
        }

        public void setMaxShapes(int maxShapes) {
            this.maxShapes = maxShapes;
            shapeCount = 0;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            repaint();
        }

        private Color randomColor() {
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            if (shapeCount == 0) {
                super.paintComponent(g2d);
            }

            if (shapeCount < maxShapes) {
                int width = getWidth();
                int height = getHeight();
                int x = random.nextInt(Math.max(width - 60, 1));
                int y = random.nextInt(Math.max(height - 60, 1));
                int w = 30 + random.nextInt(100);
                int h = 30 + random.nextInt(100);

                GradientPaint gradient = new GradientPaint(
                    x, y, randomColor(), x + w, y + h, randomColor());
                g2d.setPaint(gradient);

                if (random.nextBoolean()) {
                    g2d.fill(new Rectangle2D.Double(x, y, w, h));
                } else {
                    g2d.fill(new Ellipse2D.Double(x, y, w, h));
                }

                shapeCount++;
            } else {
                shapeCount = 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_22_ScreenSaverJava2D().setVisible(true));
    }
}
