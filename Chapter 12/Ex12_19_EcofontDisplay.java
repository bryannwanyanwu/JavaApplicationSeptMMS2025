// Exercise 12.19: Ecofont
// Lets the user type text and view it in the Ecofont, with buttons to
// increase/decrease the font size one point at a time (starting at 9pt).
//
// NOTE: This requires the Ecofont font file (Spranq_eco_sans_regular.ttf),
// downloaded from www.ecofont.eu and installed/registered with Java as shown
// below. If the font file is not found, the app falls back to a sans-serif
// font so it still runs.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Ex12_19_EcofontDisplay extends JFrame {

    private static final String FONT_FILE = "Spranq_eco_sans_regular.ttf";
    private static final int STARTING_SIZE = 9;

    private Font baseFont;
    private int currentSize = STARTING_SIZE;

    private final JTextField inputField = new JTextField(30);
    private final JLabel displayLabel = new JLabel(" ");
    private final JLabel sizeLabel = new JLabel();

    public Ex12_19_EcofontDisplay() {
        super("Ecofont Viewer");

        baseFont = loadEcofont();

        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Type text:"));
        topPanel.add(inputField);
        add(topPanel, BorderLayout.NORTH);

        displayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateFont();
        add(displayLabel, BorderLayout.CENTER);

        inputField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { updateText(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { updateText(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { updateText(); }
        });

        JPanel bottomPanel = new JPanel();
        JButton increaseButton = new JButton("Increase Font Size");
        increaseButton.addActionListener((ActionEvent e) -> {
            currentSize++;
            updateFont();
        });

        JButton decreaseButton = new JButton("Decrease Font Size");
        decreaseButton.addActionListener((ActionEvent e) -> {
            if (currentSize > 1) {
                currentSize--;
                updateFont();
            }
        });

        bottomPanel.add(decreaseButton);
        bottomPanel.add(sizeLabel);
        bottomPanel.add(increaseButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private Font loadEcofont() {
        try {
            File fontFile = new File(FONT_FILE);
            if (fontFile.exists()) {
                return Font.createFont(Font.TRUETYPE_FONT, fontFile);
            }
        } catch (FontFormatException | IOException ex) {
            // fall through to default font below
        }
        // Fallback so the program still runs without the font file present
        return new Font(Font.SANS_SERIF, Font.PLAIN, STARTING_SIZE);
    }

    private void updateFont() {
        displayLabel.setFont(baseFont.deriveFont((float) currentSize));
        sizeLabel.setText(currentSize + " pt");
    }

    private void updateText() {
        displayLabel.setText(inputField.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_19_EcofontDisplay().setVisible(true));
    }
}
