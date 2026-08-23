// Exercise 12.15: Displaying Events
// Demonstrates ActionListener, ItemListener, ListSelectionListener,
// MouseListener, MouseMotionListener and KeyListener by printing the
// toString() of each event to a JTextArea.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Ex12_15_DisplayingEvents extends JFrame {

    private final JTextArea outputArea;
    private final JButton actionButton;
    private final JCheckBox checkBox;
    private final JList<String> list;
    private final JPanel mousePanel;
    private final JTextField keyField;

    public Ex12_15_DisplayingEvents() {
        super("Displaying Events");

        setLayout(new BorderLayout());

        // ---- Top controls: button (Action), checkbox (Item), list (ListSelection) ----
        JPanel topPanel = new JPanel(new FlowLayout());

        actionButton = new JButton("Click Me (ActionEvent)");
        actionButton.addActionListener(this::logEvent);
        topPanel.add(actionButton);

        checkBox = new JCheckBox("Toggle Me (ItemEvent)");
        checkBox.addItemListener(this::logEvent);
        topPanel.add(checkBox);

        String[] items = { "Item 1", "Item 2", "Item 3" };
        list = new JList<>(items);
        list.setVisibleRowCount(3);
        list.addListSelectionListener(this::logEvent);
        topPanel.add(new JScrollPane(list));

        keyField = new JTextField(10);
        keyField.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) { logEvent(e); }
            @Override public void keyPressed(KeyEvent e) { logEvent(e); }
            @Override public void keyReleased(KeyEvent e) { logEvent(e); }
        });
        topPanel.add(new JLabel("Type here (KeyEvent):"));
        topPanel.add(keyField);

        add(topPanel, BorderLayout.NORTH);

        // ---- Mouse panel: Mouse and MouseMotion events ----
        mousePanel = new JPanel();
        mousePanel.setBackground(Color.LIGHT_GRAY);
        mousePanel.setPreferredSize(new Dimension(300, 150));
        mousePanel.setBorder(BorderFactory.createTitledBorder("Mouse events here"));

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { logEvent(e); }
            @Override public void mousePressed(MouseEvent e) { logEvent(e); }
            @Override public void mouseReleased(MouseEvent e) { logEvent(e); }
            @Override public void mouseEntered(MouseEvent e) { logEvent(e); }
            @Override public void mouseExited(MouseEvent e) { logEvent(e); }
            @Override public void mouseDragged(MouseEvent e) { logEvent(e); }
            @Override public void mouseMoved(MouseEvent e) { logEvent(e); }
        };
        mousePanel.addMouseListener(mouseAdapter);
        mousePanel.addMouseMotionListener(mouseAdapter);

        add(mousePanel, BorderLayout.CENTER);

        // ---- Output area ----
        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Generic logger: uses toString() on the event, as required by the exercise
    private void logEvent(Object event) {
        outputArea.append(event.toString() + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex12_15_DisplayingEvents().setVisible(true));
    }
}
