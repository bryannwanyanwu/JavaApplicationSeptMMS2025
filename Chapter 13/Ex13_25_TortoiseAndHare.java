import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Random;

// Graphical Tortoise and Hare race (Exercise 6.28) along an arc "mountain"
// from the bottom-left to the top-right of the window. Race length extended
// to 300 as suggested by the exercise.
public class Ex13_25_TortoiseAndHare extends JFrame {

    private static final int RACE_LENGTH = 300;
    private final Random random = new Random();

    private int tortoisePosition = 0;
    private int harePosition = 0;
    private boolean raceOver = false;
    private String winnerMessage = "";
    private Timer timer;

    private final RacePanel racePanel = new RacePanel();
    private final JLabel statusLabel = new JLabel("Click Start Race", SwingConstants.CENTER);

    public Ex13_25_TortoiseAndHare() {
        super("Tortoise and Hare");
        setLayout(new BorderLayout());

        JButton startButton = new JButton("Start Race");
        startButton.addActionListener((ActionEvent e) -> startRace());
        add(startButton, BorderLayout.NORTH);
        add(racePanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void startRace() {
        tortoisePosition = 0;
        harePosition = 0;
        raceOver = false;
        winnerMessage = "";

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (raceOver) {
                    timer.stop();
                    return;
                }
                moveTortoise();
                moveHare();
                checkWinner();
                racePanel.repaint();
            }
        });
        timer.start();
    }

    private void moveTortoise() {
        int move = random.nextInt(10) + 1;
        if (move <= 5) {         // 50% fast plod: 3 squares to the right
            tortoisePosition += 3;
        } else if (move <= 7) {  // 20% slip: 6 squares to the left
            tortoisePosition -= 6;
        } else {                 // 30% slow plod: 1 square to the right
            tortoisePosition += 1;
        }
        if (tortoisePosition < 0) tortoisePosition = 0;
    }

    private void moveHare() {
        int move = random.nextInt(10) + 1;
        if (move <= 2) {         // 20% big hop: 9 squares right
            harePosition += 9;
        } else if (move <= 3) {  // 10% big slip: 12 squares left
            harePosition -= 12;
        } else if (move <= 6) {  // 30% small hop: 1 square right
            harePosition += 1;
        } else if (move <= 8) {  // 20% small slip: 2 squares left
            harePosition -= 2;
        } else {                 // 20% sleep: no move
            // no change
        }
        if (harePosition < 0) harePosition = 0;
    }

    private void checkWinner() {
        if (tortoisePosition >= RACE_LENGTH && harePosition >= RACE_LENGTH) {
            winnerMessage = "It's a tie!";
            raceOver = true;
        } else if (tortoisePosition >= RACE_LENGTH) {
            winnerMessage = "Tortoise wins!";
            raceOver = true;
        } else if (harePosition >= RACE_LENGTH) {
            winnerMessage = "Hare wins!";
            raceOver = true;
        }
        statusLabel.setText(raceOver ? winnerMessage
            : String.format("Tortoise: %d   Hare: %d", tortoisePosition, harePosition));
    }

    private class RacePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();
            int margin = 40;

            // Mountain arc from bottom-left to top-right
            Arc2D.Double mountain = new Arc2D.Double(
                margin - width, margin, 2.0 * (width - 2 * margin), 2.0 * (height - 2 * margin),
                270, 90, Arc2D.OPEN);
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.DARK_GRAY);
            g2d.draw(mountain);

            // Position along the arc for a given race distance (0..RACE_LENGTH)
            drawRacer(g2d, tortoisePosition, "T", Color.GREEN, margin, width, height);
            drawRacer(g2d, harePosition, "H", Color.ORANGE, margin, width, height);
        }

        private void drawRacer(Graphics2D g2d, int position, String label, Color color,
                                int margin, int width, int height) {
            double fraction = Math.min(1.0, (double) position / RACE_LENGTH);
            // Simple linear interpolation from bottom-left to top-right as a stand-in
            // for "position along the arc"
            int x = (int) (margin + fraction * (width - 2 * margin));
            int y = (int) (height - margin - fraction * (height - 2 * margin));

            g2d.setColor(color);
            g2d.fillOval(x - 10, y - 10, 20, 20);
            g2d.setColor(Color.BLACK);
            g2d.drawString(label, x - 4, y + 4);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_25_TortoiseAndHare().setVisible(true));
    }
}
