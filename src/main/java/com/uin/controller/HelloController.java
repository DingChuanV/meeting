package com.uin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/5:07 PM
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "hello world,BearBrick0");
        return "hello";
    }
}
