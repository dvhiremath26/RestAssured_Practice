package HTTPMethods;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import pojo.pojo_post_requests;

public class deleteRequests {

    int id;

    @BeforeTest
    public void postRequest_04() throws FileNotFoundException {
        pojo_post_requests data = new pojo_post_requests();
        data.setName("Rambo");
        data.setJob("Testing");

        Response response = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all()
            .extract().response();
        
        id = response.jsonPath().getInt("id");
    }

    /*******************************************************************************/

    /* DELETE Request */
    @Test
    public void deleteRequest() {    
        given()
        .when()
            .delete("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(204)
            .log().all();
    }
    
}
