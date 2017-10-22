package org.zwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/view")
public class ThymeleafController {

    @GetMapping("/test")
    public String test() {
        return "testView.html";
    }
}
