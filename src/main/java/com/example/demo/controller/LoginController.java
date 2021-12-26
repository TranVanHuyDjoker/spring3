package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //Tải giao diện login
    @GetMapping("/login")
    public String login() {
        return "login/login";
    }


    //tiếp nhận dữ liệu gửi từ form hoặc client và xử lý
    @PostMapping("/do-login")
    public String doLogins(@RequestParam(name = "username") String userName,
                          @RequestParam(name="password") String password) {
        System.out.println(userName);
        System.out.println(password);
        System.out.println("Spring boot");
        return "redirect:login"; //lệnh chuyển hướng url

    }
}
