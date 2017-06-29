package cn.com.alien.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HowellYang on 29/6/17 AM11:07.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}
