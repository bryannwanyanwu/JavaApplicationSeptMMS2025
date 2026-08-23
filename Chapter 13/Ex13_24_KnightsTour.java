import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Graphical Knight's Tour using the "accessibility heuristic": always move to
// the reachable square with the fewest onward moves. Animated with a Timer.
public class Ex13_24_KnightsTour extends JFrame {

    private static final int BOARD_SIZE = 8;
    private static final int[][] HORIZONTAL_MOVES = {  2,  1, -1, -2, -2, -1,  1,  2 };
    private static final int[][] DUMMY = null; // placeholder not used

    private final int[] horizontal = {  2,  1, -1, -2, -2, -1,  1,  2 };
    private final int[] vertical   = {  1,  2,  2,  1, -1, -2, -2, -1 };

    private final int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    private int currentRow, currentColumn, moveNumber;
    private final BoardPanel boardPanel = new BoardPanel();
    private final JLabel statusLabel = new JLabel("Click Start to begin the tour", SwingConstants.CENTER);
    private Timer timer;

    public Ex13_24_KnightsTour() {
        super("Knight's Tour");
        setLayout(new BorderLayout());

        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        JButton startButton = new JButton("Start Tour");
        startButton.addActionListener((ActionEvent e) -> startTour());
        add(startButton, BorderLayout.NORTH);

        setSize(500, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void startTour() {
        for (int[] row : board) {
            java.util.Arrays.fill(row, 0);
        }
        currentRow = 0;
        currentColumn = 0;
        moveNumber = 1;
        board[currentRow][currentColumn] = moveNumber;
        boardPanel.repaint();

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveNumber == BOARD_SIZE * BOARD_SIZE) {
                    timer.stop();
                    boolean closedTour = isValidMove(currentRow, currentColumn, 0, 0) ||
                        (Math.abs(currentRow - 0) <= 2 && Math.abs(currentColumn - 0) <= 2);
                    statusLabel.setText("Full tour complete! Total squares visited: " + moveNumber);
                    return;
                }

                int[] next = findNextMove();
                if (next == null) {
                    timer.stop();
                    statusLabel.setText("Tour stuck after " + moveNumber + " moves (no full tour found).");
                    return;
                }

                currentRow = next[0];
                currentColumn = next[1];
                moveNumber++;
                board[currentRow][currentColumn] = moveNumber;
                statusLabel.setText("Move " + moveNumber + " of " + (BOARD_SIZE * BOARD_SIZE));
                boardPanel.repaint();
            }
        });
        timer.start();
    }

    // Accessibility heuristic: choose the valid move with the fewest onward moves
    private int[] findNextMove() {
        int minAccessibility = Integer.MAX_VALUE;
        int[] best = null;

        for (int i = 0; i < horizontal.length; i++) {
            int row = currentRow + vertical[i];
            int col = currentColumn + horizontal[i];
            if (isValidMove(row, col, row, col)) {
                int accessibility = countAccessibleMoves(row, col);
                if (accessibility < minAccessibility) {
                    minAccessibility = accessibility;
                    best = new int[] { row, col };
                }
            }
        }
        return best;
    }

    private int countAccessibleMoves(int row, int column) {
        int count = 0;
        for (int i = 0; i < horizontal.length; i++) {
            int r = row + vertical[i];
            int c = column + horizontal[i];
            if (isValidMove(r, c, r, c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidMove(int row, int column, int unusedR, int unusedC) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE
            && board[row][column] == 0;
    }

    private class BoardPanel extends JPanel {
        private static final int CELL_SIZE = 55;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    int x = col * CELL_SIZE;
                    int y = row * CELL_SIZE;

                    g2d.setColor((row + col) % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                    g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                    if (board[row][col] != 0) {
                        String text = String.valueOf(board[row][col]);
                        g2d.drawString(text, x + CELL_SIZE / 2 - 8, y + CELL_SIZE / 2 + 5);
                    }

                    if (row == currentRow && col == currentColumn) {
                        g2d.setColor(Color.RED);
                        g2d.drawOval(x + 5, y + 5, CELL_SIZE - 10, CELL_SIZE - 10);
                    }
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_24_KnightsTour().setVisible(true));
    }
}
