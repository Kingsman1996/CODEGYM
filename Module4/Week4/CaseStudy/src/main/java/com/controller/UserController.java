package com.controller;

import com.model.user.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Validated
@RequestMapping("/users")
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
            model.addAttribute("user", user);
            return "user/register";
        } else {
            userService.register(user);
            model.addAttribute("message", "Đăng ký thành công!");
            model.addAttribute("user", new User());
            return "user/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (!userService.checkLogin(username, password)) {
            model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu sai.");
            return "user/login";
        }
        model.addAttribute("user", userService.getByUserName(username));
        return "user/profile";
    }

    @GetMapping("/update/{userId}")
    public String showUpdateForm(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user/update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,
                             @RequestParam String email,
                             @RequestParam String password) {
        userService.update(id, email, password);
        return "redirect:/users/profile/" + id;
    }


    @GetMapping("/profile/{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user/profile";
    }
}
