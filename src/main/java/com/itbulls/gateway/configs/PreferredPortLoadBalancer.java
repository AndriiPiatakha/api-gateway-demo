package com.itbulls.gateway.configs;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Predicate;

public class PreferredPortLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private final String serviceId;
    private final ObjectProvider<ServiceInstanceListSupplier> supplier;

    public PreferredPortLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> supplier, String serviceId) {
        this.supplier = supplier;
        this.serviceId = serviceId;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        return supplier.getIfAvailable().get().next()
            .map(this::chooseInstance);
    }

    private Response<ServiceInstance> chooseInstance(List<ServiceInstance> instances) {
        if (instances == null || instances.isEmpty()) {
            return new EmptyResponse();
        }

        // Prefer port 8081
        return instances.stream()
            .filter(instance -> instance.getPort() == 8081)
            .findFirst()
            .<Response<ServiceInstance>>map(DefaultResponse::new)
            .orElseGet(() -> new DefaultResponse(instances.get(0)));
    }
}