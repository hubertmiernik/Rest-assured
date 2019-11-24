package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BDDStyledMethod {

    public static void SimpleGETPost(String employeeNumber){
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s",employeeNumber)).
                then().body("author", is("Karthik KK"));

    }

    public static void PerformContainsCollection(){
        given().contentType(ContentType.JSON).
                when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("Karthik KK", "Karthik KK", null)).statusCode(200);
    }

    //path parameter
    public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON).
        with().
                pathParam("post", 1).
        when().
                get("http://localhost:3000/posts/{post}").
        then().
                body("author", containsString("Karthik KK"));

    }

    //query parameter
    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam("id", "1").
        when()
                .get("http://localhost:3000/posts/").
        then()
                .body("author", hasItem("Karthik KK"));
    }

    public static void PerformPOSTWithBodyParameter(){
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("id", "6");
        postContent.put("title", "Test");
        postContent.put("author", "Hubert");

        given()
                .contentType(ContentType.JSON)
        .with()
                .body(postContent).
        when()
                .post("http://localhost:3000/posts/").
        then()
                .body("author", Is.is("Hubert"));




    }





}
