package com.controller;

import com.model.job.Post;
import com.model.job.PostStatus;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
    private final PostService postService;

    @Autowired
    public AdminController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/admin/post")
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "admin/post";
    }

    @GetMapping("/admin/post/pending")
    public String viewPendingPosts(Model model) {
        List<Post> pendingPosts = postService.findByStatus(PostStatus.PENDING);
        model.addAttribute("posts", pendingPosts);
        return "admin/post";
    }

    @GetMapping("/admin/post/{id}/approve")
    public String approvePost(@PathVariable Long id) {
        Post foundPost = postService.findById(id);
        foundPost.setStatus(PostStatus.APPROVED);
        postService.save(foundPost);
        return "redirect:/admin/post";
    }
    @GetMapping("/admin/post/{id}/reject")
    public String rejectPost(@PathVariable Long id) {
        Post foundPost = postService.findById(id);
        foundPost.setStatus(PostStatus.REJECTED);
        postService.save(foundPost);
        return "redirect:/admin/post";
    }
}
