package org.example.calculator;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        String operand1 = request.getParameter("operand1");
        String operator = request.getParameter("operator");
        String operand2 = request.getParameter("operand2");

        double result = 0;
        String errorMessage = "";

        try {
            double num1 = Double.parseDouble(operand1);
            double num2 = Double.parseDouble(operand2);

            result = Calculate.calculate(num1, num2, operator);
        } catch (NumberFormatException e) {
            errorMessage = "Dữ liệu nhập vào không hợp lệ. Vui lòng nhập số hợp lệ.";
        } catch (ArithmeticException e) {
            errorMessage = "Lỗi phép toán: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            errorMessage = "Phép toán không hợp lệ: " + e.getMessage();
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Kết quả phép tính</title></head>");
        out.println("<body>");
        if (!errorMessage.isEmpty()) {
            out.println("<h3>Lỗi:</h3>");
            out.println("<p>" + errorMessage + "</p>");
        } else {
            out.println("<h3>Kết quả phép tính</h3>");
            out.println("<p>" + operand1 + " " + operator + " " + operand2 + " = " + result + "</p>");
        }

        out.println("<br><a href=\"index.jsp\">Trở lại trang chủ</a>");
        out.println("</body>");
        out.println("</html>");
    }
}