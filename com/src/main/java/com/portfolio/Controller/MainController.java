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
        return "/Html_Page/home";
    }

    @GetMapping("/about")
    public String about() {
        return "/Html_Page/about";
    }

    @GetMapping("/services")
    public String services() {
        return "/Html_Page/services";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/Html_Page/contact";
    }

    @GetMapping("/blog")
    public String getAllBlogPosts(Model model) {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute("blogPosts", blogPosts);
        return "/Html_Page/blog";
    }

    @GetMapping("/blog/{id}")
    public String getBlogPostById(@PathVariable Long id, Model model) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        blogPost.ifPresent(post -> model.addAttribute("blogPost", post));
        return "/Html_Page/blog";
    }

    @PostMapping("/blog")
    public String createBlogPost(@ModelAttribute("blogPost") BlogPost blogPost) {
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/Html_Page/blog";
    }

    @PutMapping("/blog/{id}")
    public String updateBlogPost(@PathVariable Long id, @ModelAttribute("blogPost") BlogPost blogPost) {
        blogPost.setId(id);
        blogPostService.createOrUpdateBlogPost(blogPost);
        return "redirect:/Html_Page/blog";
    }

    @DeleteMapping("/blog/{id}")
    public String deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return "redirect:/Html_Page/blog";
    }
}