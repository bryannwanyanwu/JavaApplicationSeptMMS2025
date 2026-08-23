// Exercise 13.31: MyShape updated for Java 2D (Paint + Stroke support)
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyShape {
    protected int x1, y1, x2, y2;
    protected Paint paint;
    protected boolean filled;
    protected Stroke stroke;

    public MyShape(int x1, int y1, int x2, int y2, Paint paint, boolean filled, Stroke stroke) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.paint = paint;
        this.filled = filled;
        this.stroke = stroke;
    }

    public void setPoint2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public abstract void draw(Graphics2D g2d);

    protected int topLeftX() { return Math.min(x1, x2); }
    protected int topLeftY() { return Math.min(y1, y2); }
    protected int width()    { return Math.abs(x2 - x1); }
    protected int height()   { return Math.abs(y2 - y1); }
}
