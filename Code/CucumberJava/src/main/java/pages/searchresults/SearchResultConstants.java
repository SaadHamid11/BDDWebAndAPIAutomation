package pages.searchresults;

import org.openqa.selenium.By;

public class SearchResultConstants {
	
	
	private static By carTitlesLocator = By.xpath(".//div[@tmid='title']");
	private static By searchedCarTitle = By.xpath("//h1[@class='tm-motors-listing__title']");
	private static By searchFiltersLocator = By.xpath(".//span[@class='o-tag__content']/div");
	
	public static By getCarTitlesLocator() {
		return carTitlesLocator;
	}
	
	
	public static By getSearchedCarTitle() {
		return searchedCarTitle;
	}
	
	public static By getSearchFiltersLocator() {
		return searchFiltersLocator;
	}

}
