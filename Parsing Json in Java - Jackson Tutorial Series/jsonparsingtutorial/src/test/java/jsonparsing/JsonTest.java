package jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import jsonparsing.pojo.AuthorPOJO;
import jsonparsing.pojo.BookPOJO;
import jsonparsing.pojo.DayPOJO;
import jsonparsing.pojo.SimpleTestCaseJsonPojo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTest {

    private String jsonSource = "{\n" +
            "  \"name\":\"Alice\",\n" +
            "  \"age\":30,\n" +
            "  \"surename\":\"Richard\"\n" +
            "}";

    private String dayScenarioOne = "{\n" +
            "  \"date\": \"2019-12-25\",\n" +
            "  \"name\": \"Xmas day!\"\n" +
            "}";

    private String authorBookScenarioOne = "{\n" +
            "  \"authorName\": \"Rui\",\n" +
            "  \"books\": [\n" +
            "    { \"title\": \"Title1\", \"inPrint\": true, \"publishDate\": \"2019-12-25\" },\n" +
            "    { \"title\": \"Title2\", \"inPrint\": true, \"publishDate\": \"2019-01-02\" }\n" +
            "  ]\n" +
            "}";

    @Test
    void TestParse_JSON() throws JsonProcessingException {
        JsonNode node = Json.parse(jsonSource);
        assertEquals(node.get("name").asText(), "Alice");
    }

    @Test
    void TestFrom_JSON() throws JsonProcessingException {
        JsonNode node = Json.parse(jsonSource);
        SimpleTestCaseJsonPojo pojo = Json.fromJson(node, SimpleTestCaseJsonPojo.class);

        assertEquals(pojo.getAge(), "30");
        assertEquals(pojo.getName(), "Alice");

    }

    @Test
    void Test_POJO_Object_To_JSON() throws JsonProcessingException {
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setAge("12");
        pojo.setName("AS");

        JsonNode json = Json.toJsonNode(pojo);
        System.out.println(json);

        assertEquals(json.get("age").asText(), "12");
        assertEquals(json.get("name").asText(), "AS");
    }

    @Test
    void Test_JSON_To_String() throws JsonProcessingException {
        SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
        pojo.setAge("12");
        pojo.setName("AS");

        JsonNode json = Json.toJsonNode(pojo);
        System.out.println(json);

        System.out.println(Json.toJsonString(json));
    }


    @Test
    void Test_DayTestScenarioOne() throws JsonProcessingException {
        JsonNode json = Json.parse(dayScenarioOne);
        System.out.println(json);
        DayPOJO pojo = Json.fromJson(json, DayPOJO.class);

        System.out.println(" Date :" + pojo.getDate());

        assertEquals("2019-12-25", pojo.getDate().toString());
    }

    @Test
    void Test_AuthorBookScenarioOne() throws JsonProcessingException {
        JsonNode json = Json.parse(authorBookScenarioOne);
        System.out.println(json);
        AuthorPOJO pojo = Json.fromJson(json, AuthorPOJO.class);

        System.out.println(" Author : " + pojo.getAuthorName());

        for (BookPOJO book : pojo.getBooks()) {
            System.out.println(book.getTitle());
            System.out.println(book.getPublishDate());
        }
    }
}


