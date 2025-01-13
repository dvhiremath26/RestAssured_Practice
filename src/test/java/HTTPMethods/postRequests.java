package HTTPMethods;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import pojo.pojo_post_requests;


/**
 * PPOST requests using different methods
 * 1. HashMap
 * 2. org.json liberary
 * 3. POJO class
 * 4. external json file
 */

public class postRequests {


    /* POST Request by using HashMap */
    @Test
    public void postRequest_01() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "deepak");
        data.put("job", "tetsing");

        given().contentType("application/json").body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }

    /* POST Request by using org.json liberary */
    @Test
    public void postRequest_02() {
        JSONObject data = new JSONObject();
        data.put("name", "John");
        data.put("job", "Tetsing");

        given()
            .contentType("application/json")
            .body(data.toString())
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }


        /* POST Request by using POJO class */
        @Test
        public void postRequest_03() {
            pojo_post_requests data = new pojo_post_requests();
            data.setName("Peter");
            data.setJob("Manual Tetsing");
    
            given()
                .contentType("application/json")
                .body(data)
            .when()
                .post("https://reqres.in/api/users")
            .then()
                .statusCode(201)
                .log().all();
        }


        /* POST Request by using external json file */
        @Test
        public void postRequest_04() throws FileNotFoundException {
            File jsonFile = new File("./testData/postData.json");
            FileReader reader = new FileReader(jsonFile);
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject data = new JSONObject(tokener);
    
            given()
                .contentType("application/json")
                .body(data.toString())
            .when()
                .post("https://reqres.in/api/users")
            .then()
                .statusCode(201)
                .log().all();
        }


}
