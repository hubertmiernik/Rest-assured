package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BDDStyledMethod {

    public static void SimpleGETEmployee(String employeeNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/employees/%s",employeeNumber)).
                then().body("first_name", is("Sebastian"));

    }

    public static void PerformContainsCollection(){
        given().contentType(ContentType.JSON).
                when()
                .get("http://localhost:3000/employees/")
                .then()
                .body("first_name", containsInAnyOrder("Sebastian", "Steve", "Ann")).statusCode(200);
    }

    //path parameter
    public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON).
        with().
                pathParam("employee", 1).
        when().
                get("http://localhost:3000/employees/{employee}").
        then().
                body("first_name", containsString("Sebastian"));

    }

    //query parameter
    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", "1").
        when()
                .get("http://localhost:3000/employees/").
        then()
                .body("first_name", hasItem("Sebastian"));
    }



}
