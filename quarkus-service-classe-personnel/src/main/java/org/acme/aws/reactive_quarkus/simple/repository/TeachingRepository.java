package org.acme.aws.reactive_quarkus.simple.repository;

import org.acme.aws.reactive_quarkus.simple.entity.SchoolYear;
import org.acme.aws.reactive_quarkus.simple.entity.Teaching;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeachingRepository implements PanacheRepository<Teaching> {

}
