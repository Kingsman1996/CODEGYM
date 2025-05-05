package com.service;

import com.model.job.Post;
import com.model.job.PostStatus;
import com.model.user.Recruiter;
import com.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        if (post.getStatus() == null) {
            post.setStatus(PostStatus.PENDING);
        }
        post.setPostedDate(LocalDate.now());
        postRepository.save(post);
    }

    public Post findById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

    public List<Post> findByRecruiter(Recruiter recruiter) {
        return postRepository.findByRecruiter(recruiter);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> findByStatus(PostStatus status) {
        return postRepository.findByStatus(status);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
