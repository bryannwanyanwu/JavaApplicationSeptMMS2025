public class HugeInteger {
    private static final int MAX_DIGITS = 40;
    private int[] digits;
    
    // Constructor
    public HugeInteger() {
        digits = new int[MAX_DIGITS];
    }
    
    // Parse string into HugeInteger
    public void parse(String number) {
        if (number.length() > MAX_DIGITS) {
            throw new IllegalArgumentException("Number too large (max 40 digits)");
        }
        
        digits = new int[MAX_DIGITS];
        int len = number.length();
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid digit: " + c);
            }
            digits[MAX_DIGITS - len + i] = c - '0';
        }
    }
    
    // Add two HugeIntegers
    public static HugeInteger add(HugeInteger h1, HugeInteger h2) {
        HugeInteger result = new HugeInteger();
        int carry = 0;
        
        for (int i = MAX_DIGITS - 1; i >= 0; i--) {
            int sum = h1.digits[i] + h2.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry > 0) {
            throw new IllegalArgumentException("Overflow - result too large");
        }
        
        return result;
    }
    
    // Subtract two HugeIntegers (assumes h1 >= h2)
    public static HugeInteger subtract(HugeInteger h1, HugeInteger h2) {
        HugeInteger result = new HugeInteger();
        int borrow = 0;
        
        for (int i = MAX_DIGITS - 1; i >= 0; i--) {
            int diff = h1.digits[i] - h2.digits[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.digits[i] = diff;
        }
        
        if (borrow > 0) {
            throw new IllegalArgumentException("Negative result - cannot subtract");
        }
        
        return result;
    }
    
    // Comparison methods
    public boolean isEqualTo(HugeInteger other) {
        for (int i = 0; i < MAX_DIGITS; i++) {
            if (digits[i] != other.digits[i]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }
    
    public boolean isGreaterThan(HugeInteger other) {
        for (int i = 0; i < MAX_DIGITS; i++) {
            if (digits[i] > other.digits[i]) {
                return true;
            } else if (digits[i] < other.digits[i]) {
                return false;
            }
        }
        return false; // Equal
    }
    
    public boolean isLessThan(HugeInteger other) {
        return other.isGreaterThan(this);
    }
    
    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return isGreaterThan(other) || isEqualTo(other);
    }
    
    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return isLessThan(other) || isEqualTo(other);
    }
    
    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        
        for (int digit : digits) {
            if (digit != 0) {
                leadingZero = false;
                sb.append(digit);
            } else if (!leadingZero) {
                sb.append(digit);
            }
        }
        
        return leadingZero ? "0" : sb.toString();
    }
}

// Test program
public class HugeIntegerTest {
    public static void main(String[] args) {
        HugeInteger h1 = new HugeInteger();
        HugeInteger h2 = new HugeInteger();
        
        h1.parse("12345678901234567890");
        h2.parse("98765432109876543210");
        
        System.out.println("h1 = " + h1);
        System.out.println("h2 = " + h2);
        
        System.out.println("h1 + h2 = " + HugeInteger.add(h1, h2));
        System.out.println("h2 - h1 = " + HugeInteger.subtract(h2, h1));
        
        System.out.println("\nComparisons:");
        System.out.println("h1 == h2? " + h1.isEqualTo(h2));
        System.out.println("h1 != h2? " + h1.isNotEqualTo(h2));
        System.out.println("h1 > h2? " + h1.isGreaterThan(h2));
        System.out.println("h1 < h2? " + h1.isLessThan(h2));
        System.out.println("h1 >= h2? " + h1.isGreaterThanOrEqualTo(h2));
        System.out.println("h1 <= h2? " + h1.isLessThanOrEqualTo(h2));
        System.out.println("h1 is zero? " + h1.isZero());
    }
}