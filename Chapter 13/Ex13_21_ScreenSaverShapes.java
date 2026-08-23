import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ex13_21_ScreenSaverShapes extends JFrame {

    private final ScreenSaverPanel screenSaverPanel = new ScreenSaverPanel();
    private final JTextField countField = new JTextField("100", 6);

    public Ex13_21_ScreenSaverShapes() {
        super("Screen Saver (random shapes)");
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

        private static final int LINE = 0, RECTANGLE = 1, OVAL = 2, ARC = 3;

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

        @Override
        protected void paintComponent(Graphics g) {
            if (shapeCount == 0) {
                super.paintComponent(g);
            }

            if (shapeCount < maxShapes) {
                int width = getWidth();
                int height = getHeight();
                int x = random.nextInt(Math.max(width - 50, 1));
                int y = random.nextInt(Math.max(height - 50, 1));
                int w = 20 + random.nextInt(80);
                int h = 20 + random.nextInt(80);

                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

                switch (random.nextInt(4)) {
                    case LINE:
                        g.drawLine(x, y, x + w, y + h);
                        break;
                    case RECTANGLE:
                        g.drawRect(x, y, w, h);
                        break;
                    case OVAL:
                        g.drawOval(x, y, w, h);
                        break;
                    case ARC:
                        g.drawArc(x, y, w, h, 0, 180);
                        break;
                }
                shapeCount++;
            } else {
                shapeCount = 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_21_ScreenSaverShapes().setVisible(true));
    }
}
