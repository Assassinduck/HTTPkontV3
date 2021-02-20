package HTTPkont.httpclient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTTPClientTest {

    @Test
    void should_Work() {
        assertEquals(4, 2+2);
    }
    @Test
    void should_Fail(){
        assertEquals(-1, 2+2);
    }

}
