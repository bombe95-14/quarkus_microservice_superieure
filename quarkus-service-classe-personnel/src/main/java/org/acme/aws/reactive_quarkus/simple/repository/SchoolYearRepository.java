package org.acme.aws.reactive_quarkus.simple.repository;

import org.acme.aws.reactive_quarkus.simple.entity.SchoolYear;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class SchoolYearRepository implements PanacheRepository<SchoolYear> {

    // You can add custom query methods here if needed
    // For example:
    // public List<SchoolYear> findByName(String name) {
    //     return find("name", name).list();
    // }    

}   
