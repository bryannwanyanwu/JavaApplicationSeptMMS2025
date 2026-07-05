public class ArraySizeCommandLine {
    public static void main(String[] args) {
        int size = 10; // default size
        
        if (args.length > 0) {
            try {
                size = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument. Using default size of 10.");
            }
        }
        
        int[] array = new int[size];
        
        System.out.println("Array of size " + size + " created.");
        
        // Display array elements (initialized to 0)
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] = %d%n", i, array[i]);
        }
    }
}