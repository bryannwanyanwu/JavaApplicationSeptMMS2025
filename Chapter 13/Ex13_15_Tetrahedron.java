import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Ex13_15_Tetrahedron extends JFrame {
    public Ex13_15_Tetrahedron() {
        super("Tetrahedron");
        add(new TetrahedronPanel());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private static class TetrahedronPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Base triangle points and apex point (simple 2D projection of a tetrahedron)
            Point base1 = new Point(80, 280);
            Point base2 = new Point(300, 280);
            Point base3 = new Point(190, 200); // "back" base vertex, drawn higher/behind
            Point apex = new Point(190, 60);

            GeneralPath path = new GeneralPath();

            // Front face: base1 - base2 - apex
            path.moveTo(base1.x, base1.y);
            path.lineTo(base2.x, base2.y);
            path.lineTo(apex.x, apex.y);
            path.closePath();

            // Left face: base1 - base3 - apex
            path.moveTo(base1.x, base1.y);
            path.lineTo(base3.x, base3.y);
            path.lineTo(apex.x, apex.y);

            // Right face: base2 - base3 - apex
            path.moveTo(base2.x, base2.y);
            path.lineTo(base3.x, base3.y);
            path.lineTo(apex.x, apex.y);

            // Back base edge (dashed to suggest hidden edge)
            path.moveTo(base1.x, base1.y);
            path.lineTo(base3.x, base3.y);
            path.moveTo(base2.x, base2.y);
            path.lineTo(base3.x, base3.y);

            g2d.setStroke(new BasicStroke(2));
            g2d.draw(path);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ex13_15_Tetrahedron().setVisible(true));
    }
}
