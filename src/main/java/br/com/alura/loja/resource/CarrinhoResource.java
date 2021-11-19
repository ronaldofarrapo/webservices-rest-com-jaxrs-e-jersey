package br.com.alura.loja.resource;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("carrinhos")
public class CarrinhoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String busca(@PathParam("id") long id){
        Carrinho carrinho = new CarrinhoDAO().busca(id);

        return carrinho.toJSON();
    }
}
