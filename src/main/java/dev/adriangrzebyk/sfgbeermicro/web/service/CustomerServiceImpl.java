package dev.adriangrzebyk.sfgbeermicro.web.service;

import dev.adriangrzebyk.sfgbeermicro.web.model.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public CustomerDto getCustomerById(UUID id) {
		return new CustomerDto(UUID.randomUUID(), "Chuck Norris");
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		return new CustomerDto(UUID.randomUUID(), "John Doe");
	}

	@Override
	public void updateCustomer(UUID id, CustomerDto customerDto) {
		logger.info("Updating customer: {}", id);
	}

	@Override
	public void deleteCustomer(UUID id) {
		logger.info("Deleting customer: {}", id);
	}
}
