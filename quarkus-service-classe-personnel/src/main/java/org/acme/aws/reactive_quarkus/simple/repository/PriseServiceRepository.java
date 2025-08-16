package org.acme.aws.reactive_quarkus.simple.repository;

import org.acme.aws.reactive_quarkus.simple.entity.PriseService;
import org.acme.aws.reactive_quarkus.simple.entity.SchoolYear;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PriseServiceRepository implements PanacheRepository<PriseService>  {

}
