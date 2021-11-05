package br.com.alura.loja;

import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClienteTest {
    @Test
    public void testaQueAConexaoComOServidorFuncion(){
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://www.mocky.io");

        String conteudo = target.path("/v2/52aaf5bbee7ba8c60329fb7b").request().get(String.class);

        Assert.assertTrue(conteudo.contains("Rua Vergueiro 3185"));
    }
}