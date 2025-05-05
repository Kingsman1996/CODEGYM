package com.controller;

import com.model.job.Post;
import com.model.user.Recruiter;
import com.model.user.User;
import com.service.PostService;
import com.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class RecruiterController {
    private final RecruiterService recruiterService;
    private final PostService postService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService, PostService postService) {
        this.recruiterService = recruiterService;
        this.postService = postService;
    }

    @ModelAttribute("recruiter")
    Recruiter getRecruiter(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return recruiterService.findByUser(user);
    }

    @GetMapping("/recruiter/profile")
    public String showProfile(Model model) {
        return "recruiter/profile";
    }

    @GetMapping("/recruiter/create")
    public String showForm(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "recruiter/create";
    }

    @PostMapping("/recruiter/create")
    public String postJob(@ModelAttribute Post post,
                          @ModelAttribute("recruiter") Recruiter recruiter) {
        post.setRecruiter(recruiter);
        postService.save(post);
        return "redirect:/recruiter/create";
    }

    @GetMapping("/recruiter/home")
    public String showHome(Model model, @ModelAttribute("recruiter") Recruiter recruiter) {
        model.addAttribute("posts", postService.findByRecruiter(recruiter));
        return "recruiter/home";
    }

    @GetMapping("/recruiter/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Post existingPost = postService.findById(id);
        model.addAttribute("post", existingPost);
        return "recruiter/edit";
    }

    @PostMapping("/recruiter/edit")
    public String updatePost(@ModelAttribute Post post, HttpSession session) {
        post.setRecruiter(getRecruiter(session));
        postService.save(post);
        return "redirect:/recruiter/home";
    }

    @GetMapping("/recruiter/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return "redirect:/recruiter/home";
    }
}
