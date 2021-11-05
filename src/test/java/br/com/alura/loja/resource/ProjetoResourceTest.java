package br.com.alura.loja.resource;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ProjetoResourceTest {

    @Test
    public void busca() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080");

        String conteudo = target.path("/projetos").request().get(String.class);

        Assert.assertTrue(conteudo.contains("Minha loja"));
    }
}