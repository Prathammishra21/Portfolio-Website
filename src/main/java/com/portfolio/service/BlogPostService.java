package com.portfolio.service;


import com.portfolio.entity.BlogPost;
import java.util.List;
import java.util.Optional;

public interface BlogPostService {
    List<BlogPost> getAllBlogPosts();

    Optional<BlogPost> getBlogPostById(Long id);

    BlogPost createOrUpdateBlogPost(BlogPost blogPost);

    void deleteBlogPost(Long id);
}