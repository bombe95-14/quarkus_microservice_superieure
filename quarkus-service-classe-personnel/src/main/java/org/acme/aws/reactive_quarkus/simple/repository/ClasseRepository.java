package org.acme.aws.reactive_quarkus.simple.repository;

import org.acme.aws.reactive_quarkus.simple.entity.Classe;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ClasseRepository implements PanacheRepository<Classe> {

    // This class can be used to define custom database queries for Classe entities.
    // For example, you can add methods to find classes by their name, department, etc.
    
    // Example method to find a class by its name
    public Classe findByName(String name) {
        return find("nomClasse", name).firstResult();
    }

}
