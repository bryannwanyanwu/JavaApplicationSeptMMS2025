public class NumberChallenge {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Sum of 1st, 5th, and 10th numbers
        int sumA = numbers[0] + numbers[4] + numbers[9];  // 1 + 5 + 10 = 16

        // Sum of 3rd, 8th, and 2nd numbers
        int sumB = numbers[2] + numbers[7] + numbers[1];  // 3 + 8 + 2 = 13

        // Multiply sumA by sumB
        int product = sumA * sumB;                        // 16 * 13 = 208

        // Sum of 4th, 7th, 6th, and 9th numbers
        int sumC = numbers[3] + numbers[6] + numbers[5] + numbers[8]; // 4 + 7 + 6 + 9 = 26

        // Subtract product from sumC
        int result = sumC - product;                      // 26 - 208 = -182

        // Check if result >= 100
        if (result >= 100) {
            System.out.println("hurray I did it");
        } else {
            System.out.println("I still need to learn more in Java");
        }
    }
}