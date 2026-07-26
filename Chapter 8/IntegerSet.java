public class IntegerSet {
    private boolean[] set;
    
    // No-argument constructor - empty set
    public IntegerSet() {
        set = new boolean[101]; // indices 0-100
        // All values default to false
    }
    
    // Union of two sets
    public static IntegerSet union(IntegerSet set1, IntegerSet set2) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < 101; i++) {
            result.set[i] = set1.set[i] || set2.set[i];
        }
        return result;
    }
    
    // Intersection of two sets
    public static IntegerSet intersection(IntegerSet set1, IntegerSet set2) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < 101; i++) {
            result.set[i] = set1.set[i] && set2.set[i];
        }
        return result;
    }
    
    // Insert element
    public void insertElement(int k) {
        if (k >= 0 && k <= 100) {
            set[k] = true;
        }
    }
    
    // Delete element
    public void deleteElement(int m) {
        if (m >= 0 && m <= 100) {
            set[m] = false;
        }
    }
    
    // Check if sets are equal
    public boolean isEqualTo(IntegerSet other) {
        for (int i = 0; i < 101; i++) {
            if (set[i] != other.set[i]) {
                return false;
            }
        }
        return true;
    }
    
    // toString
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean empty = true;
        
        for (int i = 0; i < 101; i++) {
            if (set[i]) {
                result.append(i).append(" ");
                empty = false;
            }
        }
        
        return empty ? "---" : result.toString().trim();
    }
}

// Test program
public class IntegerSetTest {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        
        // Insert elements into set1
        for (int i = 1; i <= 5; i++) {
            set1.insertElement(i);
        }
        set1.insertElement(10);
        set1.insertElement(20);
        
        // Insert elements into set2
        for (int i = 5; i <= 15; i++) {
            set2.insertElement(i);
        }
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + IntegerSet.union(set1, set2));
        System.out.println("Intersection: " + IntegerSet.intersection(set1, set2));
        System.out.println("Are sets equal? " + set1.isEqualTo(set2));
        
        set1.deleteElement(5);
        System.out.println("\nSet 1 after deleting 5: " + set1);
        System.out.println("Are sets equal now? " + set1.isEqualTo(set2));
    }
}