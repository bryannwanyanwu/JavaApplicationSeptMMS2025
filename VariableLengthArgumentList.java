public class VariableLengthArgumentList {
    public static int product(int... numbers) {
        int result = 1;
        for (int num : numbers) {
            result *= num;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Product of 2, 3: " + product(2, 3));
        System.out.println("Product of 2, 3, 4: " + product(2, 3, 4));
        System.out.println("Product of 1, 2, 3, 4, 5: " + product(1, 2, 3, 4, 5));
        System.out.println("Product of 5, 10: " + product(5, 10));
        System.out.println("Product of 2, 3, 4, 5, 6, 7: " + product(2, 3, 4, 5, 6, 7));
    }
}