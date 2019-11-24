package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredExtension {

    private static RequestSpecification buildRequester() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000/");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        return RestAssured.given().spec(requestSpec);
    }


    public static ResponseOptions<Response> GetOpsWithPathParameter(String url, Map<String, String> pathParams){
        return  buildRequester()
                .pathParams(pathParams)
                .get(url);
    }

    public static ResponseOptions<Response> GetOps(String url) {
        return  buildRequester()
                .get(url);
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {
        return buildRequester()
                .pathParams(pathParams)
                .body(body)
                .post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body) {
        return buildRequester()
                .body(body)
                .post(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,Map<String, String> pathParams)  {
        return buildRequester()
                .pathParams(pathParams)
                .delete(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String, String> pathParams){
        return buildRequester()
                .pathParams(pathParams)
                .get(url);
    }

    public static ResponseOptions<Response> PutOpsWithBodyAndPathParams(String url, Map<String, String> body, Map<String, String> pathParams) {
        return buildRequester()
                .pathParams(pathParams)
                .body(body)
                .put(url);
    }



}
