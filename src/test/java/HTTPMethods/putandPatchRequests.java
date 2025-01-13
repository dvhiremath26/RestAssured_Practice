package HTTPMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojo.pojo_post_requests;

public class putandPatchRequests {

    int id;

    /* POST Request by using external json file */
    @BeforeTest
    public void postRequest_04() throws FileNotFoundException {
        File jsonFile = new File("./testData/postData02.json");
        FileReader reader = new FileReader(jsonFile);
        JSONTokener tokener = new JSONTokener(reader);
        JSONObject data = new JSONObject(tokener);

        Response response = given()
            .contentType("application/json")
            .body(data.toString())
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all()
            .extract().response();
        
        id = response.jsonPath().getInt("id");
    }

    /*******************************************************************************/

    /* PUT Request by using external POJO class */
    @Test
    public void putRequest() throws FileNotFoundException {    
        pojo_post_requests data = new pojo_post_requests();
        data.setName("Ram");
        data.setJob("Testing");
        given()
            .contentType("application/json")
            .body(data)
        .when()
            .put("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200)
            .body("name", equalTo("Ram"))
            .log().all();
    }

    /* PATCH Request by using external POJO class */
    @Test
    public void patchRequest() throws FileNotFoundException {    
        pojo_post_requests data = new pojo_post_requests();
        data.setName("Sani");
        given()
            .contentType("application/json")
            .body(data)
        .when()
            .patch("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200)
            .body("name", equalTo("Sani"))
            .log().all();
    }
}
