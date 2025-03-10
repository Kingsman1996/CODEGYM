public class Member {
    private BookSingleton borrowedBook;
    private boolean haveBook = false;

    public void borrowBook() {
        borrowedBook = BookSingleton.beingBorrowed();

        if (borrowedBook == null) {
            haveBook = false;
        } else {
            haveBook = true;
        }
    }

    public String getBookInfo() {
        if (haveBook) {
            return borrowedBook.getAuthorAndTitle();
        }
        return "I don't have the book";
    }

    public void returnBook() {
        BookSingleton.beingReturned(borrowedBook);
    }
}
