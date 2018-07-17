package br.com.matheus.moiptest.infra;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class LocalDateJsonConfigurator {

    private static final DateTimeFormatter FORMATTER = ofPattern("dd/MM/yyyy");

    public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return LocalDate.parse(p.getValueAsString(), FORMATTER);
        }
    }
}
