package pages.automobiles;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import factory.DriverFactory;
import pages.searchresults.SearchResultHelper;
import utilities.Common;

public class MotorPageHelper extends DriverFactory {
	
	
	private Select select;
	//Field _ WebElements
	private WebElement usedCarsTab = driver.findElement(MotorPageConstants.getOldMotorsLocator());
	private WebElement keyWordField = driver.findElement(MotorPageConstants.getKeywordsLocator());
	private WebElement makeDropDown = driver.findElement(MotorPageConstants.getMakeDropDownLocator());
	private WebElement modelDropDown;  
	private WebElement bodyTypeField = driver.findElement(MotorPageConstants.getBodyTypeLocator());
	private List<WebElement> bodyTypeOptions;
	private WebElement searchButton = driver.findElement(MotorPageConstants.getSearchButtonLocator());
	private WebElement searchResults;
	
	
	public void clickUsedCarsTab() {
		Common.clickElement(usedCarsTab);
			
	}
	
	
	public void enterKeyword(String keyword) {
		
		Common.sendKeys(keyWordField, Common.refineStringCase(keyword));
	}
	
	public void selectMake(String make) {
		select = new Select(makeDropDown);
		try {
			select.selectByValue(Common.refineStringCase(make));
			
		}
		catch (Exception e) {
			System.out.println("Cannot select given make of a car. Please provide a valid make in Feature file");
		}
		
	}
	
	public void selectModel(String model) {
		modelDropDown = wait.until(ExpectedConditions.elementToBeClickable(MotorPageConstants.getModelDropDownLocator()));
		Common.clickElement(modelDropDown);
		select = new Select(modelDropDown);
		try {
			select.selectByValue(Common.refineStringCase(model));
			
		}
		catch (Exception e) {
			System.out.println("Cannot select given model of a car. Please provide a valid model in Feature file");
		}
		
	}
	
	public void selectBodyType(String bodyType)  {
		Common.clickElement(bodyTypeField);
		bodyTypeOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MotorPageConstants.getBodyTypeDropDown()));
		
		for(int i = 0; i < bodyTypeOptions.size() ; i++) {
			if(bodyTypeOptions.get(i).getText().trim().equalsIgnoreCase(Common.refineStringCase(bodyType))){
				Common.clickElement(bodyTypeOptions.get(i));
				break;
			}
			
			
		}
		
	}
	
	
	public void clickSearchButton() {
		Common.clickElement(searchButton);
	}
	
	public SearchResultHelper searchResultsDisplayed() {
		searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(MotorPageConstants.getSearchResultsContainer()));
		
		return searchResults.isDisplayed() ? new SearchResultHelper() : null; 
	
	}
	
	
	
	
	
	
}
