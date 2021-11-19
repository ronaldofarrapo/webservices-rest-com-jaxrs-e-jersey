package br.com.alura.loja.resource;

import br.com.alura.loja.ServerTestBase;
import br.com.alura.loja.modelo.Projeto;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class ProjetoResourceTest extends ServerTestBase {

    @Test
    public void busca() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");

        String conteudo = target.path("/projetos/1").request().get(String.class);
        Projeto projeto = (Projeto) new XStream().fromXML(conteudo);

        assertEquals(1L, projeto.getId());
    }
}