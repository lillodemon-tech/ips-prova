import java.util.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// id autore titolo anno
public class Main {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
            );

            server.createContext("/books", new MyHandler());
            server.start();

            System.out.println("Server running on localhost:8080...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

