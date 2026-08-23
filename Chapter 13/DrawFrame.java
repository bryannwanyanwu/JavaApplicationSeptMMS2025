// Exercise 13.31: DrawFrame with Java 2D gradient/stroke controls added
// below the standard shape-controls panel from Exercise 12.17.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawFrame extends JFrame {

    private final DrawPanel drawPanel;
    private final JLabel statusLabel;

    private Color color1 = Color.BLACK;
    private Color color2 = Color.WHITE;
    private boolean useGradient = false;
    private boolean dashedLine = false;
    private float strokeWidth = 1f;
    private float dashLength = 10f;

    public DrawFrame() {
        super("Drawing Application with Java 2D");
        setLayout(new BorderLayout());

        statusLabel = new JLabel("x: 0, y: 0");
        drawPanel = new DrawPanel(statusLabel);
        drawPanel.setPreferredSize(new Dimension(500, 400));

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(buildStandardControls());
        northPanel.add(buildJava2DControls());

        add(northPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // ---- Standard shape controls (from Exercise 12.17) ----
    private JPanel buildStandardControls() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener((ActionEvent e) -> drawPanel.clearLastShape());
        controlPanel.add(undoButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> drawPanel.clearDrawing());
        controlPanel.add(clearButton);

        String[] shapeNames = { "Line", "Rectangle", "Oval" };
        JComboBox<String> shapeComboBox = new JComboBox<>(shapeNames);
        shapeComboBox.addActionListener((ActionEvent e) ->
            drawPanel.setShapeType(shapeComboBox.getSelectedIndex()));
        controlPanel.add(new JLabel("Shape:"));
        controlPanel.add(shapeComboBox);

        JCheckBox filledCheckBox = new JCheckBox("Filled");
        filledCheckBox.addItemListener(e -> drawPanel.setFilledShape(filledCheckBox.isSelected()));
        controlPanel.add(filledCheckBox);

        return controlPanel;
    }

    // ---- New Java 2D controls (Exercise 13.31) ----
    private JPanel buildJava2DControls() {
        JPanel panel = new JPanel(new FlowLayout());

        JCheckBox gradientCheckBox = new JCheckBox("Use Gradient");
        gradientCheckBox.addItemListener(e -> {
            useGradient = gradientCheckBox.isSelected();
            updatePaint();
        });
        panel.add(gradientCheckBox);

        JButton color1Button = new JButton("Color 1");
        color1Button.addActionListener((ActionEvent e) -> {
            Color chosen = JColorChooser.showDialog(this, "Choose First Color", color1);
            if (chosen != null) {
                color1 = chosen;
                updatePaint();
            }
        });
        panel.add(color1Button);

        JButton color2Button = new JButton("Color 2");
        color2Button.addActionListener((ActionEvent e) -> {
            Color chosen = JColorChooser.showDialog(this, "Choose Second Color", color2);
            if (chosen != null) {
                color2 = chosen;
                updatePaint();
            }
        });
        panel.add(color2Button);

        panel.add(new JLabel("Stroke Width:"));
        JTextField widthField = new JTextField("1", 4);
        widthField.addActionListener((ActionEvent e) -> {
            try {
                strokeWidth = Float.parseFloat(widthField.getText().trim());
            } catch (NumberFormatException ex) {
                strokeWidth = 1f;
            }
            updateStroke();
        });
        panel.add(widthField);

        panel.add(new JLabel("Dash Length:"));
        JTextField dashField = new JTextField("10", 4);
        dashField.addActionListener((ActionEvent e) -> {
            try {
                dashLength = Float.parseFloat(dashField.getText().trim());
            } catch (NumberFormatException ex) {
                dashLength = 10f;
            }
            updateStroke();
        });
        panel.add(dashField);

        JCheckBox dashedCheckBox = new JCheckBox("Dashed Line");
        dashedCheckBox.addItemListener(e -> {
            dashedLine = dashedCheckBox.isSelected();
            updateStroke();
        });
        panel.add(dashedCheckBox);

        // Initialize with defaults
        updatePaint();
        updateStroke();

        return panel;
    }

    private void updatePaint() {
        if (useGradient) {
            drawPanel.setCurrentPaint(new GradientPaint(0, 0, color1, 50, 50, color2, true));
        } else {
            drawPanel.setCurrentPaint(color1);
        }
    }

    private void updateStroke() {
        if (dashedLine) {
            float[] dashes = { dashLength };
            drawPanel.setCurrentStroke(new BasicStroke(
                strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0));
        } else {
            drawPanel.setCurrentStroke(new BasicStroke(
                strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        }
    }
}
