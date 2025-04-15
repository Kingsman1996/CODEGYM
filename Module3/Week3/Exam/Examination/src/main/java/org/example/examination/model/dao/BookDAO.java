package org.example.examination.model.dao;

import org.example.examination.model.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final Connection connection = DBConnection.connect();


    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM book");
            while (resultSet.next()) {
                Book book = mapResultSet(resultSet);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookList;
    }

    private static Book mapResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setCode(rs.getString("code"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setDescription(rs.getString("description"));
        book.setAvailableCopies(rs.getInt("AvailableCopies"));
        return book;
    }

    public Book getBookById(int id) throws SQLException {
        String query = "SELECT * FROM book WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Book book = mapResultSet(rs);
                return book;
            }
        }
        return null;
    }
    public void reduceCopies(int id) throws SQLException {
        String query = "UPDATE book SET AvailableCopies = AvailableCopies - 1 WHERE id = ? AND AvailableCopies > 0";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public void increaseCopies(int id) throws SQLException {
        String query = "UPDATE book SET AvailableCopies = AvailableCopies + 1 WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
