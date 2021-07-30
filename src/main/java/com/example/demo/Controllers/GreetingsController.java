package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class GreetingsController {

    @GetMapping("/hello")
    String greeting(){
        return "Hello";
    }

    @GetMapping("/upperCase/{text}")
    String upperCase(@PathVariable String text, Model model){
        model.addAttribute("text", text.toUpperCase());
        return "UpperCase";
    }


}
