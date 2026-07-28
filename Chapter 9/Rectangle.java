// Rectangle.java
// Rectangle extends Parallelogram -- all four angles are 90 degrees.
// Exercise 9.8
public class Rectangle extends Parallelogram {
   public Rectangle(Point point1, Point point2, Point point3, Point point4) {
      super(point1, point2, point3, point4);
   }

   // convenience constructor: bottom-left corner, width and height
   public Rectangle(Point bottomLeft, double width, double height) {
      this(bottomLeft,
         new Point(bottomLeft.getX() + width, bottomLeft.getY()),
         new Point(bottomLeft.getX() + width, bottomLeft.getY() + height),
         new Point(bottomLeft.getX(), bottomLeft.getY() + height));
   }

   @Override
   public String toString() {
      return String.format("Rectangle: %s", super.toString());
   }
}
