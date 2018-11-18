package mysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String login(){
        return "index";
    }
    @GetMapping("/home")
    public String homepage(){
        return "home";
    }
}