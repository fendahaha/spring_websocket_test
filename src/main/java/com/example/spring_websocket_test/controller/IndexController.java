package com.example.spring_websocket_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "home page";
    }

    @GetMapping("/ws_test")
    public String websocket_test() {
        return "ws_test";
    }

    @GetMapping("/stomp_test")
    public String stomp_test(String username, Model model) {
        model.addAttribute("username", username);
        return "stomp_test";
    }
}
