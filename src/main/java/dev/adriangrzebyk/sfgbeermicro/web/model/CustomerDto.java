package dev.adriangrzebyk.sfgbeermicro.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class CustomerDto {
	@Null
	private UUID id;
	@NotNull
	@Length(min = 3, max = 100)
	private String name;

	public CustomerDto(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public CustomerDto() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
