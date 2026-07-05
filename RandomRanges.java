import java.util.Random;

public class RandomRanges {
    public static void main(String[] args) {
        Random random = new Random();

        int a = 1 + random.nextInt(2);           // a) 1 <= n <= 2
        int b = 1 + random.nextInt(100);         // b) 1 <= n <= 100
        int c = random.nextInt(10);              // c) 0 <= n <= 9
        int d = 1000 + random.nextInt(113);      // d) 1000 <= n <= 1112
        int e = -1 + random.nextInt(3);          // e) -1 <= n <= 1
        int f = -3 + random.nextInt(15);         // f) -3 <= n <= 11

        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
        System.out.println("d) " + d);
        System.out.println("e) " + e);
        System.out.println("f) " + f);
    }
}
