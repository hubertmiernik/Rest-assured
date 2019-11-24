package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetPostSteps {

    private static ResponseOptions<Response> response;


    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the author as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorAs(String author) {
        assertThat(response.getBody().jsonPath().get("author"), hasItem(author));
    }

    @Then("I should see the posts authors")
    public void iShouldSeeThePostsAuthors() {
        BDDStyledMethod.PerformContainsCollection();
    }

    @Then("I should see verify GET Parameter")
    public void iShouldSeeVerifyGETParameter() {
        BDDStyledMethod.PerformQueryParameter();
    }

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


}
