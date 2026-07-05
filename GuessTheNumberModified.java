import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberModified {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        do {
            int numberToGuess = 1 + random.nextInt(1000);
            int guess;
            int guessCount = 0;

            System.out.println("I have a number between 1 and 1000.");
            System.out.print("Guess a number between 1 and 1000: ");
            guess = input.nextInt();
            guessCount++;

            while (guess != numberToGuess) {
                if (guess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                } else {
                    System.out.println("Too low. Try again.");
                }
                System.out.print("Enter your next guess: ");
                guess = input.nextInt();
                guessCount++;
            }

            System.out.println("Congratulations. You guessed the number!");
            System.out.println("Number of guesses: " + guessCount);

            if (guessCount == 10) {
                System.out.println("Aha! You know the secret!");
            } else if (guessCount < 10) {
                System.out.println("Either you know the secret or you got lucky!");
            } else {
                System.out.println("You should be able to do better!");
            }

            System.out.print("Play again? (y/n): ");
            playAgain = input.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        input.close();
    }
}
