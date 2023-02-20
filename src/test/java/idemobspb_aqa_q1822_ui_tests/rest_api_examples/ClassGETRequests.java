package idemobspb_aqa_q1822_ui_tests.rest_api_examples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class ClassGETRequests extends BaseRESTAPIClass {

    HttpRequest request;

    public void methodForGetRequests() throws IOException, InterruptedException {
        request = HttpRequest.newBuilder()
                .headers()
                .GET();

    }

    public void methodWithUri() {
        request = HttpRequest.newBuilder()
                .uri(URI.create("https://idemo.bspb.ru/"));
    }

    public void methodWithBuild() {
        request = HttpRequest.newBuilder()
                .build();

    }

    public void methodWithHeaders() {


    }

    public void methodWithResponse () {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
