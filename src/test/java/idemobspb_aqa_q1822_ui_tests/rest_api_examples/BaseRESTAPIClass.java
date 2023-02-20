package idemobspb_aqa_q1822_ui_tests.rest_api_examples;

import org.junit.jupiter.api.BeforeEach;

import java.net.http.HttpClient;

public class BaseRESTAPIClass {

    protected HttpClient client;

    @BeforeEach
    public void htppClientInitialization() {
        client = HttpClient.newHttpClient();
    }

}
