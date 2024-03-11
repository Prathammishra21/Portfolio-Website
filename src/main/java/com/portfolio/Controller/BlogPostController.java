package com.portfolio.Controller;

import com.portfolio.entity.BlogPost;
import com.portfolio.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Blog")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public String getAllBlogPosts(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "blogpost-list";
    }

    @GetMapping("/{id}")
    public String getBlogPostById(@PathVariable Long id, Model model) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        blogPost.ifPresent(post -> model.addAttribute("blogPost", post));
        return "blogpost-detail";
    }

    @PostMapping
    public String createBlogPost(@ModelAttribute("blogPost") BlogPost blogPost) {
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/blog";
    }

    @PutMapping("/{id}")
    public String updateBlogPost(@PathVariable Long id, @ModelAttribute("blogPost") BlogPost blogPost) {
        blogPost.setId(id);
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/blog";
    }

    @DeleteMapping("/{id}")
    public String deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return "redirect:/blog";
    }
}