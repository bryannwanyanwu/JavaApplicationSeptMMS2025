
package LibraryManagementSystems;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    public void displayBookInfo() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + 
            (isAvailable ? "Available" : "Borrowed"));
    }
}
