package org.acme.aws.reactive_quarkus.simple.entity;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProgrammingCourseInClassRoom {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "programing_course_uuid", updatable = false, nullable = false)
    private UUID programmingCourseUuid;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne( targetEntity = ClassRoom.class, fetch = FetchType.LAZY )
    @JoinColumn(name = "class_room_uuid")
    private ClassRoom classRoom;

    @OneToMany(mappedBy = "programmingCourseInClassRoom",  cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<AssignmentTeachersClassroom> assignmentTeachersClassrooms = new java.util.HashSet<>();

}
