package com.portfolio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/About")
    public String about(){
        return "about";
    }

    @GetMapping("/Contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/Services")
    public String Services(){
        return "Services";;
    }

}