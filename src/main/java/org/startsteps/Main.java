package org.startsteps;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.startsteps.data.BooksStorage;
import org.startsteps.resources.BooksResource;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        BooksStorage booksStorage = new BooksStorage();
        booksStorage.addbooks();

        String BASE_URI = "http://localhost:8080/";
        ResourceConfig resourceConfig = new ResourceConfig(BooksResource.class);
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        System.out.println("Server started at: " + BASE_URI);


    }
}