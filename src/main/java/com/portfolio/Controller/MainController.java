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
public class MainController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/services")
    public String services() {
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/blog")
    public String getAllBlogPosts(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String getBlogPostById(@PathVariable Long id, Model model) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        blogPost.ifPresent(post -> model.addAttribute("blogPost", post));
        return "blog";
    }

    @PostMapping("/blog")
    public String createBlogPost(@ModelAttribute("blogPost") BlogPost blogPost) {
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/blog";
    }

    @PutMapping("/blog/{id}")
    public String updateBlogPost(@PathVariable Long id, @ModelAttribute("blogPost") BlogPost blogPost) {
        blogPost.setId(id);
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/blog";
    }

    @DeleteMapping("/blog/{id}")
    public String deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return "redirect:/blog";
    }
}
