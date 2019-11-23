package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetPostSteps {

    private static ResponseOptions<Response> response;


    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the first_name as \"([^\"]*)\"$")
    public void iShouldSeeTheFirst_nameAs(String firstName) throws Throwable {
        assertThat(response.getBody().jsonPath().get("first_name"), hasItem(firstName));
    }

    @Then("I should see the employees names")
    public void iShouldSeeTheEmployeesNames() {
        BDDStyledMethod.PerformContainsCollection();
    }

    @Then("I should see verify GET Parameter")
    public void iShouldSeeVerifyGETParameter() {
        BDDStyledMethod.PerformQueryParameter();
    }
}
