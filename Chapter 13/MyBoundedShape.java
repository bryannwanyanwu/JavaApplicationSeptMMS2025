import java.awt.Paint;
import java.awt.Stroke;

public abstract class MyBoundedShape extends MyShape {
    public MyBoundedShape(int x1, int y1, int x2, int y2, Paint paint, boolean filled, Stroke stroke) {
        super(x1, y1, x2, y2, paint, filled, stroke);
    }
}
