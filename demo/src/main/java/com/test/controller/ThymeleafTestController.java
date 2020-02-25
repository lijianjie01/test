package com.test.controller;

import com.test.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafTestController {

    @GetMapping("/thymeleaf/index")
    public String testIndex(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setUserName("userName" + i);
            u.setSex("sex" + i);
            u.setAge(i);
            u.setPassword("password" + i);
            userList.add(u);
        }
        model.addAttribute("userList", userList);
        model.addAttribute("userName", "userName-----");
        return "index";
    }

}
