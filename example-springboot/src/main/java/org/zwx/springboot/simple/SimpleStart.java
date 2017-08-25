package org.zwx.springboot.simple;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@ComponentScan(basePackages = {"org.zwx.springboot.controller"})
public class SimpleStart {
    Logger LOG = LoggerFactory.getLogger(SimpleStart.class);

    @GetMapping("/rest/home")
    @ResponseBody
    public String home() {
        LOG.error("into home method");
        return "hello World!!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleStart.class, args);
    }
}
