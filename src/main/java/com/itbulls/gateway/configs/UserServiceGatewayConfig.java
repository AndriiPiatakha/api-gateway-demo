package com.itbulls.gateway.configs;

import java.util.Objects;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

//@Configuration
//@LoadBalancerClient(name = "user-service-lb", configuration = UserServiceLbConfig.class)
//public class UserServiceGatewayConfig {
//}
//
//class UserServiceLbConfig {
//    @Bean
//    public ReactorServiceInstanceLoadBalancer randomLoadBalancer(
//            Environment env,
//            LoadBalancerClientFactory clientFactory) {
//        return new RandomLoadBalancer(
//            clientFactory.getLazyProvider(
//                Objects.requireNonNull(env.getProperty(LoadBalancerClientFactory.PROPERTY_NAME)),
//                ServiceInstanceListSupplier.class
//            ),
//            env.getProperty(LoadBalancerClientFactory.PROPERTY_NAME)
//        );
//    }
//}


//@Configuration
//@LoadBalancerClient(name = "user-service-lb", configuration = UserServiceGatewayConfig.class)
//public class UserServiceGatewayConfig {
//	@Bean
//	public ReactorServiceInstanceLoadBalancer customLoadBalancer(LoadBalancerClientFactory clientFactory) {
//		String serviceId = "user-service-lb";
//		return new PreferredPortLoadBalancer(
//				clientFactory.getLazyProvider(serviceId, ServiceInstanceListSupplier.class), serviceId);
//	}
//}


//@Configuration
//@LoadBalancerClient(name = "user-service-lb", configuration = UserServiceGatewayConfig.class)
//public class UserServiceGatewayConfig {
//
//   @Bean
//   public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
//        return ServiceInstanceListSupplier.builder()
//            .withDiscoveryClient()
//            .withHealthChecks()
//            .build(context);
//    }
//   
//   @Bean
//   public ReactorServiceInstanceLoadBalancer roundRobinLoadBalancer(
//           LoadBalancerClientFactory clientFactory) {
//
//       String serviceId = "user-service-lb";
//       return new RoundRobinLoadBalancer(
//               clientFactory.getLazyProvider(serviceId, ServiceInstanceListSupplier.class),
//               serviceId
//       );
//   }
//}