package apiRest.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TextFileHandler implements HttpHandler {

	public void handle(HttpExchange exchange) throws IOException {
        // Specify the file path
        String filePath = "src/main/resources/file.txt";

        // Read the file
        File file = new File(filePath);
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(fileContent);
        fis.close();

        // Set the response headers
        exchange.getResponseHeaders().set("Content-Type", "text/plain");
        exchange.sendResponseHeaders(200, fileContent.length);

        // Send the file content as the response
        OutputStream os = exchange.getResponseBody();
        os.write(fileContent);
        os.close();
    }

}
