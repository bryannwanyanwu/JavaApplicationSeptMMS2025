import java.security.SecureRandom;

public class TortoiseAndHare {
    private static final int RACE_LENGTH = 70;
    private static SecureRandom random = new SecureRandom();
    
    public static void main(String[] args) throws InterruptedException {
        int tortoisePos = 1;
        int harePos = 1;
        int clockTick = 0;
        
        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");
        
        while (tortoisePos < RACE_LENGTH && harePos < RACE_LENGTH) {
            tortoisePos = moveTortoise(tortoisePos);
            harePos = moveHare(harePos);
            clockTick++;
            
            displayRace(tortoisePos, harePos);
            Thread.sleep(100); // Slow down for viewing
            
            if (tortoisePos >= RACE_LENGTH && harePos >= RACE_LENGTH) {
                System.out.println("It's a tie!");
                break;
            } else if (tortoisePos >= RACE_LENGTH) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                break;
            } else if (harePos >= RACE_LENGTH) {
                System.out.println("Hare wins. Yuch.");
                break;
            }
        }
    }
    
    private static int moveTortoise(int position) {
        int move = random.nextInt(10) + 1;
        
        if (move <= 5) {
            position += 3; // Fast plod
        } else if (move <= 7) {
            position -= 6; // Slip
        } else {
            position += 1; // Slow plod
        }
        
        if (position < 1) position = 1;
        return position;
    }
    
    private static int moveHare(int position) {
        int move = random.nextInt(10) + 1;
        
        if (move <= 2) {
            // Sleep - no movement
        } else if (move <= 4) {
            position += 9; // Big hop
        } else if (move == 5) {
            position -= 12; // Big slip
        } else if (move <= 8) {
            position += 1; // Small hop
        } else {
            position -= 2; // Small slip
        }
        
        if (position < 1) position = 1;
        return position;
    }
    
    private static void displayRace(int tortoisePos, int harePos) {
        for (int i = 1; i <= RACE_LENGTH; i++) {
            if (i == tortoisePos && i == harePos) {
                System.out.print("OUCH!!!");
                i += 6;
            } else if (i == tortoisePos) {
                System.out.print("T");
            } else if (i == harePos) {
                System.out.print("H");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}