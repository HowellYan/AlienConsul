package cn.com.alien.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HowellYang on 29/6/17 AM11:11.
 * E-Mail:th15817161961@gmail.com
 * 提供方
 */
@RestController
public class IndexService {

    @RequestMapping("/indexService")
    public String indexService() {
        System.out.println("in start");
        return "Hello World!Service";
    }


}
