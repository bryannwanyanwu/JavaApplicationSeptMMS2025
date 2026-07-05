import java.util.Scanner;

public class TurtleGraphics {
    private static final int SIZE = 20;
    private static int[][] floor = new int[SIZE][SIZE];
    private static int turtleX = 0;
    private static int turtleY = 0;
    private static boolean penUp = true;
    private static int direction = 0; // 0: right, 1: down, 2: left, 3: up
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter turtle commands (0 to exit):");
        System.out.println("1 - Pen up, 2 - Pen down, 3 - Turn right");
        System.out.println("4 - Turn left, 5, n - Move forward n spaces");
        System.out.println("6 - Display array, 9 - End data");
        
        while (true) {
            System.out.print("Command: ");
            int command = input.nextInt();
            
            if (command == 0) break;
            
            switch (command) {
                case 1:
                    penUp = true;
                    break;
                case 2:
                    penUp = false;
                    break;
                case 3:
                    direction = (direction + 1) % 4;
                    break;
                case 4:
                    direction = (direction - 1 + 4) % 4;
                    break;
                case 5:
                    System.out.print("Number of spaces: ");
                    int spaces = input.nextInt();
                    move(spaces);
                    break;
                case 6:
                    displayArray();
                    break;
                case 9:
                    System.out.println("End of commands.");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
        input.close();
    }
    
    private static void move(int spaces) {
        for (int i = 0; i < spaces; i++) {
            int newX = turtleX;
            int newY = turtleY;
            
            switch (direction) {
                case 0: newY++; break; // right
                case 1: newX++; break; // down
                case 2: newY--; break; // left
                case 3: newX--; break; // up
            }
            
            // Check boundaries
            if (newX < 0 || newX >= SIZE || newY < 0 || newY >= SIZE) {
                break;
            }
            
            turtleX = newX;
            turtleY = newY;
            
            if (!penUp) {
                floor[turtleX][turtleY] = 1;
            }
        }
    }
    
    private static void displayArray() {
        System.out.println("Turtle Graphics Display:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(floor[i][j] == 1 ? "*" : " ");
            }
            System.out.println();
        }
        System.out.println("Turtle at position (" + turtleX + ", " + turtleY + ")");
    }
}