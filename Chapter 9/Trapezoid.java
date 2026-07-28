// Trapezoid.java
// Trapezoid extends Quadrilateral -- has exactly one pair of parallel sides.
// Exercise 9.8
public class Trapezoid extends Quadrilateral {
   public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
      super(point1, point2, point3, point4);
   }

   // area of a trapezoid (works for any simple quadrilateral via
   // the shoelace formula inherited from Quadrilateral)
   public double area() {
      return calculateArea();
   }

   @Override
   public String toString() {
      return String.format("Trapezoid: %s", super.toString());
   }
}
