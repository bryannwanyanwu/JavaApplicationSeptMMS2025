import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static final Random random = new Random();

    public static int rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);
        return die1 + die2;
    }

    // Plays one game of craps and returns true if the player wins.
    public static boolean playCraps() {
        int sumOfDice = rollDice();
        int myPoint;

        switch (sumOfDice) {
            case 7:
            case 11:
                return true; // win on first roll
            case 2:
            case 3:
            case 12:
                return false; // lose on first roll
            default:
                myPoint = sumOfDice;
                System.out.println("Point is " + myPoint);
                break;
        }

        while (true) {
            sumOfDice = rollDice();
            if (sumOfDice == myPoint) {
                return true;
            } else if (sumOfDice == 7) {
                return false;
            }
        }
    }

    public static String randomChatter(double bankBalance, double wager) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "Oh, you're going for broke, huh?";
            case 1:
                return "Aw c'mon, take a chance!";
            default:
                return "You're up big. Now's the time to cash in your chips!";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double bankBalance = 1000.0;

        while (bankBalance > 0) {
            System.out.println("Current bank balance: $" + bankBalance);
            System.out.println(randomChatter(bankBalance, 0));
            System.out.print("Enter your wager: ");
            double wager = input.nextDouble();

            while (wager > bankBalance) {
                System.out.print("Wager exceeds bank balance. Enter a valid wager: ");
                wager = input.nextDouble();
            }

            boolean won = playCraps();

            if (won) {
                bankBalance += wager;
                System.out.println("You won! New bank balance: $" + bankBalance);
            } else {
                bankBalance -= wager;
                System.out.println("You lost. New bank balance: $" + bankBalance);
                if (bankBalance == 0) {
                    System.out.println("Sorry. You busted!");
                    break;
                }
            }

            System.out.print("Play again? (y/n): ");
            char again = input.next().charAt(0);
            if (again != 'y' && again != 'Y') {
                break;
            }
        }

        input.close();
    }
}
