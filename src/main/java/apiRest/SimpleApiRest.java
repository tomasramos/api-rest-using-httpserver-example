package apiRest;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import apiRest.handlers.Handler;
import apiRest.handlers.JsonHandler;
import apiRest.handlers.PlainTextHandler;
import apiRest.handlers.TextFileHandler;
import apiRest.handlers.XMLHandler;

public class SimpleApiRest {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/simple-sample", new Handler());
        server.createContext("/api/json", new JsonHandler());
        server.createContext("/api/xml", new XMLHandler());
        server.createContext("/api/plain-text", new PlainTextHandler());
        server.createContext("/api/text-file", new TextFileHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server running on port 8080");
    }

}
