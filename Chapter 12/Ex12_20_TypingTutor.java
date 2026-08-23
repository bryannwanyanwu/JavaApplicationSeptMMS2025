// Exercise 12.20: Typing Tutor
// Displays a virtual keyboard as JButtons. As the user types on the real
// keyboard, the corresponding JButton highlights and the character is added
// to a JTextArea. Also tracks correct/incorrect keystrokes against a target
// pangram.
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Ex12_20_TypingTutor extends JFrame {

    private static final String TARGET_PHRASE = "The quick brown fox jumped over a lazy dog.";

    private final JTextArea typedArea = new JTextArea(4, 40);
    private final JLabel targetLabel = new JLabel(
        "<html>Type this phrase:<br><b>" + TARGET_PHRASE + "</b></html>");
    private final JLabel statsLabel = new JLabel("Correct: 0   Incorrect: 0");
    private final Map<Character, JButton> keyButtons = new HashMap<>();

    private int correctCount = 0;
    private int incorrectCount = 0;
    private int position = 0; // index into TARGET_PHRASE

    private static final String[][] KEY_ROWS = {
        { "`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=" },
        { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" },
        { "A", "S", "D", "F", "G", "H", "J", "K", "L" },
        { "Z", "X", "C", "V", "B", "N", "M" },
        { "Space" }
    };

    public Ex12_20_TypingTutor() {
        super("Typing Tutor");

        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        targetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(targetLabel);
        topPanel.add(statsLabel);
        statsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(topPanel, BorderLayout.NORTH);

        typedArea.setEditable(false);
        typedArea.setLineWrap(true);
        add(new JScrollPane(typedArea), BorderLayout.CENTER);

        JPanel keyboardPanel = buildKeyboard();
        add(keyboardPanel, BorderLayout.SOUTH);

        // Hidden focus-catcher: the whole frame listens for real key presses
        setFocusable(true);
        addKeyListener(new TypingKeyListener());

        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel buildKeyboard() {
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new BoxLayout(keyboardPanel, BoxLayout.Y_AXIS));

        for (String[] row : KEY_ROWS) {
            JPanel rowPanel = new JPanel();
            for (String keyLabel : row) {
                JButton button = new JButton(keyLabel);
                button.setFocusable(false); // keep focus on the frame's KeyListener
                if (keyLabel.equals("Space")) {
                    button.setPreferredSize(new Dimension(300, 40));
                    keyButtons.put(' ', button);
                } else {
                    button.setPreferredSize(new Dimension(40, 40));
                    keyButtons.put(keyLabel.charAt(0), button);
                }
                rowPanel.add(button);
            }
            keyboardPanel.add(rowPanel);
        }
        return keyboardPanel;
    }

    private class TypingKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            char typedChar = Character.toUpperCase(e.getKeyChar());
            JButton button = keyButtons.get(typedChar == ' ' ? ' ' : typedChar);

            if (button != null) {
                // Highlight the key
                button.putClientProperty("originalBackground", button.getBackground());
                button.setBackground(Color.YELLOW);
            }

            char actual = e.getKeyChar();
            typedArea.append(String.valueOf(actual));

            if (position < TARGET_PHRASE.length() && actual == TARGET_PHRASE.charAt(position)) {
                correctCount++;
            } else {
                incorrectCount++;
            }
            position++;

            statsLabel.setText("Correct: " + correctCount + "   Incorrect: " + incorrectCount);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            char typedChar = Character.toUpperCase(e.getKeyChar());
            JButton button = keyButtons.get(typedChar == ' ' ? ' ' : typedChar);

            if (button != null) {
                Object original = button.getClientProperty("originalBackground");
                if (original instanceof Color) {
                    button.setBackground((Color) original);
                } else {
                    button.setBackground(null);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ex12_20_TypingTutor frame = new Ex12_20_TypingTutor();
            frame.setVisible(true);
            frame.requestFocusInWindow();
        });
    }
}
