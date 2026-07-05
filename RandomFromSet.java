import java.util.Random;

public class RandomFromSet {
    public static void main(String[] args) {
        Random random = new Random();

        int a = 2 + 2 * random.nextInt(5);   // 2,4,6,8,10
        int b = 3 + 2 * random.nextInt(5);   // 3,5,7,9,11
        int c = 6 + 4 * random.nextInt(5);   // 6,10,14,18,22

        System.out.println("a) " + a);
        System.out.println("b) " + b);
        System.out.println("c) " + c);
    }
}
