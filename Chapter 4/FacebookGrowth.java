public class FacebookGrowth {
    public static void main(String[] args) {
        double users = 1_000_000_000.0;
        double monthlyRate = 1.04;
        int months = 0;
        boolean hit15 = false;

        while (users < 2_000_000_000.0) {
            users *= monthlyRate;
            months++;
            if (!hit15 && users >= 1_500_000_000.0) {
                System.out.println("Reached 1.5 billion users after " + months + " months.");
                hit15 = true;
            }
        }
        System.out.println("Reached 2 billion users after " + months + " months.");
    }
}