package converters;

import jakarta.persistence.AttributeConverter;

import java.util.Map;

public class JsonConverter implements AttributeConverter<Map<String, Object>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        return null;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        return null;
    }

}
