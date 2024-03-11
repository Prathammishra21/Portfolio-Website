package com.portfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // This will return the home.html template
    }

    @GetMapping("/about")
    public String about() {
        return "about"; // This will return the about.html template
    }

    @GetMapping("/services")
    public String services() {
        return "services"; // This will return the services.html template
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog"; // This will return the blog.html template
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // This will return the contact.html template
    }
}
