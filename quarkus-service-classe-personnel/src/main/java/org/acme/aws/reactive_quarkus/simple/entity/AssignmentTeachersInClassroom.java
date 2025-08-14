package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AssignmentTeachersInClassroom {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "assignment_uuid", updatable = false, nullable = false)
    public UUID assignmentUuid;

    @ManyToOne
    @JoinColumn(name = "personnel_uuid")
    private Personnel personnel;

    @OneToMany(mappedBy = "assignmentTeachersInClassroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Teaching> classroomOwners = new HashSet<>();

    @ManyToOne
    @JoinColumn( name = "programing_course_uuid" )
    @JsonIgnore
    private ProgrammingCourseInClassRoom programmingCourseInClassRoom;
    
}
