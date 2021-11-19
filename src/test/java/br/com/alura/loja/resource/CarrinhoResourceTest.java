package br.com.alura.loja.resource;

import br.com.alura.loja.ServerTestBase;
import br.com.alura.loja.modelo.Carrinho;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class CarrinhoResourceTest extends ServerTestBase {

    @Test
    public void garantirBuscaPorId() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");

        String conteudo = target.path("/carrinhos/1").request().get(String.class);
        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);

        assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
    }
}