// framework che crea 4 endpoint
// 1 che aggiunge, uno che elimina, uno che legge la lista e uno che li cerca
// nel main creo il server utilizzando un ednpoint cosi che quando lo chiamo, mi risposte all'endpoint, con la classe con gli
// endpoint ed un file con la connessione al db
// http endler , con registrazione endpoint
import java.util.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
 
 
public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
 
        String uri = exchange.getRequestURI().toString();  // Get the requested URI
 
        String response;
        if (uri.equals("/books/search") && exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            response = "Search okay";
            String query = exchange.getRequestURI().getQuery();
            System.out.println("Query parameters: " + query);
        } else if (uri.equals("/books") && exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            response = "Get list okay";
         } else if (uri.equals("/books") && exchange.getRequestMethod().equalsIgnoreCase("DELETE")) {
          response = "Delete okay";  
        } else if (uri.equals("/books") && exchange.getRequestMethod().equalsIgnoreCase("PUT")) {
            response = "Insert okay";
         }  else {
            exchange.sendResponseHeaders(400, -1);
            return;
        }
        
        // Write response body
        OutputStream os = exchange.getResponseBody();
        exchange.getResponseHeaders().add("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, response.getBytes().length);
        os.write(response.getBytes());
        os.close(); // Always close the output stream!
 
    }
}