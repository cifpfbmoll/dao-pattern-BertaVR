package edu.pingpong;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ServiceFruit {


    @Inject 
    RepoFruit repo;

    public ServiceFruit() { }

    public List<Fruit> list(){
        return repo.listAllOrderedByName(); 
    } 

    
}
