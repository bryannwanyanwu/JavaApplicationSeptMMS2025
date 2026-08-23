import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ex13_20_ScreenSaverUserCount extends JFrame {

    private final ScreenSaverPanel screenSaverPanel = new ScreenSaverPanel();
    private final JTextField countField = new JTextField("100", 6);

    public Ex13_20_ScreenSaverUserCount() {
        super("Screen Saver (user-specified line count)");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Number of lines before clearing:"));
        topPanel.add(countField);
        add(topPanel, BorderLayout.NORTH);
        add(screenSaverPanel, BorderLayout.CENTER);

        // Inner class handles the text field's events
        countField.addActionListener(new CountFieldHandler());

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Inner class for event handling, as required by the exercise
    private class CountFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                int newMax = Integer.parseInt(countField.getText().trim());
                if (newMax > 0) {
                    screenSaverPanel.setMaxLines(newMax);
                }
            } catch (NumberFormatException ex) {
                // ignore invalid input; keep the previous max line count
            }
        }
    }

    private static class ScreenSaverPanel extends JPanel implements ActionListener {
        private final Random random = new Random();
        private int lineCount = 0;
        private int maxLines = 100;
        private final Timer timer;

        public ScreenSaverPanel() {
            timer = new Timer(1000, this);
            timer.start();
        }

        public void setMaxLines(int maxLines) {
            this.maxLines = maxLines;
            lineCount = 0; // start over with the new limit
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (lineCount == 0) {
                super.paintComponent(g);
            }

            if (lineCount < maxLines) {
                int x1 = random.nextInt(getWidth());
                int y1 = random.nextInt(getHeight());
                int x2 = random.nextInt(getWidth());
                int y2 = random.nextInt(getHeight());
                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g.drawLine(x1, y1, x2, y2);
                lineCount++;
            } else {
                lineCount = 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_20_ScreenSaverUserCount().setVisible(true));
    }
}
