import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class MyLine extends MyShape {
    public MyLine(int x1, int y1, int x2, int y2, Paint paint, boolean filled, Stroke stroke) {
        super(x1, y1, x2, y2, paint, filled, stroke);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(paint);
        g2d.setStroke(stroke);
        g2d.drawLine(x1, y1, x2, y2);
    }
}
