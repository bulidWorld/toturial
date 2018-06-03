package org.zwx.oa.controller.portal;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/oa")
public class IndexPortal {

    @GetMapping("/index.html")
    public String index() {
        return "/index";
    }
}
