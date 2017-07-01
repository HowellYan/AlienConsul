package cn.com.alien.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import ratpack.func.Action;
import ratpack.handling.Chain;

/**
 * Created by HowellYang on 1/7/17 PM6:31.
 * E-Mail:th15817161961@gmail.com
 */
@RestController
public class IndexRatpackService {

    @Bean
    public Action<Chain> indexService() {
        return PrefixChain -> PrefixChain.prefix("indexService", GChain -> GChain
                .all(context -> {
                    context.byMethod(method -> {
                        method.get(()->{

                            context.getResponse().send("indexService");
                        });
                    });
                })
        );
    }

}
