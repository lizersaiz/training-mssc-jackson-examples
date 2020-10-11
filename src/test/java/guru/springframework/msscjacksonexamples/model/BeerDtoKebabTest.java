package guru.springframework.msscjacksonexamples.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest{

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void testKebab() throws JsonProcessingException {
		
		BeerDto beerDto = getDto();
		
		String serializedJson = objectMapper.writeValueAsString(beerDto);
		System.out.println(serializedJson);
	}
}
