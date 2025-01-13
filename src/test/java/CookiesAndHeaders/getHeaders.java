package CookiesAndHeaders;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getHeaders {

    /** Print all Headers */
    @Test
    public void getHeadersRequest() {
        Response response = 
            given()
            .when()
                .get("https://google.com");
                
        // Return type of getHeaders() is Headers
        // getName() and getValue() are methods of Header class
        response.getHeaders() 
            .forEach((header) -> System.out.println(header.getName() + " : " + header.getValue()));
            
    }

    /** Validate specific Header */
    @Test
    public void getHeaderRequest() {
            given()
            .when()
                .get("https://google.com")
            .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .and()
                .header("Server", "gws"); 

    }
    
}
