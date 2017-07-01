package cn.com.alien.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * Created by HowellYang on 30/6/17 PM4:03.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexRatpackController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Bean
    public Action<Chain> index() {
        return chain -> chain .get(ctx ->{

            String url = loadBalancer.choose("AlienConsulApp").getUri().toString();
            System.out.println(url);
            String consulApp = restTemplate.getForObject("http://AlienConsulApp/indexService", String.class);
            System.out.println(consulApp);

            ctx.render("Start!");
        });
    }

}
