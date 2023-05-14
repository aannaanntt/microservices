//package com.student.service.feign;
//
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//import feign.Feign;
//
//@LoadBalancerClient(value="ADDRESS-SERVICE")
//public class AddressServiceLoadBalanced {
//	@LoadBalanced
//	@Bean
//	public Feign.Builder feiBuilder(){
//		return Feign.builder();
//	}
//
//}
