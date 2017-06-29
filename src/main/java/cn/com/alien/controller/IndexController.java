package cn.com.alien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * Created by HowellYang on 29/6/17 AM11:07.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/")
    public String index() {
        List<String> list = discoveryClient.getServices();
        System.out.println(discoveryClient.getLocalServiceInstance());
        String alienConsulAppUrl = "";
        for (String item : list){
            System.out.println(item);
            List<ServiceInstance> instanceList = discoveryClient.getInstances(item);
            for (ServiceInstance instance : instanceList){
                System.out.println(instance.isSecure());
                System.out.println(instance.getUri().toString());
            }
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances("AlienConsulApp");
        for (ServiceInstance instance : instanceList) {

            alienConsulAppUrl = instance.getUri().toString();

        }

        return restTemplate.getForObject(alienConsulAppUrl + "/indexService", String.class);

       // return "Hello World!Controller";
    }
}
