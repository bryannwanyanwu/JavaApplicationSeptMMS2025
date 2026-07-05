import java.util.Scanner;

public class AirlineReservations {
    private static boolean[] seats = new boolean[10];
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        boolean flightFull = false;
        
        while (!flightFull) {
            System.out.println("\nPlease type 1 for First Class");
            System.out.println("Please type 2 for Economy");
            System.out.print("Choice: ");
            choice = input.nextInt();
            
            if (choice == 1) {
                if (assignSeat(1, 0, 4)) {
                    System.out.println("First Class seat assigned.");
                } else if (!flightFull) {
                    // First class full, offer economy
                    System.out.println("First Class is full.");
                    System.out.println("Is it acceptable to be placed in Economy? (1 for yes, 0 for no)");
                    if (input.nextInt() == 1) {
                        if (!assignSeat(2, 5, 9)) {
                            flightFull = true;
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            } else if (choice == 2) {
                if (assignSeat(2, 5, 9)) {
                    System.out.println("Economy seat assigned.");
                } else if (!flightFull) {
                    // Economy full, offer first class
                    System.out.println("Economy is full.");
                    System.out.println("Is it acceptable to be placed in First Class? (1 for yes, 0 for no)");
                    if (input.nextInt() == 1) {
                        if (!assignSeat(1, 0, 4)) {
                            flightFull = true;
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            }
            
            // Check if flight is full
            flightFull = true;
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) {
                    flightFull = false;
                    break;
                }
            }
        }
        System.out.println("Flight is full. Next flight leaves in 3 hours.");
        input.close();
    }
    
    private static boolean assignSeat(int section, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                String sectionName = (section == 1) ? "First Class" : "Economy";
                System.out.printf("Boarding pass: Seat %d in %s%n", i + 1, sectionName);
                return true;
            }
        }
        return false;
    }
}