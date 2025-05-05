package com.controller;

import com.model.application.Application;
import com.model.job.Post;
import com.model.user.Candidate;
import com.model.user.User;
import com.service.CandidateService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CandidateController {
    private final PostService postService;
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(PostService postService, CandidateService candidateService) {
        this.postService = postService;
        this.candidateService = candidateService;
    }

    @ModelAttribute("postList")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @ModelAttribute("candidate")
    public Candidate getCandidate(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return candidateService.findByUser(user);
    }

    @GetMapping("/candidate/home")
    public String home(Model model) {
        model.addAttribute("postList", postService.findAll());
        return "candidate/home";
    }

    @GetMapping("/candidate/post/{id}/view")
    public String showPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "candidate/postview";
    }

    @GetMapping("/candidate/post/{id}/apply")
    public String applyForPost(@PathVariable Long id, Model model) {
        model.addAttribute("postId", id);
        return "candidate/apply";
    }
}
