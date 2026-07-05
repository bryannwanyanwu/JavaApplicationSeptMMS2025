import java.util.Scanner;

public class EvenOrOdd {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of integers to test (0 to stop): ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            int num = input.nextInt();
            System.out.println(num + " is " + (isEven(num) ? "even" : "odd"));
        }
        input.close();
    }
}
