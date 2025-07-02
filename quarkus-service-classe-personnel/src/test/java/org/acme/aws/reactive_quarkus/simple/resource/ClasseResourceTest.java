package org.acme.aws.reactive_quarkus.simple.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.acme.aws.reactive_quarkus.simple.entity.Personnel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.UUID;


@QuarkusTest
public class ClasseResourceTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost/staff_classe_course";
        RestAssured.port = 8092;
    }

    @Test
    public void testListClasses() {
        given()
            .when().get("/classe/list")
            .then()
            .statusCode(200)
            .body(equalTo("List of classes"));
    }

    @Test
    public void testAddClass() {
        Personnel personnel = new Personnel();
        personnel.setPersonnelUuid( UUID.randomUUID() );
        personnel.setNom("John Doe");

        given()
            .contentType(ContentType.JSON)
            .body(personnel)
            .when().post("/classe/add")
            .then()
            .statusCode(200)
          //  .body("id", equalTo(1))
            .body("nom", equalTo("John Doe"));
    }

    @Test
    public void testRemoveClass() {
        Long classroomId = 42L;

        given()
            .contentType(ContentType.JSON)
            .body(classroomId)
            .when().post("/classe/classe/{classroomId}", classroomId)
            .then()
            .statusCode(200)
            .body(equalTo(classroomId.toString()));
    }
}