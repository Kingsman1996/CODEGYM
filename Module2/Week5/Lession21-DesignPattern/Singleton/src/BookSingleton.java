public class BookSingleton {
    private String author;
    private String title;
    private static boolean isLoanedOut;
    private static BookSingleton bookInstance;

    private BookSingleton() {
        author = "Gamma, Helm, Johnson";
        title = "Design Patterns";
        bookInstance = null;
        isLoanedOut = false;
    }

    public static BookSingleton beingBorrowed() {
        if (!isLoanedOut) {
            if (bookInstance == null) {
                bookInstance = new BookSingleton();
            }
            isLoanedOut = true;
            return bookInstance;
        }
        return null;
    }

    public static void beingReturned(BookSingleton bookReturned) {
        isLoanedOut = false;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorAndTitle() {
        return getTitle() + " written by " + getAuthor();
    }
}
