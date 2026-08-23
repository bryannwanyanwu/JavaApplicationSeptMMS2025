import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Ex13_32_LargeTypeDisplay extends JFrame {

    private static final int CONTROL_FONT_SIZE = 20; // per exercise: controls at 20pt
    private static final int STARTING_TEXT_SIZE = 18;

    private final JTextArea textArea = new JTextArea(10, 40);
    private int currentSize = STARTING_TEXT_SIZE;
    private String currentFontFamily = Font.SERIF;
    private boolean bold = false;

    public Ex13_32_LargeTypeDisplay() {
        super("Large-Type Display");
        setLayout(new BorderLayout(10, 10));

        updateTextAreaFont();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());
        Font controlFont = new Font(Font.SANS_SERIF, Font.PLAIN, CONTROL_FONT_SIZE);

        String[] fontNames = { "Serif", "Sans-serif", "Monospaced" };
        JComboBox<String> fontCombo = new JComboBox<>(fontNames);
        fontCombo.setFont(controlFont);
        fontCombo.addActionListener((ActionEvent e) -> {
            switch (fontCombo.getSelectedIndex()) {
                case 0: currentFontFamily = Font.SERIF; break;
                case 1: currentFontFamily = Font.SANS_SERIF; break;
                case 2: currentFontFamily = Font.MONOSPACED; break;
            }
            updateTextAreaFont();
        });
        controlPanel.add(fontCombo);

        JCheckBox boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.setFont(controlFont);
        boldCheckBox.addItemListener(e -> {
            bold = boldCheckBox.isSelected();
            updateTextAreaFont();
        });
        controlPanel.add(boldCheckBox);

        JButton increaseButton = new JButton("Increase Font Size");
        increaseButton.setFont(controlFont);
        increaseButton.addActionListener((ActionEvent e) -> {
            currentSize++;
            updateTextAreaFont();
        });
        controlPanel.add(increaseButton);

        JButton decreaseButton = new JButton("Decrease Font Size");
        decreaseButton.setFont(controlFont);
        decreaseButton.addActionListener((ActionEvent e) -> {
            if (currentSize > 1) {
                currentSize--;
                updateTextAreaFont();
            }
        });
        controlPanel.add(decreaseButton);

        add(controlPanel, BorderLayout.SOUTH);

        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void updateTextAreaFont() {
        int style = bold ? Font.BOLD : Font.PLAIN;
        textArea.setFont(new Font(currentFontFamily, style, currentSize));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_32_LargeTypeDisplay().setVisible(true));
    }
}
