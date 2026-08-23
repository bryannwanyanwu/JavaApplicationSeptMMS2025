// Exercise 12.16: GUI-Based Craps Game
// A JButton rolls the dice; four JTextFields show die1, die2, sum and point.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Ex12_16_CrapsGame extends JFrame {

    private enum GameStatus { CONTINUE, WON, LOST }

    private final Random random = new Random();
    private int myPoint = 0;
    private GameStatus gameStatus;

    private final JTextField die1Field = new JTextField(5);
    private final JTextField die2Field = new JTextField(5);
    private final JTextField sumField = new JTextField(5);
    private final JTextField pointField = new JTextField(5);
    private final JLabel messageLabel = new JLabel("Click Roll Dice to begin", SwingConstants.CENTER);
    private final JButton rollButton = new JButton("Roll Dice");

    public Ex12_16_CrapsGame() {
        super("Craps");

        setLayout(new BorderLayout(10, 10));

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        fieldsPanel.add(new JLabel("Die 1:", SwingConstants.CENTER));
        fieldsPanel.add(new JLabel("Die 2:", SwingConstants.CENTER));
        fieldsPanel.add(new JLabel("Sum:", SwingConstants.CENTER));
        fieldsPanel.add(new JLabel("Point:", SwingConstants.CENTER));

        die1Field.setEditable(false);
        die2Field.setEditable(false);
        sumField.setEditable(false);
        pointField.setEditable(false);

        fieldsPanel.add(die1Field);
        fieldsPanel.add(die2Field);
        fieldsPanel.add(sumField);
        fieldsPanel.add(pointField);

        add(fieldsPanel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.NORTH);
        add(rollButton, BorderLayout.SOUTH);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (gameStatus == GameStatus.WON || gameStatus == GameStatus.LOST || gameStatus == null) {
                    // starting a fresh game / first roll
                    int[] dice = rollDice();
                    int sum = dice[0] + dice[1];

                    switch (sum) {
                        case 7:
                        case 11:
                            gameStatus = GameStatus.WON;
                            messageLabel.setText("You win!! (Natural " + sum + ")");
                            pointField.setText("");
                            break;
                        case 2:
                        case 3:
                        case 12:
                            gameStatus = GameStatus.LOST;
                            messageLabel.setText("Craps! You lose. (" + sum + ")");
                            pointField.setText("");
                            break;
                        default:
                            gameStatus = GameStatus.CONTINUE;
                            myPoint = sum;
                            pointField.setText(String.valueOf(myPoint));
                            messageLabel.setText("Point is " + myPoint + ". Roll again.");
                    }
                } else {
                    // continuing an existing game — trying to make the point
                    int[] dice = rollDice();
                    int sum = dice[0] + dice[1];

                    if (sum == myPoint) {
                        gameStatus = GameStatus.WON;
                        messageLabel.setText("You made your point! You win!!");
                    } else if (sum == 7) {
                        gameStatus = GameStatus.LOST;
                        messageLabel.setText("Craps! You rolled a 7. You lose.");
                    } else {
                        messageLabel.setText("No match. Point is still " + myPoint + ". Roll again.");
                    }
                }
            }
        });

        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private int[] rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        die1Field.setText(String.valueOf(die1));
        die2Field.setText(String.valueOf(die2));
        sumField.setText(String.valueOf(die1 + die2));
        return new int[] { die1, die2 };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_16_CrapsGame().setVisible(true));
    }
}
