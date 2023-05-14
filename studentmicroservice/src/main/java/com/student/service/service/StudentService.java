package com.student.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.service.controller.req.CreateAddressRequest;
import com.student.service.controller.req.CreateStudentRequest;
import com.student.service.feign.AddressFeign;
import com.student.service.model.Student;
import com.student.service.repo.StudentRepository;
import com.student.service.res.AddressResponse;
import com.student.service.res.StudentResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient client;

	@Autowired
	AddressFeign add;
	
	@Autowired
	CommonService cs;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		CreateAddressRequest addressRequest = new CreateAddressRequest();
		addressRequest.setId(student.getId());
		StudentResponse response = new StudentResponse(student);
		response.setAddressResponse(cs.addressResponse(addressRequest));

		return response;
	}

	public StudentResponse getById(long id) {
		Student student = studentRepository.findById(id).get();

		StudentResponse response = new StudentResponse(student);
		CreateAddressRequest addressRequest = new CreateAddressRequest();
		addressRequest.setId(student.getId());
		response.setAddressResponse(cs.addressResponse(addressRequest));

		System.out.println(response);
		return response;  
	}

//	@CircuitBreaker(name = "addressService" ,fallbackMethod = "fallBackgetAddressById")
//	public AddressResponse addressResponse(CreateAddressRequest addressRequest) {
////		Mono<AddressResponse> bodyToMono = client.post().uri("/getById").body(Mono.just(addressRequest),CreateAddressRequest.class).retrieve()
////				.bodyToMono(AddressResponse.class);
////
////		return bodyToMono.block();
//
//		AddressResponse address = 
//				add.getById(addressRequest);
//
//		return address;
//
//	}
//	
//	
//	public AddressResponse fallBackgetAddressById(CreateAddressRequest addressRequest,Throwable th) {
//		 return new AddressResponse();
//	}
}
