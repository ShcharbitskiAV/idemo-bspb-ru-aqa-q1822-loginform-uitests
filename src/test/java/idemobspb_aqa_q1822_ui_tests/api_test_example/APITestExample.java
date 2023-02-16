package idemobspb_aqa_q1822_ui_tests.api_test_example;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APITestExample {

    @Test
    public void verifySuccessStatusCode () throws Exception {

        String nameOfBody = "{\n" +
                "  \"error\": {\n" +
                "    \"code\": \"API_KEY_INVALID\",\n" +
                "    \"message\": \"An invalid api_key was supplied. Get one at https://developer.nrel.gov/signup/\"\n" +
                "  }\n" +
                "}";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://language.googleapis.com/v1/documents:analyzeEntities?key=API_KEY"))
                .GET()
                .build();

        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        Assertions.assertEquals(HttpStatus.SC_FORBIDDEN, response.statusCode());
        Assertions.assertEquals(nameOfBody, response.body());
    }
}
