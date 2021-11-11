package br.com.alura.loja;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;

import java.net.URI;

public abstract class ServerTestBase {

    private HttpServer server;

    @Before
    public void before() {
        ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
        URI uri = URI.create("http://localhost:8080/");

        this.server = GrizzlyHttpServerFactory.createHttpServer(uri, config);

        System.out.println("Servidor rodando");
    }

    @After
    public void after(){
        this.server.stop();
    }
}
