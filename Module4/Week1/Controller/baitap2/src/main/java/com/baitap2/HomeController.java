package com.baitap2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String num1,
                            @RequestParam String num2,
                            @RequestParam String operator, Model model) {
        String result;
        double dNum1 = Double.parseDouble(num1);
        double dNum2 = Double.parseDouble(num2);
        switch (operator) {
            case "+":
                result = String.valueOf(dNum1 + dNum2);
                break;
            case "-":
                result = String.valueOf(dNum1 - dNum2);
                break;
            case "*":
                result = String.valueOf(dNum1 * dNum2);
                break;
            case "/":
                if (dNum2 == 0) {
                    result = "Lỗi: Không thể chia cho 0";
                } else {
                    result = String.format("%.2f", dNum1 / dNum2);
                }
                break;
            default:
                result = "Phép toán không hợp lệ!";
        }
        model.addAttribute("result", result);
        return "index";
    }
}