package stepdefinitions.WebUI;


import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.automobiles.MotorPageHelper;
import pages.homepage.HomePageHelper;
import pages.searchresults.SearchResultHelper;
import utilities.ConfigConstants;


public class SearchOldCarSteps {
	
	private static HomePageHelper homePage ;
	private static MotorPageHelper motorPage ; 
	private static SearchResultHelper searchResults;
	private ConfigConstants config = new ConfigConstants();
	
	
	public SearchOldCarSteps() {
		
	}
	
	@Given("user navigates to automobiles section from home page")
	public void user_navigates_to_automobiles_section_from_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   DriverFactory.getDriver().get(config.getUrl());
	   homePage = new HomePageHelper();
	   motorPage = homePage.navigateMotorsPage();
	   
	   
	}

	@When("user select old cars tab")
	public void user_select_old_cars_tab() {
	    // Write code here that turns the phrase above into concrete actions
	    motorPage.clickUsedCarsTab();
	}

	

	@And("user enters {string} in keyword field")
	public void user_enters_in_keyword_field(String keyword) {
	    // Write code here that turns the phrase above into concrete actions
	   motorPage.enterKeyword(keyword.toUpperCase());
	}

	@And("user selects {string} from make dropdown")
	public void user_selects_from_make_dropdown(String make) {
	    // Write code here that turns the phrase above into concrete actions
	    motorPage.selectMake(make);
	}

	@And("user selects {string} from model dropdown")
	public void user_selects_from_model_dropdown(String model) {
	    // Write code here that turns the phrase above into concrete actions
	    motorPage.selectModel(model);
	}

	@And("user select {string} from Body Style dropdown")
	public void user_select_from_body_style_dropdown(String bodyStyle) {
	    // Write code here that turns the phrase above into concrete actions
	    
			motorPage.selectBodyType(bodyStyle);
		
	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    motorPage.clickSearchButton();
	}

	@Then("search results are displayed")
	public void search_results_are_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    searchResults = motorPage.searchResultsDisplayed();
	    if(searchResults != null) {
	    	Assert.assertTrue(true);
	    }
	    else {
	    	Assert.assertTrue(false);
	    }
	}

	@When("user clicks on a search result containing {string} value")
	public void user_clicks_on_a_search_result_containing_value(String model) {
	    // Write code here that turns the phrase above into concrete actions
	    if(searchResults != null) {
	    	searchResults.selectCar(model);
	    }
	    	
	    
	}
	
	@Then("old car details page is displayed")
	public void old_car_details_page_is_displayed() {
		 
			Assert.assertTrue(searchResults.searchedCarPageDisplayed());
		
		
	}

	@And("{string} information is displayed correctly for number plates")
	public void information_is_displayed_correctly_for_number_plates(String numberPlate) {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertTrue(searchResults.verifyFilterAvailable(numberPlate.toUpperCase()));
	}

	@And("{string} information is displayed correctly for kilometers")
	public void information_is_displayed_correctly_for_kilometers(String kilometers) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(searchResults.verifyFilterAvailable(kilometers));
	
	}

	@And("{string} information is displayed correctly for car body")
	public void information_is_displayed_correctly_for_car_body(String body) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(searchResults.verifyFilterAvailable(body));
	}

	@And("{string} information is displayed correctly for seats")
	public void information_is_displayed_correctly_for_seats(String seats) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(searchResults.verifyFilterAvailable(seats));
	}


}
