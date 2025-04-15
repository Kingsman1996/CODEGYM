package org.example.examination.controller;

import org.example.examination.model.dao.BookDAO;
import org.example.examination.model.dao.CardDAO;
import org.example.examination.model.dao.StudentDAO;
import org.example.examination.model.dto.Book;
import org.example.examination.model.dto.Card;
import org.example.examination.model.dto.Student;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();
    private final StudentDAO studentDAO = new StudentDAO();
    private final CardDAO cardDAO = new CardDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                int bookId = Integer.parseInt(request.getParameter("bookId"));
                Book book = null;
                List<Student> studentList = null;
                String today = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                try {
                    book = bookDAO.getById(bookId);
                    studentList = studentDAO.getAll();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                request.setAttribute("today", today);
                request.setAttribute("studentList", studentList);
                request.setAttribute("book", book);
                request.getRequestDispatcher("borrow.jsp").forward(request, response);
                break;
            case "list":
                List<Card> cardList = null;
                try {
                    cardList = cardDAO.getAll();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                request.setAttribute("cardList", cardList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            case "return":
                int cardId = Integer.parseInt(request.getParameter("cardId"));
                cardList = null;
                try {
                    cardDAO.returnBook(cardId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                try {
                    cardList = cardDAO.getAll();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                request.setAttribute("cardList", cardList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            default:
                try {
                    request.setAttribute("bookList", bookDAO.getAll());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("borrow")) {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int bookId = Integer.parseInt(request.getParameter("bookCode").replace("S-", ""));
            String borrowDate = request.getParameter("borrowDate");
            String returnDate = request.getParameter("returnDate");
            try {
                cardDAO.insertBorrowCard(studentId, bookId, borrowDate, returnDate);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            response.sendRedirect("book?action=");
        }
    }
}