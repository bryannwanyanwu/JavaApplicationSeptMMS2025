// Exercise 12.12: Temperature-conversion application
// Converts a Fahrenheit temperature (typed into a JTextField) to Celsius
// and displays the result in a JLabel.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex12_12_TemperatureConversion extends JFrame {

    private final JTextField fahrenheitField;
    private final JLabel celsiusLabel;

    public Ex12_12_TemperatureConversion() {
        super("Temperature Conversion");

        setLayout(new FlowLayout());

        add(new JLabel("Enter Fahrenheit temperature:"));

        fahrenheitField = new JTextField(10);
        add(fahrenheitField);

        celsiusLabel = new JLabel("Celsius: ");
        add(celsiusLabel);

        // Convert every time the user presses Enter in the text field
        fahrenheitField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = (5.0 / 9.0) * (fahrenheit - 32);
                    celsiusLabel.setText(String.format("Celsius: %.2f", celsius));
                } catch (NumberFormatException ex) {
                    celsiusLabel.setText("Celsius: (enter a valid number)");
                }
            }
        });

        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_12_TemperatureConversion().setVisible(true));
    }
}
