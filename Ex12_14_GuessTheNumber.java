// Exercise 12.14: Guess-the-Number Game
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ex12_14_GuessTheNumber extends JFrame {

    private final JLabel promptLabel;
    private final JLabel resultLabel;
    private final JTextField guessField;
    private final JButton playAgainButton;

    private final Random random = new Random();
    private int numberToGuess;

    public Ex12_14_GuessTheNumber() {
        super("Guess the Number");

        setLayout(new BorderLayout(10, 10));

        promptLabel = new JLabel(
            "<html>I have a number between 1 and 1000.<br>" +
            "Can you guess my number?<br>Please enter your first guess.</html>",
            SwingConstants.CENTER);
        add(promptLabel, BorderLayout.NORTH);

        guessField = new JTextField(10);
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Your guess:"));
        centerPanel.add(guessField);
        add(centerPanel, BorderLayout.CENTER);

        resultLabel = new JLabel(" ", SwingConstants.CENTER);
        playAgainButton = new JButton("Play Again");

        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        southPanel.add(resultLabel);
        southPanel.add(playAgainButton);
        add(southPanel, BorderLayout.SOUTH);

        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    int guess = Integer.parseInt(guessField.getText().trim());

                    if (guess < numberToGuess) {
                        resultLabel.setText("Too Low");
                        getContentPane().setBackground(Color.BLUE);
                    } else if (guess > numberToGuess) {
                        resultLabel.setText("Too High");
                        getContentPane().setBackground(Color.RED);
                    } else {
                        resultLabel.setText("Correct!");
                        getContentPane().setBackground(Color.GREEN);
                        guessField.setEditable(false);
                    }
                    repaint();
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid integer");
                }
                guessField.selectAll();
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                startNewGame();
            }
        });

        startNewGame();

        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void startNewGame() {
        numberToGuess = 1 + random.nextInt(1000); // 1 to 1000 inclusive
        guessField.setText("");
        guessField.setEditable(true);
        guessField.requestFocusInWindow();
        resultLabel.setText(" ");
        getContentPane().setBackground(null);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_14_GuessTheNumber().setVisible(true));
    }
}
