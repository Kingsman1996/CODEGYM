package com.controller;

import com.model.user.User;
import com.model.user.UserRole;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/register";
        }
        try {
            userService.register(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "user/register";
        }
        model.addAttribute("success", "Đăng ký thành công");
        return "/user/register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model, HttpSession session) {
        if (!userService.checkLogin(username, password)) {
            model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu sai.");
            return "user/login";
        }
        User user = userService.findByUsername(username);
        session.setAttribute("user", user);
        if (user.getRole() == UserRole.ADMIN) {
            return "redirect:/admin/dashboard";
        } else if (user.getRole() == UserRole.RECRUITER) {
            return "redirect:/recruiter/home";
        } else {
            return "redirect:/candidate/home";
        }
    }

    @GetMapping("/update")
    public String showUpdateForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User updatedUser, HttpSession session) {
        userService.update(updatedUser);
        session.setAttribute("user", updatedUser);
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}