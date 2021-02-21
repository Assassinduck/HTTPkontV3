package HTTPkont.httpclient;

import java.io.IOException;
import java.net.Socket;

public class HTTPClient {

    private final String requestTarget;
    private String host;


    public HTTPClient(String host, String requestTarget) {
        this.host = host;
        this.requestTarget = requestTarget;
    }


    public static void main(String[] args) throws IOException {

       new HTTPClient("urlecho.appspot.com", "/echo?status=200&Content-Type=text%2Fhtml&body=Hello%20world!").executeRequest();

    }

    //Method that executes a GET Request to the URL shown in the try resource

    public HTTPClientResponse executeRequest() throws IOException {

        //Tries to open a new websocket connection to the host url and port in question
        try (Socket socket = new Socket(host, 80)) {

            //Writes the HTTP headers that goes into the GET request
            socket.getOutputStream().write(("GET " + requestTarget + " HTTP/1.1\r\n").getBytes());
            socket.getOutputStream().write(("Host: " + host + "\r\n").getBytes());
            socket.getOutputStream().write("Connection: close\r\n".getBytes());
            socket.getOutputStream().write("\n\r".getBytes());
            socket.getOutputStream().flush();

            HTTPClientResponse httpClientResponse = new HTTPClientResponse(socket);
            httpClientResponse.invoke();
            return httpClientResponse;
        }
    }

}
