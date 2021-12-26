package com.example.demo.controller;

import com.example.demo.models.Company;
import com.example.demo.models.Signup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("content"," we are one");

        Company com = new Company();
        com.address = "Hà Nội";
        com.fax = "0868231092";
        com.phone = "085747828";
        com.name = "NIIT";
        model.addAttribute("companyInfo",com);

        String staffNames[] = new String[]{
                "Luân",
                "Nam",
                "Long",
                "Lê"
        };
        model.addAttribute("staffNames", staffNames);

        model.addAttribute("type", 1+"");
        return "/about";
    }
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signup", new Signup());
        return "signup";
    }

    @PostMapping("/do-signup")
    public String doSignup(Signup s) {
        System.out.println(s.getFullname());
        System.out.println(s.getUserName());
        System.out.println(s.getPhone());
        return "redirect:signup";
    }
}
