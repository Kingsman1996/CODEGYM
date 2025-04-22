package com.thuchanh2.controller;

import com.thuchanh2.model.Login;
import com.thuchanh2.model.User;
import com.thuchanh2.model.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping()
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }
    @PostMapping()
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDAO.checkLogin(login);
        ModelAndView modelAndView;
        if(user == null){
            modelAndView = new ModelAndView("home");
            modelAndView.addObject("error", "Sai tài khoản hoặc mật khẩu");
        } else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}