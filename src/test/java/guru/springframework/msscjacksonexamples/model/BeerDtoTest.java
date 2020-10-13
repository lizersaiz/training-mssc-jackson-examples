package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonTest
class BeerDtoTest extends BaseTest {

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testSerializeDto() throws JsonProcessingException {
		
		BeerDto beerDto = getDto();
		
		String jsonString = objectMapper.writeValueAsString(beerDto);
		
		System.out.println(jsonString);
	}

	@Test
	void testDeserializeDto() throws JsonMappingException, JsonProcessingException {
		
		//no formated fields
		//String json = "{\"beerId\":\"f6e0d0b6-2428-4bc7-9b70-3449670bc1b2\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123123,\"price\":12.99,\"createdDate\":\"2020-10-11T02:55:27.9553706+02:00\",\"lastUpdateDate\":\"2020-10-11T02:55:27.9573715+02:00\"}";
		//price as string, created date will only display year/month/day
		//String json = "{\"beerId\":\"f6e0d0b6-2428-4bc7-9b70-3449670bc1b2\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123123,\"price\":12.99,\"createdDate\":\"2020-10-11+02:00\",\"lastUpdateDate\":\"2020-10-11T02:55:27.9573715+02:00\", \"myLocalDate\":\"20201011\"}";
		//adding myLocalDate property
		//String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123123,\"price\":\"12.99\",\"createdDate\":\"2020-10-11T15:07:22-0400\",\"lastUpdateDate\":\"2020-10-11T15:07:22.0345469+02:00\",\"myLocalDate\":\"20201011\",\"beerId\":\"d6f66172-95c6-4261-93f0-e12eb6536f88\"}";
		
		BeerDto beerDtoInput = getDto();
		String jsonStringInput = objectMapper.writeValueAsString(beerDtoInput);
		
		BeerDto beerDtoOutput = objectMapper.readValue(jsonStringInput, BeerDto.class);
		
		System.out.println(beerDtoOutput);
	}
}
