package HTTPkont.httpclient;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTTPClientTest {


    @Test
    void shouldReadSuccessStatusCode() throws IOException {
        HTTPClient client = new HTTPClient("urlecho.appspot.com", "/echo");
        HTTPClientResponse response = client.executeRequest();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void shouldReadFailureStatusCode() throws IOException {
        HTTPClient client = new HTTPClient("urlecho.appspot.com", "/echo?status=401");
        HTTPClientResponse response = client.executeRequest();
        assertEquals(401, response.getStatusCode());
    }

}
