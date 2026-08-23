// Exercise 12.13: Temperature-Conversion Modification
// Allows conversion between Fahrenheit, Celsius and Kelvin, in any direction.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex12_13_TemperatureConversionEnhanced extends JFrame {

    private final JTextField inputField;
    private final JComboBox<String> fromCombo;
    private final JComboBox<String> toCombo;
    private final JLabel resultLabel;
    private final JButton convertButton;

    private static final String[] SCALES = { "Fahrenheit", "Celsius", "Kelvin" };

    public Ex12_13_TemperatureConversionEnhanced() {
        super("Temperature Conversion (F / C / K)");

        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Enter temperature:"));
        inputField = new JTextField(10);
        add(inputField);

        add(new JLabel("From scale:"));
        fromCombo = new JComboBox<>(SCALES);
        add(fromCombo);

        add(new JLabel("To scale:"));
        toCombo = new JComboBox<>(SCALES);
        toCombo.setSelectedIndex(1);
        add(toCombo);

        convertButton = new JButton("Convert");
        add(convertButton);
        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    double value = Double.parseDouble(inputField.getText());
                    String from = (String) fromCombo.getSelectedItem();
                    String to = (String) toCombo.getSelectedItem();

                    // First convert the input to Celsius as a common intermediate scale
                    double celsius;
                    switch (from) {
                        case "Fahrenheit":
                            celsius = (5.0 / 9.0) * (value - 32);
                            break;
                        case "Kelvin":
                            celsius = value - 273.15;
                            break;
                        default: // Celsius
                            celsius = value;
                    }

                    // Then convert from Celsius to the target scale
                    double result;
                    switch (to) {
                        case "Fahrenheit":
                            result = celsius * 9.0 / 5.0 + 32;
                            break;
                        case "Kelvin":
                            result = celsius + 273.15;
                            break;
                        default: // Celsius
                            result = celsius;
                    }

                    resultLabel.setText(String.format("Result: %.2f %s", result, to));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Result: (enter a valid number)");
                }
            }
        });

        setSize(400, 160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_13_TemperatureConversionEnhanced().setVisible(true));
    }
}
