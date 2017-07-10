package cn.com.alien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Created by HowellYang on 29/6/17 AM11:07.
 * E-Mail:th15817161961@gmail.com
 * 调用方
 */
@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/getURL")
    private String getURL(){
        return loadBalancer.choose("AlienConsulApp").getUri().toString();
    }

    @RequestMapping("/")
    public String index() {
        return restTemplate.getForObject("http://AlienConsulApp/indexService", String.class);
    }
}
