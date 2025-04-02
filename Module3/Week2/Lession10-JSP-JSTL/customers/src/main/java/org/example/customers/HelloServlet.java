package org.example.customers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/customer")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Nguyễn Văn A", "1990-01-15", "Hà Nội"));
        customers.add(new Customer("Trần Thị B", "1985-07-22", "Hồ Chí Minh"));
        customers.add(new Customer("Lê Văn C", "1993-03-10", "Đà Nẵng"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}