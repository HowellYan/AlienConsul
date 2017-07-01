package cn.com.alien.settings.consul;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.consul.ConsulProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.discovery.TtlScheduler;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;

/**
 * Created by HowellYang on 1/7/17 PM5:10.
 * E-Mail:th15817161961@gmail.com
 */
@Configuration
public class ConsulConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ConsulDiscoveryProperties consulDiscoveryProperties(InetUtils inetUtils) {
        ConsulDiscoveryProperties consulDiscoveryProperties = new ConsulDiscoveryProperties(inetUtils);
        consulDiscoveryProperties.setPort(8090);
        consulDiscoveryProperties.setIpAddress("localhost");
        consulDiscoveryProperties.setServiceName("Alien");
        consulDiscoveryProperties.setHealthCheckUrl("http://localhost:8090/");
        consulDiscoveryProperties.setHostname("localhost");
        return consulDiscoveryProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsulAutoServiceRegistration consulAutoServiceRegistration(ConsulServiceRegistry registry, ConsulDiscoveryProperties properties, ConsulAutoRegistration consulRegistration) {
        return new ConsulAutoServiceRegistration(registry, properties, consulRegistration);
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsulAutoRegistration consulRegistration(ConsulDiscoveryProperties properties, ApplicationContext applicationContext, ServletContext servletContext, HeartbeatProperties heartbeatProperties) {
        return ConsulAutoRegistration.registration(properties, applicationContext, servletContext, heartbeatProperties);
    }

    @Autowired(
            required = false
    )
    private TtlScheduler ttlScheduler;

    @Bean
    @ConditionalOnMissingBean
    public ConsulServiceRegistry consulServiceRegistry(ConsulClient consulClient, ConsulDiscoveryProperties properties, HeartbeatProperties heartbeatProperties) {
        return new ConsulServiceRegistry(consulClient, properties, this.ttlScheduler, heartbeatProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public HeartbeatProperties heartbeatProperties() {
        return new HeartbeatProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsulProperties consulProperties() {
        return new ConsulProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsulClient consulClient(ConsulProperties consulProperties) {
        return new ConsulClient(consulProperties.getHost(), consulProperties.getPort());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty({"spring.cloud.consul.discovery.heartbeat.enabled"})
    public TtlScheduler ttlScheduler(ConsulClient consulClient, HeartbeatProperties heartbeatProperties) {
        return new TtlScheduler(heartbeatProperties, consulClient);
    }



}
