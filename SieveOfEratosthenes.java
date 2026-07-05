public class SieveOfEratosthenes {
    public static void main(String[] args) {
        boolean[] isPrime = new boolean[1000];
        
        // Initialize all to true
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        
        // Sieve algorithm
        for (int i = 2; i < 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Display prime numbers
        System.out.println("Prime numbers between 2 and 999:");
        int count = 0;
        for (int i = 2; i < 1000; i++) {
            if (isPrime[i]) {
                System.out.printf("%5d", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.printf("%nTotal primes: %d%n", count);
    }
}