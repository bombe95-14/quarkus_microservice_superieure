package org.acme.aws.reactive_quarkus.simple.repository;

import java.util.List;
import java.util.Optional;

import org.acme.aws.reactive_quarkus.simple.entity.Classe;
import org.acme.aws.reactive_quarkus.simple.enums.DepartmentEnum;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ClasseRepository implements PanacheRepository<Classe> {

    // This class can be used to define custom database queries for Classe entities.
    // For example, you can add methods to find classes by their name, department, etc.
    
    // Example method to find a class by its name      <dependencies>

    public  Optional<Classe> findByName(String name) {
        return find("nomClasse", name).singleResultOptional();
//        .firstResult();
    }

    @Override
    public boolean deleteById(Long idClasse) {
        // TODO Auto-generated method stub
        return deleteById( idClasse );
    }

    @Override
    public List<Classe> listAll() {
        // TODO Auto-generated method stub
        return PanacheRepository.super.listAll();
    }

    public List<Classe> findByDepartment( DepartmentEnum department ) {
        // TODO Auto-generated method stub
               return list("department", department);

    }

    public List<Classe> findByFormationType( String formationType ) {
        // TODO Auto-generated method stub
        return list("formationType", formationType);
    }

}//  FormationType
