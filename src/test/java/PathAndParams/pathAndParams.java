package PathAndParams;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class pathAndParams {

    /** Path and Query params example.
     * URI: https://reqres.in/api/users?page=2
     * path: "users"
     * queryParam: page = 2
     */
    @Test
    public void pathAndQueryParams() {
        given()
            .pathParam("myPath", "users")
            .queryParam("page", 2)
        .when().get("https://reqres.in/api/{myPath}")
        .then().statusCode(200)
            .log().all();
    }
    
}
