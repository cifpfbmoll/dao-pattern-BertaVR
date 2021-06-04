package edu.pingpong;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.panache.common.Sort;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RepoFruit implements PanacheRepository<Fruit>{
    
    public List<Fruit> listAllOrderedByName() {
        return this.listAll(Sort.by("name").ascending());
    }

    public Optional<Fruit> findByNameOptional(String name) {
        return this.find("name", name).firstResultOptional();
    }

    public void deleteByName(String name) {
        Optional<Fruit> fruit = this.findByNameOptional(name);
        if (fruit.isPresent()) {
            this.delete(fruit.get());
        }
    }

    
    
}
