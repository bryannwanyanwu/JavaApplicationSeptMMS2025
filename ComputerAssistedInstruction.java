import java.security.SecureRandom;
import java.util.Scanner;

// Combines Exercises 5.35 (basic CAI), 5.36 (varied responses),
// 5.37 (performance monitoring), 5.38 (difficulty levels),
// and 5.39 (problem type selection).
public class ComputerAssistedInstruction {
    private static final SecureRandom random = new SecureRandom();
    private static final Scanner input = new Scanner(System.in);

    private static int operand1;
    private static int operand2;
    private static char operation;

    // Exercise 5.35 + 5.38 + 5.39: generate a new question
    // based on difficulty level and problem type.
    public static void generateQuestion(int difficultyLevel, int problemType) {
        int maxValue = (int) Math.pow(10, difficultyLevel) - 1;
        int minValue = difficultyLevel == 1 ? 0 : (int) Math.pow(10, difficultyLevel - 1);

        operand1 = minValue + random.nextInt(maxValue - minValue + 1);
        operand2 = minValue + random.nextInt(maxValue - minValue + 1);

        int actualType = problemType;
        if (problemType == 5) {
            actualType = 1 + random.nextInt(4); // random mixture
        }

        switch (actualType) {
            case 1:
                operation = '+';
                break;
            case 2:
                operation = '-';
                // Ensure no negative results for subtraction
                if (operand2 > operand1) {
                    int temp = operand1;
                    operand1 = operand2;
                    operand2 = temp;
                }
                break;
            case 3:
                operation = '*';
                break;
            case 4:
                operation = '/';
                // Ensure evenly divisible, no divide by zero
                if (operand2 == 0) {
                    operand2 = 1;
                }
                operand1 = operand2 * (1 + random.nextInt(10));
                break;
        }
    }

    public static int correctAnswer() {
        switch (operation) {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            case '/': return operand1 / operand2;
            default: return 0;
        }
    }

    // Exercise 5.36: varied responses to reduce student fatigue
    public static String correctResponse() {
        int choice = 1 + random.nextInt(4);
        switch (choice) {
            case 1: return "Very good!";
            case 2: return "Excellent!";
            case 3: return "Nice work!";
            default: return "Keep up the good work!";
        }
    }

    public static String incorrectResponse() {
        int choice = 1 + random.nextInt(4);
        switch (choice) {
            case 1: return "No. Please try again.";
            case 2: return "Wrong. Try once more.";
            case 3: return "Don't give up! No.";
            default: return "Keep trying.";
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter difficulty level (1 = single digit, 2 = two digit, etc.): ");
        int difficultyLevel = input.nextInt();

        System.out.println("Choose problem type:");
        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Random mixture");
        System.out.print("Your choice: ");
        int problemType = input.nextInt();

        int correctCount = 0;
        int incorrectCount = 0;
        int totalAnswered = 0;

        while (true) {
            generateQuestion(difficultyLevel, problemType);
            System.out.println("How much is " + operand1 + " " + operation + " " + operand2 + "?");

            int studentAnswer = input.nextInt();
            int correct = correctAnswer();

            while (studentAnswer != correct) {
                System.out.println(incorrectResponse());
                incorrectCount++;
                totalAnswered++;

                // Exercise 5.37: check performance every 10 answers
                if (totalAnswered % 10 == 0) {
                    checkPerformance(correctCount, incorrectCount);
                    correctCount = 0;
                    incorrectCount = 0;
                }

                studentAnswer = input.nextInt();
            }

            System.out.println(correctResponse());
            correctCount++;
            totalAnswered++;

            if (totalAnswered % 10 == 0) {
                checkPerformance(correctCount, incorrectCount);
                correctCount = 0;
                incorrectCount = 0;
            }
        }
    }

    // Exercise 5.37: monitor performance after every 10 answers
    public static void checkPerformance(int correctCount, int incorrectCount) {
        int total = correctCount + incorrectCount;
        double percentage = (double) correctCount / total * 100;

        System.out.printf("%nPerformance check: %.1f%% correct over last %d answers.%n", percentage, total);

        if (percentage < 75) {
            System.out.println("Please ask your teacher for extra help.");
        } else {
            System.out.println("Congratulations, you are ready to go to the next level!");
        }
        System.out.println("(Resetting for next student...)\n");
    }
}
