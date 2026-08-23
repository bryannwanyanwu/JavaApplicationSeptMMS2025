import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

// GUI version of Turtle Graphics (Exercise 6.21). Commands are entered as
// space-separated tokens, one command per line, e.g.:
//   2 (pen down)
//   5 (move forward 5 positions = 50 pixels)
//   1 (turn right)
//   5
// Commands supported: 1 = turn right, 2 = turn left*, 3 = pen up, 4 = pen down,
// 5 <n> = move forward n positions, 6 = print (no-op here), 9 = end of script.
// (*Adjust to match whatever numbering your Exercise 6.21 solution used --
// the important part demonstrated here is the GUI + Java 2D drawing.)
public class Ex13_23_TurtleGraphics extends JFrame {

    private final JTextArea commandArea = new JTextArea(15, 20);
    private final TurtlePanel turtlePanel = new TurtlePanel();

    public Ex13_23_TurtleGraphics() {
        super("Turtle Graphics");
        setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Commands (one per line):"), BorderLayout.NORTH);
        leftPanel.add(new JScrollPane(commandArea), BorderLayout.CENTER);

        JButton runButton = new JButton("Run");
        runButton.addActionListener((ActionEvent e) -> turtlePanel.runProgram(commandArea.getText()));

        JButton clearButton = new JButton("Clear Drawing");
        clearButton.addActionListener((ActionEvent e) -> turtlePanel.clear());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(runButton);
        buttonPanel.add(clearButton);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.WEST);
        add(turtlePanel, BorderLayout.CENTER);

        // Example program: draw a square
        commandArea.setText("4\n5 10\n1\n5 10\n1\n5 10\n1\n5 10\n9");

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class TurtlePanel extends JPanel {
        private static final int PIXELS_PER_POSITION = 10;
        private final List<Line2D.Double> segments = new ArrayList<>();

        void clear() {
            segments.clear();
            repaint();
        }

        void runProgram(String program) {
            segments.clear();

            double x = getWidth() / 2.0;
            double y = getHeight() / 2.0;
            int angle = 0; // 0 = facing right (east), increases counter-clockwise
            boolean penDown = true;

            String[] lines = program.split("\\r?\\n");
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] tokens = line.split("\\s+");
                int command = Integer.parseInt(tokens[0]);

                switch (command) {
                    case 1: // turn right 90 degrees
                        angle = (angle - 90 + 360) % 360;
                        break;
                    case 2: // turn left 90 degrees
                        angle = (angle + 90) % 360;
                        break;
                    case 3: // pen up
                        penDown = false;
                        break;
                    case 4: // pen down
                        penDown = true;
                        break;
                    case 5: // move forward n positions
                        int positions = tokens.length > 1 ? Integer.parseInt(tokens[1]) : 1;
                        double radians = Math.toRadians(angle);
                        double newX = x + positions * PIXELS_PER_POSITION * Math.cos(radians);
                        double newY = y - positions * PIXELS_PER_POSITION * Math.sin(radians);
                        if (penDown) {
                            segments.add(new Line2D.Double(x, y, newX, newY));
                        }
                        x = newX;
                        y = newY;
                        break;
                    case 9: // end of script
                        break;
                    default:
                        // unknown command: ignore
                }
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(Color.BLACK);
            for (Line2D.Double segment : segments) {
                g2d.draw(segment);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_23_TurtleGraphics().setVisible(true));
    }
}
