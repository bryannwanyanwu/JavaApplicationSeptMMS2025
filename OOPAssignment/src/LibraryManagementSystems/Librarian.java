
package LibraryManagementSystems;


public class Librarian {


import java.util.ArrayList;

public class Librarian {
    private String librarianId;
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    
    public Librarian(String librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    
    // Book Management
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    
    public void addBook(String bookId, String title, String author) {
        books.add(new Book(bookId, title, author));
        System.out.println("Book added: " + title);
    }
    
    public Book findBook(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    // Member Management
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member.getName());
    }
    
    public void registerMember(String memberId, String name, String email) {
        members.add(new Member(memberId, name, email));
        System.out.println("Member registered: " + name);
    }
    
    public Member findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
    
    // Borrowing and Returning
    public void borrowBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);
        
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        
        member.borrowBook(book);
    }
    
    public void returnBook(String memberId, String bookId) {
        Member member = findMember(memberId);
        Book book = findBook(bookId);
        
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        
        member.returnBook(book);
    }
    
    // Display Methods
    public void displayAllBooks() {
        System.out.println("\n=== Library Books ===");
        System.out.println("ID       | Title                       | Author              | Status");
        System.out.println("---------|-----------------------------|---------------------|----------");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
        System.out.println("====================");
    }
    
    public void displayAllMembers() {
        System.out.println("\n=== Library Members ===");
        for (Member member : members) {
            System.out.println("ID: " + member.getMemberId() + " | Name: " + member.getName() + 
                " | Books: " + member.getBorrowedBooks().size());
        }
        System.out.println("======================");
    }
}
    
}
