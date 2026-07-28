// Point.java
// Point class represents an x-y coordinate pair -- Exercise 9.8
public class Point {
   private double x;
   private double y;

   public Point() {
      this(0.0, 0.0);
   }

   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getX() {
      return x;
   }

   public void setY(double y) {
      this.y = y;
   }

   public double getY() {
      return y;
   }

   // distance from this point to another point
   public double distance(Point other) {
      double dx = this.x - other.x;
      double dy = this.y - other.y;
      return Math.sqrt(dx * dx + dy * dy);
   }

   @Override
   public String toString() {
      return String.format("(%.1f, %.1f)", x, y);
   }
}


