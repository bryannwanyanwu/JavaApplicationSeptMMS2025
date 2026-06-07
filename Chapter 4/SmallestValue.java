import java.util.Scanner;

public class SmallestValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int count = sc.nextInt();
        System.out.print("Enter first number: ");
        int smallest = sc.nextInt();

        for (int i = 2; i <= count; i++) {
            System.out.print("Enter next number: ");
            int n = sc.nextInt();
            if (n < smallest)
                smallest = n;
        }
        System.out.println("Smallest: " + smallest);
    }
}