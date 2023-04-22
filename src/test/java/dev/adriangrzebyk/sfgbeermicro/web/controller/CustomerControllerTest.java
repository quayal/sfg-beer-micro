package dev.adriangrzebyk.sfgbeermicro.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.adriangrzebyk.sfgbeermicro.web.model.BeerDto;
import dev.adriangrzebyk.sfgbeermicro.web.model.BeerStyle;
import dev.adriangrzebyk.sfgbeermicro.web.model.CustomerDto;
import dev.adriangrzebyk.sfgbeermicro.web.service.BeerService;
import dev.adriangrzebyk.sfgbeermicro.web.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	private static final String url = "/api/v1/customer/";

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	CustomerService customerService;

	@Test
	void getCustomer() throws Exception {
		mockMvc.perform(get( url + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void saveCustomer() throws Exception {
		CustomerDto customerDto = new CustomerDto(null, "Will Riker");
		CustomerDto savedCustomerDto = new CustomerDto(UUID.randomUUID(), "Will Riker");
		String beerDtoJson = objectMapper.writeValueAsString(customerDto);

		when(customerService.saveCustomer(any(CustomerDto.class))).thenReturn(savedCustomerDto);

		mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void updateCustomer() throws Exception {
		CustomerDto customerDto = new CustomerDto(UUID.randomUUID(), "Will Riker");
		String customerDtoJson = objectMapper.writeValueAsString(customerDto);

		mockMvc.perform(put(url + UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(customerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	void shouldReturnBadRequest() throws Exception {
		CustomerDto customerDto = new CustomerDto(null,
				"ThisIsANameThatIsLongerThanHundredCharactersThisIsANameThatIsLongerThanHundredCharactersThisIsANameThatIsLongerThanHundredCharacters");
		String customerDtoJson = objectMapper.writeValueAsString(customerDto);

		mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(customerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}