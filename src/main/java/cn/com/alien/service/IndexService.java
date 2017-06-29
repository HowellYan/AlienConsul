package cn.com.alien.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HowellYang on 29/6/17 AM11:11.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexService {
    @RequestMapping("/indexService")
    public String indexService() {
        return "Hello World!Service";
    }


}
