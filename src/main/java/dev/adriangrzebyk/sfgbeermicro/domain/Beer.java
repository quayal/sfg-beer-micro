package dev.adriangrzebyk.sfgbeermicro.domain;

import dev.adriangrzebyk.sfgbeermicro.web.model.BeerStyle;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID id;
	@Version
	private long version;
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	private String beerName;
	private BeerStyle beerStyle;
	@Column(unique = true)
	private long upc;
	private BigDecimal price;
	private int minOnHand;
	private int quantityToBrew;
}
