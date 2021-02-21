package HTTPkont.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

class HTTPClientResponse {

    private Socket socket;
    private String statusLine;

    public HTTPClientResponse(Socket socket) {
        this.socket = socket;
    }

    public void invoke() throws IOException {

        InputStream inputStream = socket.getInputStream();
        int Byte;

        StringBuilder statusLine = new StringBuilder();

        //reads each byte that we get from the output stream
        while ((Byte = inputStream.read()) != -1 && Byte != '\r') {
            statusLine.append((char) Byte);
        }

        this.statusLine = statusLine.toString();

        while ((Byte = inputStream.read()) != -1) {
            System.out.print((char) Byte);
        }
    }

    public int getStatusCode() {
        return Integer.parseInt(statusLine.split(" ")[1]);

    }
}
