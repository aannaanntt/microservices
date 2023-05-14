package com.address.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.microservice.req.CreateAddressRequest;
import com.address.microservice.res.AddressResponse;
import com.address.microservice.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.createAddress(createAddressRequest);
	}
	
	@PostMapping("/getById")
	public AddressResponse getById(@RequestBody CreateAddressRequest id) {
		return addressService.getById(id.getId());
	}

}
