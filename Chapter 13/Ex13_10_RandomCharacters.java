import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Ex13_10_RandomCharacters extends JFrame {
    public Ex13_10_RandomCharacters() {
        super("Random Characters");
        add(new CharactersPanel());
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class CharactersPanel extends JPanel {
        private final Random random = new Random();
        private static final String[] FONT_NAMES = {
            Font.SERIF, Font.SANS_SERIF, Font.MONOSPACED
        };
        private static final int[] FONT_STYLES = {
            Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 20; i++) {
                char c = (char) ('A' + random.nextInt(26));
                String fontName = FONT_NAMES[random.nextInt(FONT_NAMES.length)];
                int style = FONT_STYLES[random.nextInt(FONT_STYLES.length)];
                int size = 10 + random.nextInt(60);

                g.setFont(new Font(fontName, style, size));
                g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                g.drawString(String.valueOf(c), random.nextInt(width), random.nextInt(height));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_10_RandomCharacters().setVisible(true));
    }
}
