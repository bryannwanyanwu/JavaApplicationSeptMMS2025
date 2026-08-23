import javax.swing.*;
import java.awt.*;
import java.util.Random;

// NOTE: this version calls repaint() as the last line of paintComponent, as the
// exercise asks. In practice this can cause very high CPU usage/flicker since it
// triggers a continuous repaint loop with no throttling (that's the "problem" the
// exercise wants you to notice) -- Exercise 13.19 fixes this with a Timer instead.
public class Ex13_18_ScreenSaver extends JFrame {
    public Ex13_18_ScreenSaver() {
        super("Screen Saver (repaint loop)");
        add(new ScreenSaverPanel());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class ScreenSaverPanel extends JPanel {
        private final Random random = new Random();
        private int lineCount = 0;

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
                lineCount = 0; // reset and clear on next paintComponent call
            }

            repaint(); // continuously repaint -- can be CPU-intensive
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_18_ScreenSaver().setVisible(true));
    }
}
