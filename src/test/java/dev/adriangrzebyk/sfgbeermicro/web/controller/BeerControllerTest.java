package dev.adriangrzebyk.sfgbeermicro.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.adriangrzebyk.sfgbeermicro.web.model.BeerDto;
import dev.adriangrzebyk.sfgbeermicro.web.model.BeerStyle;
import dev.adriangrzebyk.sfgbeermicro.web.service.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	private static final String url = "/api/v1/beer/";

	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	BeerService beerService;

	@Test
	void getBeer() throws Exception {
		mockMvc.perform(get( url + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void saveBeer() throws Exception {
		BeerDto beerDto = new BeerDto(null, "New Beer", BeerStyle.PALE_ALE, 101L, new BigDecimal("21.37"));
		BeerDto savedBeerDto = new BeerDto(UUID.randomUUID(), "New Beer", BeerStyle.PALE_ALE, 101L, new BigDecimal("21.37"));
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		when(beerService.saveNewBeer(any(BeerDto.class))).thenReturn(savedBeerDto);

		mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void updateBeer() throws Exception {
		BeerDto beerDto = new BeerDto(null, "Galaxy Cat", BeerStyle.PALE_ALE, 102L, new BigDecimal("21.37"));
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(put(url + UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	void shouldReturnBadRequest() throws Exception {
		BeerDto beerDto = new BeerDto(UUID.randomUUID(), "Galaxy Cat", BeerStyle.PALE_ALE, 102L, new BigDecimal("21.37"));
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}