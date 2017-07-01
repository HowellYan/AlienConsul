package run;

import cn.com.alien.settings.ratpack.StartRatpack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HowellYang on 29/6/17 AM10:45.
 * E-Mail:th15817161961@gmail.com
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
//@EnableDiscoveryClient
@ComponentScan("cn.com.alien")
@SpringBootApplication
@StartRatpack
public class Application {
    @Bean
    @LoadBalanced
        //注解开启均衡负载能力
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
