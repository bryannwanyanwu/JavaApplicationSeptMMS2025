
package LibraryManagementSystems;


public class Member {
    private String memberId;
    private String name;
    private String email;
    private ArrayList<Book> borrowedBooks;
    private int maxBooks;
    
    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.maxBooks = 5;
    }
    
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }
    
    public boolean canBorrow() {
        return borrowedBooks.size() < maxBooks;
    }
    
    public void borrowBook(Book book) {
        if (canBorrow() && book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Cannot borrow book. Limit reached or book unavailable.");
        }
    }
    
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println("Book not borrowed by this member.");
        }
    }
    
    public void displayMemberInfo() {
        System.out.println("\n=== Member Information ===");
        System.out.println("ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Books Borrowed: " + borrowedBooks.size() + "/" + maxBooks);
        if (!borrowedBooks.isEmpty()) {
            System.out.println("Currently Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle());
            }
        }
        System.out.println("==========================");
    }
}
    
}
