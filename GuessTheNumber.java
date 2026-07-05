import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int numberToGuess = 1 + random.nextInt(1000);
            int guess;

            System.out.println("I have a number between 1 and 1000.");
            System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();

            while (guess != numberToGuess) {
                if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Too low. Try again.");
                }
                System.out.print("Enter your next guess: ");
                guess = input.nextInt();
            }

            System.out.println("Congratulations. You guessed the number!");
            System.out.print("Play again? (y/n): ");
            playAgain = input.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        input.close();
    }
}
