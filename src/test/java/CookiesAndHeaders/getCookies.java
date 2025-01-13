package CookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class getCookies {

    @Test
    public void getCookiesRequest() {
        Response response = given()
            .when()
                .get("https://google.com");

        response.getCookies()
            .forEach((key, value) -> System.out.println(key + " : " + value));
    }
    
}
