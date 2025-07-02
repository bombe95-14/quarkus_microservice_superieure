package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ClassRoom {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "class_room_uuid", updatable = false, nullable = false)
    public UUID id;

    public String name;
    public String buildingName;   
    public Integer nombrePlace;

}
