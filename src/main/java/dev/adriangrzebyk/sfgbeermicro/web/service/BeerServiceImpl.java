package dev.adriangrzebyk.sfgbeermicro.web.service;

import dev.adriangrzebyk.sfgbeermicro.web.model.BeerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
	private static final Logger logger = LoggerFactory.getLogger(BeerServiceImpl.class);

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return new BeerDto(UUID.randomUUID(), "Galaxy Cat", "Pale Ale", 0L);
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return new BeerDto(UUID.randomUUID());
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// todo add implementation
	}

	@Override
	public void deleteBeer(UUID beerId) {
		logger.info("Deleting beer: {}", beerId.toString());
	}
}
