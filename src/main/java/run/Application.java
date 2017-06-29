package run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HowellYang on 29/6/17 AM10:45.
 * E-Mail:th15817161961@gmail.com
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan("cn.com.alien")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
