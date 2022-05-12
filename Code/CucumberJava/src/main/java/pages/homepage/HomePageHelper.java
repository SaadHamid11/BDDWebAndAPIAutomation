package pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import pages.automobiles.MotorPageHelper;
import utilities.Common;
import utilities.ConfigConstants;

public class HomePageHelper extends DriverFactory  {
	
	
	
	
	private WebElement motorSection = driver.findElement(HomePageConstants.getMotorsLocator());  
	
	
	
	public void navigateHomePage() {
		String url = config.getUrl();
		driver.navigate().to(url);
		
	}
	
	public MotorPageHelper navigateMotorsPage() {
		
		
		Common.clickElement(motorSection);
		String expectedPageTitle = "Cars And Vehicles For Sale | Trade Me Motors";
		boolean isMotorPageDisplayed = Common.waitForTitleUpdate(driver, config, expectedPageTitle);
		if(isMotorPageDisplayed) {
			return new MotorPageHelper();
		}
		
		else
		{
			System.out.println("Motor page is not displayed");
			return null;
		}
		
		
		
		
	}
	
	
	

}
