package org.zwx.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Generated;

@Controller("/")
public class SimpleController {

    @GetMapping("/test")
    public ResponseEntity<String> test()
    {
        return new ResponseEntity("test", HttpStatus.OK);
    }
}
