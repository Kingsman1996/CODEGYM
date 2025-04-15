package org.example.examination.model.dao;

import org.example.examination.model.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static final String GET_ALL_SQL = "SELECT * FROM book";
    public static final String GET_BY_ID_SQL = "SELECT * FROM book WHERE id = ?";
    public static final String REDUCE_AMOUNT_SQL = "UPDATE book SET amount = amount - 1 WHERE id = ?";
    public static final String INCREASE_AMOUNT_SQL = "UPDATE book SET amount = amount + 1 WHERE id = ?";
    public static final String GET_BY_CARD_SQL = "SELECT * FROM card WHERE id = ?";
    private final Connection connection = DBConnection.connect();

    public List<Book> getAll() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
            while (resultSet.next()) {
                Book book = mapResultSet(resultSet);
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookList;
    }

    private static Book mapResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setCode(resultSet.getString("code"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setDescription(resultSet.getString("description"));
        book.setAmount(resultSet.getInt("amount"));
        return book;
    }

    public Book getById(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSet(resultSet);
            }
        }
        return null;
    }

    public void reduceCopies(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(REDUCE_AMOUNT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void increaseCopies(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INCREASE_AMOUNT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public Book getByCard(int cardId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CARD_SQL)) {
            preparedStatement.setInt(1, cardId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    return getById(rs.getInt("bookid"));
                }
            }
        }
        return null;
    }
}
