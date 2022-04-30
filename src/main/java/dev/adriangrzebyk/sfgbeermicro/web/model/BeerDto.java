package dev.adriangrzebyk.sfgbeermicro.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BeerDto {
	private UUID id;
	private int version;
	private OffsetDateTime created;
	private OffsetDateTime modified;
	private String beerName;
	private BeerStyle beerStyle;
	private long upc;
	private BigDecimal price;

	public BeerDto() {
	}

	public BeerDto(UUID id) {
		this.id = id;
	}

	public BeerDto(UUID id, String beerName, BeerStyle beerStyle, long upc) {
		this.id = id;
		this.beerName = beerName;
		this.beerStyle = beerStyle;
		this.upc = upc;
	}

	public BeerDto(UUID id, int version, OffsetDateTime created, OffsetDateTime modified, String beerName,
	               BeerStyle beerStyle, long upc, BigDecimal price) {
		this.id = id;
		this.version = version;
		this.created = created;
		this.modified = modified;
		this.beerName = beerName;
		this.beerStyle = beerStyle;
		this.upc = upc;
		this.price = price;
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

	public BeerStyle getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(BeerStyle beerStyle) {
		this.beerStyle = beerStyle;
	}

	public long getUpc() {
		return upc;
	}

	public void setUpc(long upc) {
		this.upc = upc;
	}
}
