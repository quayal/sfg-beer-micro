package dev.adriangrzebyk.sfgbeermicro.web.service;

import dev.adriangrzebyk.sfgbeermicro.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

	public CustomerDto getCustomerById(UUID id);


	CustomerDto saveCustomer(CustomerDto customerDto);

	void updateCustomer(UUID id, CustomerDto customerDto);

	void deleteCustomer(UUID id);
}
