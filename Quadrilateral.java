// Quadrilateral.java
// Quadrilateral superclass -- Exercise 9.8
// Stores the four corner points of a quadrilateral, in order
// (either clockwise or counterclockwise) around the shape.
public class Quadrilateral {
   private final Point point1;
   private final Point point2;
   private final Point point3;
   private final Point point4;

   public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
      this.point1 = point1;
      this.point2 = point2;
      this.point3 = point3;
      this.point4 = point4;
   }

   public Point getPoint1() {
      return point1;
   }

   public Point getPoint2() {
      return point2;
   }

   public Point getPoint3() {
      return point3;
   }

   public Point getPoint4() {
      return point4;
   }

   // perimeter -- sum of the four side lengths
   public double perimeter() {
      return point1.distance(point2) + point2.distance(point3)
         + point3.distance(point4) + point4.distance(point1);
   }

   // Shoelace (surveyor's) formula -- works for any simple (non
   // self-intersecting) quadrilateral given its points in order.
   // Subclasses expose this as their public area() method; Quadrilateral
   // itself does not, since a general quadrilateral's "area" is only
   // meaningful once we know it's a valid simple polygon -- the specific
   // subclasses (Trapezoid, Parallelogram, Rectangle, Square) are the ones
   // that should report an area.
   protected double calculateArea() {
      double sum1 = point1.getX() * point2.getY() + point2.getX() * point3.getY()
         + point3.getX() * point4.getY() + point4.getX() * point1.getY();
      double sum2 = point1.getY() * point2.getX() + point2.getY() * point3.getX()
         + point3.getY() * point4.getX() + point4.getY() * point1.getX();
      return Math.abs(sum1 - sum2) / 2.0;
   }

   @Override
   public String toString() {
      return String.format("Quadrilateral: %s, %s, %s, %s",
         point1, point2, point3, point4);
   }
}
