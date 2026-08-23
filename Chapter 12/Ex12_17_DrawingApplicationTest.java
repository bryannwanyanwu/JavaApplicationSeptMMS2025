// Exercise 12.17: Test class that launches the interactive drawing application
import javax.swing.SwingUtilities;

public class Ex12_17_DrawingApplicationTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawFrame().setVisible(true));
    }
}
