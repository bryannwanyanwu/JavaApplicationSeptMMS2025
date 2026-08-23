// Exercise 13.31: DrawPanel updated to support Java 2D Paint (gradients) and Stroke
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    public static final int LINE = 0;
    public static final int RECTANGLE = 1;
    public static final int OVAL = 2;

    private MyShape[] shapes;
    private int shapeCount;
    private int shapeType;
    private MyShape currentShape;
    private Paint currentPaint;
    private boolean filledShape;
    private Stroke currentStroke;
    private JLabel statusLabel;

    public DrawPanel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
        shapes = new MyShape[100];
        shapeCount = 0;
        shapeType = LINE;
        currentShape = null;
        currentPaint = Color.BLACK;
        filledShape = false;
        currentStroke = new BasicStroke(1);

        setBackground(Color.WHITE);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void setShapeType(int shapeType) { this.shapeType = shapeType; }
    public void setCurrentPaint(Paint paint) { this.currentPaint = paint; }
    public void setFilledShape(boolean filled) { this.filledShape = filled; }
    public void setCurrentStroke(Stroke stroke) { this.currentStroke = stroke; }

    public void clearLastShape() {
        if (shapeCount > 0) {
            shapeCount--;
        }
        repaint();
    }

    public void clearDrawing() {
        shapeCount = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g2d);
        }

        if (currentShape != null) {
            currentShape.draw(g2d);
        }
    }

    private MyShape createShape(int x1, int y1, int x2, int y2) {
        switch (shapeType) {
            case RECTANGLE:
                return new MyRectangle(x1, y1, x2, y2, currentPaint, filledShape, currentStroke);
            case OVAL:
                return new MyOval(x1, y1, x2, y2, currentPaint, filledShape, currentStroke);
            default:
                return new MyLine(x1, y1, x2, y2, currentPaint, filledShape, currentStroke);
        }
    }

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent event) {
            currentShape = createShape(event.getX(), event.getY(), event.getX(), event.getY());
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            if (currentShape != null) {
                currentShape.setPoint2(event.getX(), event.getY());

                if (shapeCount < shapes.length) {
                    shapes[shapeCount] = currentShape;
                    shapeCount++;
                }

                currentShape = null;
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent event) {
            statusLabel.setText(String.format("x: %d, y: %d", event.getX(), event.getY()));
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            if (currentShape != null) {
                currentShape.setPoint2(event.getX(), event.getY());
                repaint();
            }
            statusLabel.setText(String.format("x: %d, y: %d", event.getX(), event.getY()));
        }
    }
}
