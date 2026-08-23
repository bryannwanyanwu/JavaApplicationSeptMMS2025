// ============================================================
// FILE: AllExercises.java
// ============================================================
// Contains ALL solutions for Exercises 14.3 - 14.28
// Copy this entire code into a file called AllExercises.java
// Compile: javac AllExercises.java
// Run: java AllExercises
// ============================================================

import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AllExercises {
    
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("  JAVA STRING EXERCISES - COMPLETE SOLUTIONS");
            System.out.println("  Exercises 14.3 through 14.28");
            System.out.println("=".repeat(60));
            System.out.println(" 1  - Exercise 14.3  - Compare Strings");
            System.out.println(" 2  - Exercise 14.4  - Compare Portions");
            System.out.println(" 3  - Exercise 14.5  - Random Sentences");
            System.out.println(" 4  - Exercise 14.6  - Limericks");
            System.out.println(" 5  - Exercise 14.7  - Pig Latin");
            System.out.println(" 6  - Exercise 14.8  - Tokenizing Telephone");
            System.out.println(" 7  - Exercise 14.9  - Reverse Words");
            System.out.println(" 8  - Exercise 14.10 - Upper/Lowercase");
            System.out.println(" 9  - Exercise 14.11 - Count Character");
            System.out.println(" 10 - Exercise 14.12 - Letter Frequency");
            System.out.println(" 11 - Exercise 14.13 - Words Starting with 'b'");
            System.out.println(" 12 - Exercise 14.14 - Words Ending with 'ED'");
            System.out.println(" 13 - Exercise 14.15 - Int to Char");
            System.out.println(" 14 - Exercise 14.16 - Custom indexOf/lastIndexOf");
            System.out.println(" 15 - Exercise 14.17 - 3-Letter Combinations");
            System.out.println(" 16 - Exercise 14.18 - Text Analysis");
            System.out.println(" 17 - Exercise 14.19 - Date Conversion");
            System.out.println(" 18 - Exercise 14.20 - Check Protection");
            System.out.println(" 19 - Exercise 14.21 - Check Amount in Words");
            System.out.println(" 20 - Exercise 14.22 - Morse Code");
            System.out.println(" 21 - Exercise 14.23 - Metric Conversions");
            System.out.println(" 22 - Exercise 14.24 - Spelling Checker");
            System.out.println(" 23 - Exercise 14.25 - Crossword Puzzle");
            System.out.println(" 24 - Exercise 14.26 - Healthier Ingredients (GUI)");
            System.out.println(" 25 - Exercise 14.27 - Spam Scanner");
            System.out.println(" 26 - Exercise 14.28 - SMS Translator");
            System.out.println("  0 - Exit");
            System.out.println("-".repeat(60));
            System.out.print("Choose exercise (0-26): ");
            
            int choice = input.nextInt();
            input.nextLine(); // consume newline
            
            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            
            System.out.println("\n" + "=".repeat(60));
            System.out.println("  EXERCISE 14." + (choice + 2) + (choice < 10 ? " " : "") + " - RUNNING...");
            System.out.println("=".repeat(60) + "\n");
            
            try {
                switch (choice) {
                    case 1:  ex14_3(); break;
                    case 2:  ex14_4(); break;
                    case 3:  ex14_5(); break;
                    case 4:  ex14_6(); break;
                    case 5:  ex14_7(); break;
                    case 6:  ex14_8(); break;
                    case 7:  ex14_9(); break;
                    case 8:  ex14_10(); break;
                    case 9:  ex14_11(); break;
                    case 10: ex14_12(); break;
                    case 11: ex14_13(); break;
                    case 12: ex14_14(); break;
                    case 13: ex14_15(); break;
                    case 14: ex14_16(); break;
                    case 15: ex14_17(); break;
                    case 16: ex14_18(); break;
                    case 17: ex14_19(); break;
                    case 18: ex14_20(); break;
                    case 19: ex14_21(); break;
                    case 20: ex14_22(); break;
                    case 21: ex14_23(); break;
                    case 22: ex14_24(); break;
                    case 23: ex14_25(); break;
                    case 24: ex14_26(); break;
                    case 25: ex14_27(); break;
                    case 26: ex14_28(); break;
                    default: System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
            
            System.out.println("\nPress Enter to continue...");
            input.nextLine();
        }
    }
    
    // ============================================================
    // EXERCISE 14.3 - Comparing Strings
    // ============================================================
    public static void ex14_3() {
        System.out.print("Enter first string: ");
        String str1 = input.nextLine();
        System.out.print("Enter second string: ");
        String str2 = input.nextLine();
        int result = str1.compareTo(str2);
        if (result < 0) System.out.printf("\"%s\" is less than \"%s\"%n", str1, str2);
        else if (result == 0) System.out.printf("\"%s\" is equal to \"%s\"%n", str1, str2);
        else System.out.printf("\"%s\" is greater than \"%s\"%n", str1, str2);
    }
    
    // ============================================================
    // EXERCISE 14.4 - Comparing Portions
    // ============================================================
    public static void ex14_4() {
        System.out.print("Enter first string: ");
        String str1 = input.nextLine();
        System.out.print("Enter second string: ");
        String str2 = input.nextLine();
        System.out.print("Enter number of characters: ");
        int numChars = input.nextInt();
        System.out.print("Enter start index in first: ");
        int start1 = input.nextInt();
        System.out.print("Enter start index in second: ");
        int start2 = input.nextInt();
        input.nextLine();
        boolean equal = str1.regionMatches(true, start1, str2, start2, numChars);
        System.out.println(equal ? "Portions are equal (ignoring case)." : "Portions are NOT equal.");
    }
    
    // ============================================================
    // EXERCISE 14.5 - Random Sentences
    // ============================================================
    public static void ex14_5() {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "from", "over", "under", "on"};
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            String s = String.format("%s %s %s %s %s %s",
                article[rand.nextInt(5)], noun[rand.nextInt(5)], verb[rand.nextInt(5)],
                preposition[rand.nextInt(5)], article[rand.nextInt(5)], noun[rand.nextInt(5)]);
            s = Character.toUpperCase(s.charAt(0)) + s.substring(1) + ".";
            System.out.println((i+1) + ". " + s);
        }
    }
    
    // ============================================================
    // EXERCISE 14.6 - Limericks
    // ============================================================
    public static void ex14_6() {
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "cat"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] adj = {"silly", "happy", "crazy", "lazy", "funny"};
        String[] end1 = {"day", "way", "say", "play", "stay"};
        String[] end2 = {"night", "light", "right", "sight", "might"};
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            String l = String.format(
                "There once was a %s %s,\nWho loved to %s all %s,\nBut %s %s %s,\nAnd %s %s %s,\nThat %s %s %s.\n",
                adj[rand.nextInt(5)], noun[rand.nextInt(5)],
                verb[rand.nextInt(5)], end1[rand.nextInt(5)],
                article[rand.nextInt(5)], noun[rand.nextInt(5)], verb[rand.nextInt(5)],
                article[rand.nextInt(5)], noun[rand.nextInt(5)], verb[rand.nextInt(5)],
                adj[rand.nextInt(5)], noun[rand.nextInt(5)], end1[rand.nextInt(5)]);
            System.out.println(l);
        }
    }
    
    // ============================================================
    // EXERCISE 14.7 - Pig Latin
    // ============================================================
    public static void ex14_7() {
        System.out.print("Enter phrase to convert to Pig Latin: ");
        String phrase = input.nextLine();
        String[] words = phrase.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 2) {
                result.append(word.substring(1)).append(word.charAt(0)).append("ay ");
            } else {
                result.append(word).append(" ");
            }
        }
        System.out.println("Pig Latin: " + result.toString().trim());
    }
    
    // ============================================================
    // EXERCISE 14.8 - Tokenizing Telephone
    // ============================================================
    public static void ex14_8() {
        System.out.print("Enter phone (format: (555) 555-5555): ");
        String phone = input.nextLine();
        String areaCode = phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));
        String remaining = phone.substring(phone.indexOf(")") + 1).trim();
        String[] parts = remaining.split("-");
        System.out.println("Area code: " + areaCode);
        System.out.println("Phone number: " + parts[0] + parts[1]);
    }
    
    // ============================================================
    // EXERCISE 14.9 - Reverse Words
    // ============================================================
    public static void ex14_9() {
        System.out.print("Enter a line of text: ");
        String text = input.nextLine();
        String[] words = text.split(" ");
        System.out.print("Reversed: ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
    
    // ============================================================
    // EXERCISE 14.10 - Upper/Lowercase
    // ============================================================
    public static void ex14_10() {
        System.out.print("Enter a line of text: ");
        String text = input.nextLine();
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
    }
    
    // ============================================================
    // EXERCISE 14.11 - Count Character
    // ============================================================
    public static void ex14_11() {
        System.out.print("Enter text: ");
        String text = input.nextLine();
        System.out.print("Enter character to count: ");
        char ch = input.nextLine().charAt(0);
        int count = 0, index = text.indexOf(ch);
        while (index != -1) { count++; index = text.indexOf(ch, index + 1); }
        System.out.printf("'%c' appears %d times.%n", ch, count);
    }
    
    // ============================================================
    // EXERCISE 14.12 - Letter Frequency
    // ============================================================
    public static void ex14_12() {
        System.out.print("Enter text: ");
        String text = input.nextLine().toLowerCase();
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') counts[c - 'a']++;
        }
        System.out.println("\nLetter | Count");
        System.out.println("-------|------");
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) System.out.printf("  %c    |  %d%n", (char)('a' + i), counts[i]);
        }
    }
    
    // ============================================================
    // EXERCISE 14.13 - Words Starting with 'b'
    // ============================================================
    public static void ex14_13() {
        System.out.print("Enter text: ");
        String text = input.nextLine();
        System.out.println("Words starting with 'b':");
        for (String w : text.split(" ")) {
            if (w.toLowerCase().startsWith("b")) System.out.println(w);
        }
    }
    
    // ============================================================
    // EXERCISE 14.14 - Words Ending with 'ED'
    // ============================================================
    public static void ex14_14() {
        System.out.print("Enter text: ");
        String text = input.nextLine();
        System.out.println("Words ending with 'ED':");
        for (String w : text.split(" ")) {
            if (w.toUpperCase().endsWith("ED")) System.out.println(w);
        }
    }
    
    // ============================================================
    // EXERCISE 14.15 - Int to Char
    // ============================================================
    public static void ex14_15() {
        System.out.print("Enter integer code (0-255): ");
        int code = input.nextInt();
        input.nextLine();
        if (code >= 0 && code <= 255) {
            System.out.printf("Character: '%c'%n", (char)code);
        }
        System.out.println("\nAll codes 000-255 (press Enter for each 20):");
        for (int i = 0; i <= 255; i++) {
            System.out.printf("%03d: '%c'  ", i, (char)i);
            if (i % 5 == 0 && i > 0) System.out.println();
            if (i % 20 == 0 && i > 0) {
                System.out.print("Press Enter...");
                input.nextLine();
            }
        }
    }
    
    // ============================================================
    // EXERCISE 14.16 - Custom indexOf/lastIndexOf
    // ============================================================
    public static int myIndexOf(String str, char target) {
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) == target) return i;
        return -1;
    }
    public static int myLastIndexOf(String str, char target) {
        for (int i = str.length() - 1; i >= 0; i--) if (str.charAt(i) == target) return i;
        return -1;
    }
    public static void ex14_16() {
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.print("Enter character to search: ");
        char ch = input.nextLine().charAt(0);
        System.out.println("Custom indexOf: " + myIndexOf(s, ch));
        System.out.println("Custom lastIndexOf: " + myLastIndexOf(s, ch));
    }
    
    // ============================================================
    // EXERCISE 14.17 - 3-Letter Combinations
    // ============================================================
    public static void ex14_17() {
        System.out.print("Enter a 5-letter word: ");
        String word = input.nextLine();
        if (word.length() != 5) { System.out.println("Need exactly 5 letters."); return; }
        Set<String> combos = new HashSet<>();
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) if (j != i)
            for (int k = 0; k < 5; k++) if (k != i && k != j)
                combos.add("" + word.charAt(i) + word.charAt(j) + word.charAt(k));
        int count = 0;
        for (String c : combos) { System.out.print(c + " "); if (++count % 10 == 0) System.out.println(); }
        System.out.println("\nTotal: " + combos.size());
    }
    
    // ============================================================
    // EXERCISE 14.18 - Text Analysis
    // ============================================================
    public static void ex14_18() {
        System.out.print("Enter text: ");
        String text = input.nextLine();
        // Letter counts
        int[] letters = new int[26];
        for (char c : text.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') letters[c - 'a']++;
        }
        System.out.println("\n--- Letter Frequencies ---");
        for (int i = 0; i < 26; i++) if (letters[i] > 0)
            System.out.printf("%c: %d%n", (char)('a' + i), letters[i]);
        
        // Word lengths
        Map<Integer, Integer> lengths = new HashMap<>();
        for (String w : text.split(" ")) {
            int len = w.length();
            lengths.put(len, lengths.getOrDefault(len, 0) + 1);
        }
        System.out.println("\n--- Word Lengths ---");
        for (Map.Entry<Integer, Integer> e : lengths.entrySet())
            System.out.println(e.getKey() + " letters: " + e.getValue());
        
        // Unique words
        Map<String, Integer> words = new LinkedHashMap<>();
        for (String w : text.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split(" ")) {
            if (!w.isEmpty()) words.put(w, words.getOrDefault(w, 0) + 1);
        }
        System.out.println("\n--- Unique Words ---");
        for (Map.Entry<String, Integer> e : words.entrySet())
            System.out.println(e.getKey() + ": " + e.getValue());
    }
    
    // ============================================================
    // EXERCISE 14.19 - Date Conversion
    // ============================================================
    public static void ex14_19() {
        System.out.print("Enter date (MM/DD/YYYY): ");
        String[] parts = input.nextLine().split("/");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                          "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        System.out.printf("%s %s, %s%n", months[Integer.parseInt(parts[0]) - 1], parts[1], parts[2]);
    }
    
    // ============================================================
    // EXERCISE 14.20 - Check Protection
    // ============================================================
    public static void ex14_20() {
        System.out.print("Enter dollar amount: ");
        String amount = input.nextLine().trim();
        while (amount.length() < 9) amount = "*" + amount;
        System.out.println("Protected: " + amount);
    }
    
    // ============================================================
    // EXERCISE 14.21 - Check Amount in Words
    // ============================================================
    public static void ex14_21() {
        String[] ones = {"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        String[] teens = {"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", 
                         "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
        String[] tens = {"", "", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
        
        System.out.print("Enter amount (e.g., 112.43): ");
        String[] parts = input.nextLine().split("\\.");
        int dollars = Integer.parseInt(parts[0]);
        int cents = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
        
        String result = "";
        if (dollars >= 100) { result += ones[dollars / 100] + " HUNDRED "; dollars %= 100; }
        if (dollars >= 20) { result += tens[dollars / 10] + " "; dollars %= 10; }
        else if (dollars >= 10) { result += teens[dollars - 10] + " "; dollars = 0; }
        if (dollars > 0) result += ones[dollars] + " ";
        System.out.printf("%sand %02d/100%n", result.trim(), cents);
    }
    
    // ============================================================
    // EXERCISE 14.22 - Morse Code
    // ============================================================
    public static void ex14_22() {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", 
                         "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
                         "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Character, String> toMorse = new HashMap<>();
        Map<String, Character> fromMorse = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            toMorse.put((char)('A' + i), codes[i]);
            fromMorse.put(codes[i], (char)('A' + i));
        }
        
        System.out.print("Enter text to encode: ");
        for (char c : input.nextLine().toUpperCase().toCharArray()) {
            if (c == ' ') System.out.print("  ");
            else if (toMorse.containsKey(c)) System.out.print(toMorse.get(c) + " ");
        }
        System.out.println();
    }
    
    // ============================================================
    // EXERCISE 14.23 - Metric Conversions
    // ============================================================
    public static void ex14_23() {
        Map<String, String> types = new HashMap<>();
        types.put("meters", "length"); types.put("inches", "length");
        types.put("feet", "length"); types.put("centimeters", "length");
        types.put("liters", "volume"); types.put("quarts", "volume");
        types.put("gallons", "volume"); types.put("kilograms", "mass");
        types.put("pounds", "mass"); types.put("grams", "mass");
        
        Map<String, Double> conv = new HashMap<>();
        conv.put("meters to inches", 39.3701);
        conv.put("inches to meters", 0.0254);
        conv.put("feet to meters", 0.3048);
        conv.put("centimeters to inches", 0.393701);
        conv.put("liters to quarts", 1.05669);
        conv.put("quarts to liters", 0.946353);
        conv.put("gallons to liters", 3.78541);
        conv.put("kilograms to pounds", 2.20462);
        conv.put("pounds to kilograms", 0.453592);
        
        System.out.print("Enter question (e.g., 'How many inches are in 2 meters?'): ");
        String q = input.nextLine().toLowerCase();
        String[] parts = q.split(" ");
        try {
            double amt = Double.parseDouble(parts[3]);
            String from = parts[5], to = parts[1];
            if (!types.containsKey(from) || !types.containsKey(to) || 
                !types.get(from).equals(types.get(to))) {
                System.out.println("Invalid conversion.");
                return;
            }
            String key = from + " to " + to;
            if (conv.containsKey(key))
                System.out.printf("%.2f %s = %.2f %s%n", amt, from, amt * conv.get(key), to);
            else System.out.println("Conversion not supported.");
        } catch (Exception e) {
            System.out.println("Invalid format.");
        }
    }
    
    // ============================================================
    // EXERCISE 14.24 - Spelling Checker
    // ============================================================
    public static void ex14_24() {
        String[] dict = {"default", "handy", "birthday", "computer", "programming",
                        "java", "spelling", "checker", "word", "correct", "incorrect"};
        System.out.print("Enter word to check: ");
        String word = input.nextLine().toLowerCase();
        boolean found = false;
        for (String d : dict) if (d.equals(word)) { found = true; break; }
        if (found) System.out.println("Word is spelled correctly.");
        else {
            System.out.println("Word is not spelled correctly.");
            System.out.print("Did you mean: ");
            for (int i = 0; i < word.length() - 1; i++) {
                char[] chars = word.toCharArray();
                char temp = chars[i]; chars[i] = chars[i+1]; chars[i+1] = temp;
                String transposed = new String(chars);
                for (String d : dict) if (d.equals(transposed)) System.out.print("\"" + transposed + "\" ");
            }
            System.out.println();
        }
    }
    
    // ============================================================
    // EXERCISE 14.25 - Crossword Puzzle
    // ============================================================
    public static void ex14_25() {
        String[] dict = {"java", "code", "program", "class", "object", "method",
                        "variable", "array", "string", "loop", "if", "else"};
        char[][] grid = new char[10][10];
        for (char[] row : grid) Arrays.fill(row, ' ');
        Random rand = new Random();
        for (int attempt = 0; attempt < 50; attempt++) {
            String word = dict[rand.nextInt(dict.length)];
            boolean horiz = rand.nextBoolean();
            int row = rand.nextInt(10), col = rand.nextInt(10);
            if (horiz && col + word.length() > 10) continue;
            if (!horiz && row + word.length() > 10) continue;
            boolean canPlace = true;
            for (int i = 0; i < word.length(); i++) {
                int r = horiz ? row : row + i;
                int c = horiz ? col + i : col;
                if (grid[r][c] != ' ' && grid[r][c] != word.charAt(i)) { canPlace = false; break; }
            }
            if (canPlace) {
                for (int i = 0; i < word.length(); i++) {
                    int r = horiz ? row : row + i;
                    int c = horiz ? col + i : col;
                    grid[r][c] = word.charAt(i);
                }
            }
        }
        System.out.println("Crossword Puzzle:");
        System.out.println("  0123456789");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) System.out.print(grid[i][j] == ' ' ? '.' : grid[i][j]);
            System.out.println();
        }
    }
    
    // ============================================================
    // EXERCISE 14.26 - Healthier Ingredients (GUI)
    // ============================================================
    public static void ex14_26() {
        Map<String, String> subs = new HashMap<>();
        subs.put("1 cup sour cream", "1 cup yogurt");
        subs.put("1 cup milk", "1/2 cup evaporated milk and 1/2 cup water");
        subs.put("1 teaspoon lemon juice", "1/2 teaspoon vinegar");
        subs.put("1 cup sugar", "1/2 cup honey");
        subs.put("1 cup butter", "1 cup margarine or yogurt");
        subs.put("1 cup flour", "1 cup rye or rice flour");
        subs.put("1 cup mayonnaise", "1 cup cottage cheese");
        subs.put("1 egg", "2 tablespoons cornstarch or 2 egg whites");
        subs.put("1/4 cup oil", "1/4 cup applesauce");
        subs.put("white bread", "whole-grain bread");
        
        JFrame frame = new JFrame("Healthy Cooking Helper");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JTextArea inputA = new JTextArea(10, 40);
        JTextArea outputA = new JTextArea(10, 40);
        outputA.setEditable(false);
        JButton btn = new JButton("Find Healthier Substitutions");
        btn.addActionListener(e -> {
            StringBuilder result = new StringBuilder("Original:\n" + inputA.getText() + "\n\nSubstitutions:\n");
            for (String line : inputA.getText().split("\n")) {
                result.append(line);
                for (Map.Entry<String, String> sub : subs.entrySet()) {
                    if (line.toLowerCase().contains(sub.getKey().toLowerCase()))
                        result.append(" → ").append(sub.getValue());
                }
                result.append("\n");
            }
            result.append("\n⚠️ Consult your physician before changing your diet.");
            outputA.setText(result.toString());
        });
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(inputA));
        panel.add(new JScrollPane(outputA));
        frame.add(new JLabel("Enter recipe (one ingredient per line):", SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(btn, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        System.out.println("GUI window opened! Close it to continue.");
    }
    
    // ============================================================
    // EXERCISE 14.27 - Spam Scanner
    // ============================================================
    public static void ex14_27() {
        String[] spamWords = {"free", "viagra", "million", "dollars", "lottery", "winner",
                             "credit", "mortgage", "refinance", "insurance", "loan", "debt",
                             "consolidation", "guaranteed", "100%", "urgent", "immediate",
                             "act now", "limited time", "offer", "click here", "subscribe",
                             "unsubscribe", "cash", "bonus", "prize", "congratulations", "selected"};
        System.out.print("Enter email message: ");
        String msg = input.nextLine().toLowerCase();
        int score = 0;
        for (String word : spamWords) {
            if (msg.contains(word)) { score++; System.out.println("⚠️ Found: " + word); }
        }
        System.out.println("\nSpam Score: " + score + "/" + spamWords.length);
        if (score > 10) System.out.println("🚨 HIGH LIKELIHOOD OF SPAM!");
        else if (score > 5) System.out.println("⚠️ MEDIUM LIKELIHOOD OF SPAM");
        else System.out.println("✅ LOW LIKELIHOOD OF SPAM");
    }
    
    // ============================================================
    // EXERCISE 14.28 - SMS Translator
    // ============================================================
    public static void ex14_28() {
        Map<String, String> sms = new LinkedHashMap<>();
        sms.put("imo", "in my opinion");
        sms.put("lol", "laughing out loud");
        sms.put("brb", "be right back");
        sms.put("gtg", "got to go");
        sms.put("ttyl", "talk to you later");
        sms.put("omg", "oh my god");
        sms.put("idk", "i don't know");
        sms.put("jk", "just kidding");
        sms.put("btw", "by the way");
        sms.put("afk", "away from keyboard");
        sms.put("rofl", "rolling on floor laughing");
        sms.put("smh", "shaking my head");
        sms.put("np", "no problem");
        sms.put("ty", "thank you");
        sms.put("yw", "you're welcome");
        
        System.out.print("Enter SMS message: ");
        String msg = input.nextLine().toLowerCase();
        String[] words = msg.split(" ");
        StringBuilder result = new StringBuilder();
        for (String w : words) {
            result.append(sms.getOrDefault(w, w)).append(" ");
        }
        System.out.println("Translated: " + result.toString().trim());
    }
}