package stepdefinitions.RestAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import utilities.APIHelpers.Serialization.SellingListHelper;

public class CreateListingSteps {
	
	//region fields
	
	private  ResponseSpecification specification ;
	private  String response = "";
	private  String listingId = "";
	private  Response responseData;
	//endregion
	
	
	//region stepDefinitionMethods
	@Given("user provides valid {string},{string},{string}, {string} with {string} and body")
	public void user_provides_valid_eb8ee51d8c6c668fdfca281c940b7288_and_with(String consumerKey, String consumerSecret, String accessToken, String tokenSecret, String requestType) {
	    // Write code here that turns the phrase above into concrete actions
		//System.setProperty("https.protocols", "TLSv1.1");
		String payload = SellingListHelper.getPayload();
		
		
		specification = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
		.header("Content-type",requestType).queryParam("Duration", 10).body(payload).then();
	    
	}
	
	@When("user sends post request on {string}")
	public void user_sends_post_request_on( String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    	responseData =  specification.when().post(endpoint).andReturn();
	    
	}
	@Then("API responds with {int}")
	public void api_responds_with(int statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		
		response = responseData.then().assertThat().statusCode(statusCode).extract().response().asPrettyString();
		
		System.out.println(response);		
	}
	
	
	@And("user gets success message and listing id")
	public void user_gets_success_message_and_listing_id() {
	    // Write code here that turns the phrase above into concrete actions
		JsonPath js = new JsonPath(response);
		listingId = js.getString("ListingId");
		String description = js.getString("Description");
		
		String expectedMessage = "ListingId "+listingId.toString()+" created.";
		Assert.assertEquals(expectedMessage, description);
		
	}
	
	//Commented below code as Selling/Listing API doesn't responds correctly with provided listing ID on sandbox environment. 
/*
 *

	@When("user provides valid {string},{string},{string}, {string} with listing id as query parameter")
	public void user_provides_valid_with_listing_id_as_query_parameter(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
	    // Write code here that turns the phrase above into concrete actions
	    specification = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
	    .queryParam("listingId", listingId).then();
	}

	@And("user sends Get request on {string}")
	public void user_sends_get_request_on(String listingEndPoint) {
	    // Write code here that turns the phrase above into concrete actions
	    responseData = specification.when().post(listingEndPoint);
	}

	@Then("Api responds with {int}")
	public void api_responds_with(Integer statusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    responseData.then().assertThat().statusCode(statusCode);
	}
	
	*/
	//endregion
}
