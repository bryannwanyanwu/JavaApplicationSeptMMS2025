// Square.java
// Square extends Rectangle -- all four sides are equal length.
// Exercise 9.8
public class Square extends Rectangle {
   public Square(Point point1, Point point2, Point point3, Point point4) {
      super(point1, point2, point3, point4);
   }

   // convenience constructor: bottom-left corner and side length
   public Square(Point bottomLeft, double side) {
      super(bottomLeft, side, side);
   }

   @Override
   public String toString() {
      return String.format("Square: %s", super.toString());
   }
}
