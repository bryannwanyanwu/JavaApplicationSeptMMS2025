
package LibraryManagementSystems;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Assignment 9: Library Management System ===\n");
        
        // Create librarian
        Librarian librarian = new Librarian("LIB-001", "Ms. Librarian");
        
        // Add books
        System.out.println("--- Adding Books ---");
        librarian.addBook("BK-001", "Java Programming", "John Doe");
        librarian.addBook("BK-002", "Data Structures", "Jane Smith");
        librarian.addBook("BK-003", "Database Systems", "Bob Wilson");
        librarian.addBook("BK-004", "Web Development", "Alice Brown");
        librarian.addBook("BK-005", "Machine Learning", "Dr. Johnson");
        
        // Register members
        System.out.println("\n--- Registering Members ---");
        librarian.registerMember("MB-001", "Alice Johnson", "alice@email.com");
        librarian.registerMember("MB-002", "Bob Williams", "bob@email.com");
        librarian.registerMember("MB-003", "Charlie Davis", "charlie@email.com");
        
        // Display initial status
        librarian.displayAllBooks();
        librarian.displayAllMembers();
        
        // Borrow books
        System.out.println("\n--- Borrowing Books ---");
        librarian.borrowBook("MB-001", "BK-001");
        librarian.borrowBook("MB-001", "BK-003");
        librarian.borrowBook("MB-002", "BK-002");
        
        // Display books after borrowing
        librarian.displayAllBooks();
        
        // Return a book
        System.out.println("\n--- Returning Books ---");
        librarian.returnBook("MB-001", "BK-001");
        
        // Display final status
        librarian.displayAllBooks();
        
        // Display member details
        Member member = librarian.findMember("MB-001");
        if (member != null) {
            member.displayMemberInfo();
        }
        
        System.out.println("\n=== Library Management System Test Complete ===");
    }
    
}
