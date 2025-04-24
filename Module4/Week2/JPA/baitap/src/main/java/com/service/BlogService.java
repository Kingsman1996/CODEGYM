package com.service;


import com.model.Blog;
import com.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository BlogRepository;

    @Autowired
    public BlogService(BlogRepository BlogRepository) {
        this.BlogRepository = BlogRepository;
    }

    public List<Blog> findAll() {
        return BlogRepository.findAll();
    }

    public Optional<Blog> findById(Long id) {
        return BlogRepository.findById(id);
    }

    public void save(Blog blog) {
        BlogRepository.save(blog);
    }

    public void deleteById(Long id) {
        BlogRepository.deleteById(id);
    }
}
