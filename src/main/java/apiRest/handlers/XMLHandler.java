package apiRest.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class XMLHandler implements HttpHandler {

	public void handle(HttpExchange exchange) throws IOException {
        Message message = new Message("Hello from the API!");
        // Convert the message to XML using Jackson
        String xmlResponse = convertToXml(message);
        exchange.getResponseHeaders().set("Content-Type", "application/xml");
        exchange.sendResponseHeaders(200, xmlResponse.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(xmlResponse.getBytes());
        os.close();
        
    }
	
	static class Message {
        private String content;

        public Message(String content) {
            this.content = content;
        }

        // Getter and setter
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static String convertToXml(Message message) {
        try {
            ObjectMapper objectMapper = new XmlMapper();
            return objectMapper.writeValueAsString(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
