public class Test {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");

        Member member1 = new Member();
        Member member2 = new Member();

        System.out.println("Member1 asked to borrow the book");
        member1.borrowBook();
        System.out.print("Member1 show book information: ");
        System.out.println(member1.getBookInfo());

        System.out.println("Member2 asked to borrow the book");
        member2.borrowBook();
        System.out.print("Member2 show book information: ");
        System.out.println(member2.getBookInfo());

        member1.returnBook();
        System.out.println("Member1 returned the book");

        System.out.println("Member2 asked to borrow the book");
        member2.borrowBook();
        System.out.print("Member2 show book information: ");
        System.out.println(member2.getBookInfo());

        System.out.println("END TESTING SINGLETON PATTERN");
    }
}
