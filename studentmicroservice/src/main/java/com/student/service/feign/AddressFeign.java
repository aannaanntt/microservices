package com.student.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.student.service.controller.req.CreateAddressRequest;
import com.student.service.res.AddressResponse;



@FeignClient(value="api-gateway")
public interface AddressFeign {
	
	@PostMapping("/address-service/api/address/getById")
	public AddressResponse getById(@RequestBody CreateAddressRequest id);
		
	

}
