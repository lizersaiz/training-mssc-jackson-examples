package guru.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

	//Important things to note:
	//1. Serializing: When explicitly setting up property names, it will override any PropertyNamingStrategies applied
	//2. Deserializing: The property is expected to be called as stated in @JsonProperty. Otherwise, as it won´t be recognise,
	//	it will return null
	@JsonProperty("beerId")
	@Null
	private UUID id;
	
	@NotBlank
	private String beerName;
	
	@NotBlank
	private String beerStyle;
	
	@Positive
	private Long upc;
	
	private BigDecimal price;
	private OffsetDateTime createdDate;
	private OffsetDateTime lastUpdateDate;
}
