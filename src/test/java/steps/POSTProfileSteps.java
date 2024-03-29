package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class POSTProfileSteps {

    private static ResponseOptions<Response> response;


    @Given("^I perform POST operation for \"([^\"]*)\"$")
    public void iPerformPOSTOperationFor(String arg0) {
        BDDStyledMethod.PerformPOSTWithBodyParameter();
    }

    @Given("^I Perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url) {

        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("name", "Sams");

        //set params
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("profileNo", "2");

        //Perform post operation
        response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParams, body);

    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String name) {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
    }



//    @Given("I ensure to Perform POST operation for {string} with body as")
//    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url) {
//        //set body
//        HashMap<String, String> body = new HashMap<>();
//        body.put("id", "12");
//        body.put("title", "API Testing course");
//        body.put("author", "ExecuteAutomation");
//
//        //perform post operation
//        response = RestAssuredExtension.PostOpsWithBody(url, body);
//    }

    @Given("I ensure to Perform POST operation for {string} with body as id = {string}, title = {string} and author = {string}")
    public void iEnsureToPerformPOSTOperationForWithBodyAsIdTitleAndAuthor(String url, String id, String title, String author) {
        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("id", id);
        body.put("title", title);
        body.put("author", author);

        //perform post operation
        response = RestAssuredExtension.PostOpsWithBody(url, body);
    }

    @And("I Perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url) {

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", "12");

       RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
    }

    @And("I perform GET operation with path parameter for {string}")
    public void iPerformGETOperationWithPathParameterFor(String url)
    {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", "12");

        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
    }


    //new
    @And("I perform GET operation for {string} new")
    public void iPerformGETOperationForNew(String url) {
        response = RestAssuredExtension.GetOps(url);
    }



    @Then("I should see the body with title as {string}")
    public void iShouldSeeTheBodyWithTitleAs(String title) {
        assertThat(response.getBody().jsonPath().get("title"), hasItem(title));

    }


    @And("I Perform PUT operation for {string}")
    public void iPerformPUTOperationFor(String url) {

        Map<String, String> body = new HashMap<>();
        body.put("id", "12");
        body.put("title", "API Testing course");
        body.put("author", "Hubert");

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", "12");

        RestAssuredExtension.PutOpsWithBodyAndPathParams(url, body, pathParams);

    }


    @Then("I shouldn't see the body with title as {string}")
    public void iShouldnTSeeTheBodyWithTitleAs(String title) {
        assertThat(response.getBody().jsonPath().get("title"), not(hasItem(title)));

    }
}




