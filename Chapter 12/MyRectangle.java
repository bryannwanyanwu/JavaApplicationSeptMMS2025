
import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyShape {
    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if (filled) {
            g.fillRect(topLeftX(), topLeftY(), width(), height());
        } else {
            g.drawRect(topLeftX(), topLeftY(), width(), height());
        }
    }
}
