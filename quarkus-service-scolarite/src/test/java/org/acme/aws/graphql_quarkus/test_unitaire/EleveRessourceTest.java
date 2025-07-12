package org.acme.aws.graphql_quarkus.test_unitaire;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

import org.acme.aws.graphql_quarkus.dto.request.EleveInput;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;



@QuarkusTest
public class EleveRessourceTest {

    
  // @Test
  // public void testGlobalListStudent() {

    

  //   given()
  //     .when().get("/graphql?query={globalListStudent{}}")
  //     .then()
  //      .statusCode(200)
  //      .body("data.globalListStudent", hasSize(0)); // Adjust the expected size based on your data
  // }

  @Test
  public void testCreateStudent() {
    EleveInput eleveInput = new EleveInput();
    eleveInput.setNom("John Doe");
    eleveInput.setBirthday(new Date());
    eleveInput.setPrenom("John");
    eleveInput.setSexe("Masculin"); // Assuming codeClasse is a field in EleveInput
    eleveInput.setMatricule("mskjksdjlkvsd");
    eleveInput.setNumeroCni("jdkjklsdsssdfefe");
    // eleveInput.setEmail("


    given()
      .contentType("application/json")
      .body("{ \"mutation\" : \"{createStudent(eleveInput:{nom:\"John Doe\", matricule:\"20\", numeroCni: \"123456\"}){nom, matricule, numeroCni}} \"}")

      .when().post("/graphql")
      //.post("/graphql?mutation={createStudent(eleveInput:{nom:\"John Doe\", matricule:\"20\", numeroCni: \"123456\"}){nom, matricule, numeroCni}}")
      .then()
       .statusCode(200);
    //   .body("data.createStudent.matricule", equals("20"))
    //   .body("data.createStudent.numeroCni", equals("123456"));
  }

  // @Test
  // public void testCreateStudentWithMissingName() {
  //   EleveInput eleveInput = new EleveInput();
  //   eleveInput.setBirthday(new Date());

  //   given()
  //     .contentType("application/json")
  //     .body(eleveInput)
  //     .when().post("/graphql?mutation={createStudent(eleveInput:{age:20}){name, age}}")
  //     .then()
  //      .statusCode(400); // Expecting bad request due to missing name
  // }

  // @Test
  // public void testCreateStudentWithInvalidAge() {
  //   EleveInput eleveInput = new EleveInput();
  //   eleveInput.setNom("Jane Doe");
  //   eleveInput.setBirthday(new Date());
  //   // Suppose negative age is invalid

  //   given()
  //     .contentType("application/json")
  //     .body(eleveInput)
  //     .when().post("/graphql?mutation={createStudent(eleveInput:{name:\"Jane Doe\", age:-5}){name, age}}")
  //     .then()
  //      .statusCode(400); // Expecting bad request due to invalid age
  // }

  // @Test
  // public void testGetStudentByName() {
  //   // Suppose a student "John Doe" exists
  //   given()
  //     .when().get("/graphql?query={studentByName(name:\"John Doe\"){name, age}}")
  //     .then()
  //      .statusCode(200)
  //      .body("data.studentByName.name", is("John Doe"));
  // }

  // @Test
  // public void testDeleteStudent() {
  //   // Suppose a student "John Doe" exists
  //   given()
  //     .when().post("/graphql?mutation={deleteStudent(name:\"John Doe\"){success}}")
  //     .then()
  //      .statusCode(200)
  //      .body("data.deleteStudent.success", is(true));
  // }
}