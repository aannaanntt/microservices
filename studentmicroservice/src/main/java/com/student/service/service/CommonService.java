package com.student.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.service.controller.req.CreateAddressRequest;
import com.student.service.feign.AddressFeign;
import com.student.service.res.AddressResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	@Autowired
	AddressFeign add;
	
	Logger log = LoggerFactory.getLogger(CommonService.class);
	
	long count=1;
	
	@CircuitBreaker(name = "addressService" ,fallbackMethod = "fallBackgetAddressById")
	public AddressResponse addressResponse(CreateAddressRequest addressRequest) {
		log.info("count ="+count);
		count++;
//		Mono<AddressResponse> bodyToMono = client.post().uri("/getById").body(Mono.just(addressRequest),CreateAddressRequest.class).retrieve()
//				.bodyToMono(AddressResponse.class);
//
//		return bodyToMono.block();

		AddressResponse address = 
				add.getById(addressRequest);

		return address;

	}
	
	
	public AddressResponse fallBackgetAddressById(CreateAddressRequest addressRequest,Throwable th) {
		log.error("Error ="+th);
		return new AddressResponse();
	}

}
