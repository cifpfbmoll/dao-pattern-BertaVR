package edu.pingpong;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fruits")
public class FruitResource {

    @Inject
    ServiceFruit service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Colmados Farmer Rick";
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // no es necesario Produces ya que por defecto
    // resteasy jackson desactiva la negociación
    // y sirve MediaType.APPLICATION_JSON
    // curl -w "\n" http://localhost:8080/fruits/ -H "Content-Type: application/json"
    public List <Fruit> list() {
        return service.list();
    }
}