package org.zwx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestScanController {

    @GetMapping("/rest/test/scan")
    @ResponseBody
    public String m1() {
        return "m1--------------";
    }
}
