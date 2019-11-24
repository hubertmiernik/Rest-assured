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
        builder.setBaseUri("http://localhost:3000/");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> GetOpsWithPathParameter(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> GetOps(String url) {
        return Request.get(url);
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body) {
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,Map<String, String> pathParams)  {
        //Request.pathParams(pathParams);
        Request.pathParams("postid", "12");
        return Request.delete(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        return Request.get(url);
    }



}
