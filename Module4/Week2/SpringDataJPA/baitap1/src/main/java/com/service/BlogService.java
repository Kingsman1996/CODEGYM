package com.service;

import com.model.Blog;
import com.model.Category;
import com.repo.BlogRepository;
import com.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository, CategoryRepository categoryRepository) {
        this.blogRepository = blogRepository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Blog> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return blogRepository.findAll(pageable);
    }

    public Page<Blog> search(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return blogRepository.searchByKeyword(keyword, pageable);
    }

    public Optional<Blog> getById(Long id) {
        return blogRepository.findById(id);
    }

    public Page<Blog> getByCategory(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.map(c -> blogRepository.findByCategory(c, pageable))
                .orElse(Page.empty(pageable));
    }

    public Blog create(Blog blog, Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            blog.setCategory(category.get());
            return blogRepository.save(blog);
        }
        throw new IllegalArgumentException("Danh mục không tồn tại");
    }

    public void update(Long id, Blog blogDetails, Long categoryId) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (blogOptional.isPresent()) {
            Blog blog = blogOptional.get();
            blog.setTitle(blogDetails.getTitle());
            blog.setContent(blogDetails.getContent());
            blog.setCreatedAt(blogDetails.getCreatedAt());
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()) {
                blog.setCategory(category.get());
            } else {
                throw new IllegalArgumentException("Danh mục không tồn tại");
            }
            blogRepository.save(blog);
        }
    }

    public void delete(Long id) {
        if (blogRepository.existsById(id)) {
            blogRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Bài viết không tồn tại");
        }
    }
}
