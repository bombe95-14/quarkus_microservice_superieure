package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignmentTeachersClassroom {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "assignment_uuid", updatable = false, nullable = false)
    public UUID assignmentUuid;

    private String schoolYearCode;
    private String semesterCode;
    private Boolean isTitular;

    @ManyToOne
    @JoinColumn(name = "personnel_uuid")
    private Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "course_uuid" , nullable = true )
    private Course course;

    @ManyToOne
    @JoinColumn( name = "programing_course_uuid" )
    @JsonIgnore
    private ProgrammingCourseInClassRoom programmingCourseInClassRoom;
    
}
