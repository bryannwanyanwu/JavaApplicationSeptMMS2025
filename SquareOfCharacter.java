import java.util.Scanner;

public class SquareOfCharacter {
    public static void squareOfCharacter(int side, char fillCharacter) {
        for (int row = 0; row < side; row++) {
            for (int col = 0; col < side; col++) {
                System.out.print(fillCharacter);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side length: ");
        int side = input.nextInt();
        System.out.print("Enter fill character: ");
        char fill = input.next().charAt(0);

        squareOfCharacter(side, fill);
        input.close();
    }
}
