package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension(){
        //arangea
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String url) {
        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void GetOps(String url) throws URISyntaxException {
//        Request.get(new URI(url));
//    }

}
