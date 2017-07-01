package cn.com.alien.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * Created by HowellYang on 30/6/17 PM4:03.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexRatpackController {

    @Bean
    public Action<Chain> index() {
        return chain -> chain .get(ctx ->{
          //  String consulApp = loadBalancer.choose("AlienConsulApp").getUri().toString();
            ctx.render("Start!");
        });
    }

}
