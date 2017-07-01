package cn.com.alien.settings.consul;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.cloud.consul.discovery.*;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by HowellYang on 1/7/17 PM6:46.
 * E-Mail:th15817161961@gmail.com
 */

@Configuration
public class ConsulDiscoveryClientConfiguration {
    @Autowired
    private ConsulClient consulClient;

    @Autowired(
            required = false
    )
    private ServerProperties serverProperties;

    @Bean
    @ConditionalOnMissingBean
    public ConsulDiscoveryClient consulDiscoveryClient(ConsulDiscoveryProperties discoveryProperties, ApplicationContext context) {
        ConsulDiscoveryClient discoveryClient = new ConsulDiscoveryClient(this.consulClient, discoveryProperties,null);
        discoveryClient.setServerProperties(this.serverProperties);
        return discoveryClient;
    }

}
