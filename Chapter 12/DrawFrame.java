// Exercise 12.17: DrawFrame
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawFrame extends JFrame {

    private final DrawPanel drawPanel;
    private final JLabel statusLabel;

    private static final String[] COLOR_NAMES = {
        "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green",
        "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
    };

    private static final Color[] COLORS = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    public DrawFrame() {
        super("Drawing Application");

        setLayout(new BorderLayout());

        // Status bar must exist before DrawPanel, since it's passed to its constructor
        statusLabel = new JLabel("x: 0, y: 0");

        drawPanel = new DrawPanel(statusLabel);
        drawPanel.setPreferredSize(new Dimension(500, 400));

        // ---- North panel: controls ----
        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener((ActionEvent e) -> drawPanel.clearLastShape());
        controlPanel.add(undoButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> drawPanel.clearDrawing());
        controlPanel.add(clearButton);

        JComboBox<String> colorComboBox = new JComboBox<>(COLOR_NAMES);
        colorComboBox.addActionListener((ActionEvent e) ->
            drawPanel.setCurrentColor(COLORS[colorComboBox.getSelectedIndex()]));
        controlPanel.add(new JLabel("Color:"));
        controlPanel.add(colorComboBox);

        String[] shapeNames = { "Line", "Rectangle", "Oval" };
        JComboBox<String> shapeComboBox = new JComboBox<>(shapeNames);
        shapeComboBox.addActionListener((ActionEvent e) ->
            drawPanel.setShapeType(shapeComboBox.getSelectedIndex()));
        controlPanel.add(new JLabel("Shape:"));
        controlPanel.add(shapeComboBox);

        JCheckBox filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.addItemListener(e ->
            drawPanel.setFilledShape(filledCheckBox.isSelected()));
        controlPanel.add(filledCheckBox);

        add(controlPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
