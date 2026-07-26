import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;
import static java.lang.Math.random;

public class DrawPanel extends JPanel {
    private SecureRandom randomNumbers = new SecureRandom();
    private MyLine[] lines;
    
    public DrawPanel() {
        setBackground(Color.WHITE);
        lines = new MyLine[5 + (int)(random() * 5)];
        
        for (int count = 0; count < lines.length; count++) {
            int x1 = (int)(random() * 300);
            int y1 = (int)(random() * 300);
            int x2 = (int)(random() * 300);
            int y2 = (int)(random() * 300);
            
            Color color = new Color((int)(random() * 256),
                (int)(random() * 256), (int)(random() * 256));
            
            lines[count] = new MyLine(x1, y1, x2, y2, color);
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyLine line : lines)
            line.draw(g);
    }
}