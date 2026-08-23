import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyShape {
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillOval(topLeftX(), topLeftY(), width(), height());
        } else {
            g.drawOval(topLeftX(), topLeftY(), width(), height());
        }
    }
}
