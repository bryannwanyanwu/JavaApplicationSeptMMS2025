// Minimal MyShape hierarchy (stand-in for GUI and Graphics Case Study Exercise 10.2)
// Each shape stores two points that define its bounding box and knows how to
// draw itself, filled or unfilled, in a given color.
import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape {
    protected int x1, y1, x2, y2;
    protected Color color;
    protected boolean filled;

    public MyShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.filled = filled;
    }

    // Update the "live" second point while the user drags the mouse
    public void setPoint2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public abstract void draw(Graphics g);

    protected int topLeftX() { return Math.min(x1, x2); }
    protected int topLeftY() { return Math.min(y1, y2); }
    protected int width()    { return Math.abs(x2 - x1); }
    protected int height()   { return Math.abs(y2 - y1); }
}
