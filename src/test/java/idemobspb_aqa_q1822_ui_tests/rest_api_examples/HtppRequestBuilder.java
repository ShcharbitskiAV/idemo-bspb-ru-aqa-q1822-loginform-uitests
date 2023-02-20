package idemobspb_aqa_q1822_ui_tests.rest_api_examples;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public interface HtppRequestBuilder {

    default HttpRequest getRequest () {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://language.googleapis.com/v1/documents:analyzeEntities?key=API_KEY"))
                .GET()
                .build();
    }

}
