package dev.adriangrzebyk.sfgbeermicro.web.model;

import java.util.UUID;

public class BeerDto {
	private UUID id;
	private String beerName;
	private String beerStyle;
	private long upc;

	public BeerDto() {
	}

	public BeerDto(UUID id) {
		this.id = id;
	}

	public BeerDto(UUID id, String beerName, String beerStyle, long upc) {
		this.id = id;
		this.beerName = beerName;
		this.beerStyle = beerStyle;
		this.upc = upc;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public String getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(String beerStyle) {
		this.beerStyle = beerStyle;
	}

	public long getUpc() {
		return upc;
	}

	public void setUpc(long upc) {
		this.upc = upc;
	}
}
