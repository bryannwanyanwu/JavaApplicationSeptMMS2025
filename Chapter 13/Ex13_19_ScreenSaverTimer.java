import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ex13_19_ScreenSaverTimer extends JFrame {
    public Ex13_19_ScreenSaverTimer() {
        super("Screen Saver (Timer-based)");
        add(new ScreenSaverPanel());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class ScreenSaverPanel extends JPanel implements ActionListener {
        private final Random random = new Random();
        private int lineCount = 0;
        private Timer timer;

        public ScreenSaverPanel() {
            timer = new Timer(1000, this);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (lineCount == 0) {
                super.paintComponent(g); // clear the panel
            }

            if (lineCount < 100) {
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
            // no repaint() call here -- the Timer drives repainting instead
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_19_ScreenSaverTimer().setVisible(true));
    }
}
