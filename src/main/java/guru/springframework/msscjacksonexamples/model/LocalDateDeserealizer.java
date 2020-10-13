package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserealizer extends StdDeserializer<LocalDate>{

	public LocalDateDeserealizer() {
		
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser parse, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		return LocalDate.parse(parse.readValueAs(String.class), DateTimeFormatter.BASIC_ISO_DATE);
	}
	
}
