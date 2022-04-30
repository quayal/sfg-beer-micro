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

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	BeerService beerService;

	@Test
	void getBeer() throws Exception {
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void saveBeer() throws Exception {
		BeerDto beerDto = new BeerDto(UUID.randomUUID(), "Galaxy Cat", BeerStyle.PALE_ALE, 0L);
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		when(beerService.saveNewBeer(any(BeerDto.class))).thenReturn(beerDto);

		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void updateBeer() throws Exception {
		BeerDto beerDto = new BeerDto(UUID.randomUUID(), "Galaxy Cat", BeerStyle.PALE_ALE, 0L);
		String beerDtoJson = objectMapper.writeValueAsString(beerDto);

		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
}