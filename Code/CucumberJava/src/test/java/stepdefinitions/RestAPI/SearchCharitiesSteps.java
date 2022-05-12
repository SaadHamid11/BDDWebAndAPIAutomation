package stepdefinitions.RestAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import utilities.ConfigConstants;
import  utilities.APIHelpers.DeSerialization.CharityListHelper;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class SearchCharitiesSteps {
	//region fields
	private ValidatableResponse  validateResponse ;
	private ConfigConstants config = new ConfigConstants();
	private  ArrayList<String> listOfCharities;
	
	//endregion
	
	
	
	//region stepdefinitionMethods
	
	@Given("user set TradeMe sandbox API URI")
	public void user_set_trade_me_sandbox_api_URI() {
	    // Write code here that turns the phrase above into concrete actions
		
		RestAssured.baseURI = config.getAPIURI();
	    
	}

	@When("user send {string}  http request on {string}")
	public void user_set_request_header_as(String request, String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	     
		if(request.trim().equalsIgnoreCase("Get")) {
			validateResponse = when().get(endpoint).then();
		}
		
	}

	

	@Then("user recieves valid response code as {string}")
	public void user_recieves_valid_response_code_as(String statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		validateResponse = validateResponse.assertThat().statusCode(Integer.parseInt(statusCode)).and();
	}

	@And("List of charities are displayed")
	public void list_of_charities_are_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    String response = validateResponse.extract().asPrettyString();
	    try {
			listOfCharities = CharityListHelper.getDescriptionList(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			System.out.println("No List generated due to "+e.getMessage());
		}
	    
	    
	    if(listOfCharities.size() > 0) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.fail("No Charities available");
	    }
	    
	    
	}

	@And("List contains {string} in Description")
	public void list_contains_in_description(String charityName) {
	    // Write code here that turns the phrase above into concrete actions
	    if(charityName != null) {
	    	
	    	Assert.assertTrue(listOfCharities.contains(charityName));
	    }
	    
		
	}
	
	//endregion
}
