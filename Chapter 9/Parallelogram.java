// Parallelogram.java
// Parallelogram extends Trapezoid -- both pairs of opposite sides are
// parallel (a parallelogram is a special case of a trapezoid).
// Exercise 9.8
public class Parallelogram extends Trapezoid {
   public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
      super(point1, point2, point3, point4);
   }

   @Override
   public String toString() {
      return String.format("Parallelogram: %s", super.toString());
   }
}
