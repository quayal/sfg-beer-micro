package dev.adriangrzebyk.sfgbeermicro.web.controller;

import dev.adriangrzebyk.sfgbeermicro.web.model.CustomerDto;
import dev.adriangrzebyk.sfgbeermicro.web.service.CustomerService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer/")
@RestController
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID id) {
		return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@Validated @RequestBody CustomerDto customerDto) {
		CustomerDto saved = customerService.saveCustomer(customerDto);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + saved.getId());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID id, @RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(id, customerDto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") UUID id) {
		customerService.deleteCustomer(id);
	}
}
