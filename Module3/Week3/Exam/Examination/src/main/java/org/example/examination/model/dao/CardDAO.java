package org.example.examination.model.dao;

import org.example.examination.model.dto.Book;
import org.example.examination.model.dto.Card;
import org.example.examination.model.dto.Student;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CardDAO {
    public static final String INSERT_SQL = "INSERT INTO card (studentid, bookid, BorrowDate, ReturnDate) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_SQL = "UPDATE card SET ReturnDate = CURDATE(), Status = false WHERE id = ?";
    public static final String GET_ALL_SQL = "SELECT c.id, b.title AS bookTitle, b.author AS bookAuthor, "
            + "s.name AS studentName, s.class AS studentClass, "
            + "c.BorrowDate, c.ReturnDate "
            + "FROM card c "
            + "JOIN book b ON c.bookid = b.id "
            + "JOIN Student s ON c.studentid = s.id "
            + "WHERE c.Status = true";
    private final Connection connection = DBConnection.connect();

    public void insertBorrowCard(int studentId, int bookId, String borrowDate, String returnDate) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_SQL)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, bookId);
            stmt.setString(3, convertJSPToDBDateFormat(borrowDate));
            stmt.setString(4, convertJSPToDBDateFormat(returnDate));
            stmt.executeUpdate();
        }
        new BookDAO().reduceCopies(bookId);
    }

    private String convertDBToJSPDateFormat(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            return outputFormat.format(inputFormat.parse(inputDate));
        } catch (ParseException e) {
            return null;
        }
    }

    private String convertJSPToDBDateFormat(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            return outputFormat.format(inputFormat.parse(inputDate));
        } catch (ParseException e) {
            return null;
        }
    }

    public void returnBook(int cardId) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE_SQL)) {
            stmt.setInt(1, cardId);
            stmt.executeUpdate();
        }
        new BookDAO().increaseCopies(new BookDAO().getByCard(cardId).getId());
    }

    public List<Card> getAll() throws SQLException {
        List<Card> cardList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(GET_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Card card = new Card();
                card.setId(rs.getInt("id"));
                Book book = new Book();
                book.setTitle(rs.getString("bookTitle"));
                book.setAuthor(rs.getString("bookAuthor"));
                card.setBook(book);
                Student student = new Student();
                student.setName(rs.getString("studentName"));
                student.setClassName(rs.getString("studentClass"));
                card.setStudent(student);
                String borrowDate = convertDBToJSPDateFormat(rs.getString("BorrowDate"));
                String returnDate = convertDBToJSPDateFormat(rs.getString("ReturnDate"));
                card.setBorrowDate(borrowDate);
                card.setReturnDate(returnDate);
                cardList.add(card);
            }
        }
        return cardList;
    }
}
