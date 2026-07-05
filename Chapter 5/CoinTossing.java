import java.util.Random;
import java.util.Scanner;

public class CoinTossing {
    public enum Coin { HEADS, TAILS }

    private static final Random random = new Random();

    public static Coin flip() {
        return random.nextBoolean() ? Coin.HEADS : Coin.TAILS;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int headsCount = 0;
        int tailsCount = 0;
        int choice;

        do {
            System.out.println("1. Toss Coin");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            if (choice == 1) {
                Coin result = flip();
                System.out.println("Result: " + result);
                if (result == Coin.HEADS) {
                    headsCount++;
                } else {
                    tailsCount++;
                }
            }
        } while (choice != 2);

        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        input.close();
    }
}
