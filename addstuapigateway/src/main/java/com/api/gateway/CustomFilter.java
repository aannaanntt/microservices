package com.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements  GlobalFilter {
	
	Logger log = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		log.info("Authorization = "+ request.getHeaders().getFirst("Authorization"));
		if(request.getURI().toString().contains("/api/student")) {
			System.out.println("Happy");
			
		}
		
		
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse response = exchange.getResponse();
			log.info("Post fileter  ="+response.getStatusCode());
		}));
	}

}
