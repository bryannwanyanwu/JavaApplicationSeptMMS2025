import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {
    public MyLine(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled); // filled is irrelevant for a line
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
