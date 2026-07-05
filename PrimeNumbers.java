public class PrimeNumbers {
    // Part (a) and (c): efficient version testing only up to sqrt(n)
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        System.out.println("Prime numbers less than 10000:");
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nTotal primes found: " + count);
    }
}
