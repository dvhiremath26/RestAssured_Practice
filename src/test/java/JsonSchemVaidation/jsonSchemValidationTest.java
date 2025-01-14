package JsonSchemVaidation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;


public class jsonSchemValidationTest {

    /** https://restful-api.dev/ */
    @Test
    public void jsonSchemaValidation() {
        given()
        .when()
            .get("https://api.restful-api.dev/objects/7")
        .then()
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
    }
    
}
