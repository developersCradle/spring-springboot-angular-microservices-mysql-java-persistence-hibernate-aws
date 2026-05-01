package jsonparsing;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// This will be util class!
public class Json {

    static private ObjectMapper objectMapper = getDefaultObjectMapper();

    /**
     *  Construction happens here, coz we need configure the mapper!
     */
    private static ObjectMapper getDefaultObjectMapper() {
       ObjectMapper defaultObjectMapper = new ObjectMapper();
        // Configure the mapper here!

        // We don't want to throw exception when there unknown fields.
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // We want to use Java 8 Dates.
        defaultObjectMapper.registerModule(new JavaTimeModule());

        return defaultObjectMapper;
    }

    // Parse from String JSON -> JsonNode.
    public static JsonNode parse(String source) throws JsonProcessingException {
        // We are reading tree mapping!
        return objectMapper.readTree(source);
    }

    // From JsonNode to POJO Object!
    public static<A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }

    // POJO to JsonNode!
    public static JsonNode toJsonNode(Object object)
    {
        return objectMapper.valueToTree(object);
    }

    // JsonNode to String!
    public static String toJsonString(JsonNode node) throws JsonProcessingException {
        ObjectWriter objectWriter = objectMapper.writer();
        // For the pretty print.
        objectWriter.with(SerializationFeature.INDENT_OUTPUT);
        return objectWriter.writeValueAsString(node);
    }
}
