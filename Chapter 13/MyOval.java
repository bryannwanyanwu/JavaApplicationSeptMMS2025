import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyOval extends MyBoundedShape {
    public MyOval(int x1, int y1, int x2, int y2, Paint paint, boolean filled, Stroke stroke) {
        super(x1, y1, x2, y2, paint, filled, stroke);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(paint);
        g2d.setStroke(stroke);
        if (filled) {
            g2d.fillOval(topLeftX(), topLeftY(), width(), height());
        } else {
            g2d.drawOval(topLeftX(), topLeftY(), width(), height());
        }
    }
}
