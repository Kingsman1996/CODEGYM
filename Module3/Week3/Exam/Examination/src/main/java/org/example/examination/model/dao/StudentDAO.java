package org.example.examination.model.dao;

import org.example.examination.model.dto.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static final String GET_BY_ID_SQL = "SELECT * FROM Student WHERE id = ?";
    public static final String GET_ALL_SQL = "SELECT * FROM Student";
    private final Connection connection = DBConnection.connect();


    public String getNameById(int id) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(GET_BY_ID_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        }
        return null;
    }

    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setClassName(resultSet.getString("class"));
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
}
