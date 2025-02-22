package org.acme.aws.graphql_quarkus.test_unitaire;


import io.quarkus.test.junit.QuarkusTest;
import org.acme.aws.graphql_quarkus.body_request_and_body_response.EleveInput;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import java.util.Date;



@QuarkusTest
public class EleveRessourceTest {

    @Test
    public void testGlobalListStudent() {
        given()
          .when().get("/graphql?query={globalListStudent{birthday}}")
          .then()
             .statusCode(200)
             .body("data.globalListStudent", hasSize(0)); // Adjust the expected size based on your data
      /*     .then()
             .statusCode(200)
             .body("data.globalListStudent", hasSize(0)); // Adjust the expected size based on your data */
    }

    @Test
    public void testCreateStudent() {
        EleveInput eleveInput = new EleveInput();
        eleveInput.setNom("John Doe");
        eleveInput.setBirthday(new Date());


        given()
          .contentType("application/json")
          .body(eleveInput)
          .when().post("/graphql?mutation={createStudent(eleveInput:{name:\"John Doe\", age:20}){name, age}}")
          .then()
             .statusCode(200)
             .body("data.createStudent.name", is("John Doe"))
             .body("data.createStudent.age", is(20));
    }
}