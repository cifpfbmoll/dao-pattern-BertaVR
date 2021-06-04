package edu.pingpong;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="Fruit")
@JsonPropertyOrder({"name", "decription"}) //Jackson (for marshalling)
public class Fruit { 
    // Las propiedades han de ser publicas para que jackson
    // pueda acceder a ellar por reflection o configurar getter y setter
    // Internamente Quarkus hace la propiedad public
    // Mantengo el getter porque lo uso en los casos test
    
    /* EN EL DAO FRUIT SON PROPIEDADES, CONSTRUCTORES (IMPORTANTE EL POR DEFECTO), GETTERS Y SETTERS
    MÁS LAS ANOTACIONES DE PANACHE ENTITTY
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

    //Aquí HAY QUE PONER EL ID!!!!!!!!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    public String name;

    
    @Column
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
