package org.acme.aws.reactive_quarkus.simple.entity;

import java.util.UUID;

import org.acme.aws.reactive_quarkus.simple.enums.Semestre;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Teaching {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "teaching_uuid", updatable = false, nullable = false)
    public UUID teachingUuid;

    @ManyToOne
    @JoinColumn(name = "id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "course_uuid" , nullable = true )
    private Course course;

    @ManyToOne
    @JoinColumn(name = "school_year_id" , nullable = true )
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "assignment_uuid")
    @JsonIgnore
    private AssignmentTeachersInClassroom assignmentTeachersInClassroom;

    private Semestre semester;

    private Boolean required;

    public Teaching() {
    }

    public UUID getTeachingUuid() {
        return teachingUuid;
    }

    public void setTeachingUuid(UUID teachingUuid) {
        this.teachingUuid = teachingUuid;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Semestre getSemester() {
        return semester;
    }

    public void setSemester(Semestre semester) {
        this.semester = semester;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }


}
