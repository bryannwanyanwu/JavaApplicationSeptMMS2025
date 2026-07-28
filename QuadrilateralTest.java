// QuadrilateralTest.java
// Testing the Quadrilateral hierarchy -- Exercise 9.8
public class QuadrilateralTest {
   public static void main(String[] args) {
      // a generic (non-parallel-sided) quadrilateral: prints only shape info
      Quadrilateral quadrilateral = new Quadrilateral(
         new Point(0, 0), new Point(4, 0), new Point(5, 3), new Point(1, 4));
      System.out.println(quadrilateral);
      System.out.printf("perimeter: %.2f%n%n", quadrilateral.perimeter());

      // trapezoid with parallel top/bottom sides
      Trapezoid trapezoid = new Trapezoid(
         new Point(0, 0), new Point(6, 0), new Point(4, 3), new Point(2, 3));
      System.out.println(trapezoid);
      System.out.printf("area: %.2f%n%n", trapezoid.area());

      // parallelogram
      Parallelogram parallelogram = new Parallelogram(
         new Point(0, 0), new Point(5, 0), new Point(7, 3), new Point(2, 3));
      System.out.println(parallelogram);
      System.out.printf("area: %.2f%n%n", parallelogram.area());

      // rectangle via four points
      Rectangle rectangle = new Rectangle(
         new Point(0, 0), new Point(6, 0), new Point(6, 3), new Point(0, 3));
      System.out.println(rectangle);
      System.out.printf("area: %.2f%n%n", rectangle.area());

      // rectangle via convenience constructor (bottom-left, width, height)
      Rectangle rectangle2 = new Rectangle(new Point(0, 0), 8, 4);
      System.out.println(rectangle2);
      System.out.printf("area: %.2f%n%n", rectangle2.area());

      // square via convenience constructor (bottom-left, side)
      Square square = new Square(new Point(0, 0), 5);
      System.out.println(square);
      System.out.printf("area: %.2f%n", square.area());
   }
}
