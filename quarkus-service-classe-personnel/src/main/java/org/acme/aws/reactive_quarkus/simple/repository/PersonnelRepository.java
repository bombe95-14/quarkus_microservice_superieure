package org.acme.aws.reactive_quarkus.simple.repository;

import org.acme.aws.reactive_quarkus.simple.entity.Personnel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonnelRepository implements PanacheRepository<Personnel> {

    // You can add custom query methods here if needed
    // For example:
    // public List<Personnel> findByName(String name) {
    //     return find("name", name).list();
    // }

}
