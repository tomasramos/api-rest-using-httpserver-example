package apiRest.handlers;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class JsonHandler implements HttpHandler {

	public void handle(HttpExchange exchange) throws IOException {
		String jsonResponse = "{\"message\": \"Hello from the API!\"}";
		exchange.getResponseHeaders().set("Content-Type", "application/json");
		exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);
		OutputStream os = exchange.getResponseBody();
		os.write(jsonResponse.getBytes());
		os.close();

	}

}
