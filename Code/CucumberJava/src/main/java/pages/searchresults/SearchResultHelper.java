package pages.searchresults;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import factory.DriverFactory;

import utilities.Common;

public class SearchResultHelper extends DriverFactory {

	private List<WebElement> carTitles;
	private List<WebElement> searchFilters;
	

	public void selectCar(String carName) {
		carTitles = driver.findElements(SearchResultConstants.getCarTitlesLocator());
		for (int i = 0; i < carTitles.size(); i++) {
			if (carTitles.get(i).getText().trim().contains(Common.refineStringCase(carName))) {
				Common.clickElement(carTitles.get(i));
				break;
			}
		}

	}

	public boolean searchedCarPageDisplayed()  {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SearchResultConstants.getSearchedCarTitle()))
				.isDisplayed();
		

	}
	
	
	public boolean verifyFilterAvailable(String filter) {
		boolean isFilterAvailable = false;
		searchFilters = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SearchResultConstants.getSearchFiltersLocator()));
		List<String> filterList = new ArrayList<String>(); 
		
		for(int i = 0 ; i < searchFilters.size() ; i++) {
			String filterName = Common.getRequiredString(searchFilters.get(i).getText().trim());
			
			filterList.add(filterName);
		}
		
		if(filterList.contains(filter.trim())) {
			isFilterAvailable = true;
		}
		
		return isFilterAvailable;
	}
	
	
	

}
