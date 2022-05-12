package utilities;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import Pojo.CharitiesList;
import io.cucumber.java.Scenario;

public class Common {
	
	/*
	 * 
	 * Common class is static Utility to provides common functionalities, to be used across framework. 
	 * 
	 */
	
	private static WebDriverWait wait;
	
	
	private Common() {
		//Private constructor to restrict initialization of Common class
	}
	
	public static void TakeScreenShot(WebDriver driver, Scenario scenario) {
		try {
			String ScreenshotName = scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);
		}
		catch(Exception e) {
			System.out.println("Failed to take screenshot due to "+e.getStackTrace());
		}
		
	}
	
	
	public static void clickElement( WebElement element) {
		if(element.isDisplayed()) {
			element.click();
		}
		else {
			System.out.println("Element is not displayed on page");
		}
	}
	
	public static void sendKeys(WebElement element, String text) {
		if(element != null && text != null) {
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}
	
	
	public static  boolean waitForTitleUpdate(WebDriver driver, ConfigConstants config, String expectedTitle) {
		wait = new WebDriverWait(driver, config.getExplicitWaitTime() );
		boolean isPageChanged = wait.until(ExpectedConditions.titleContains(expectedTitle));
		
		return isPageChanged;
	}
	
	
	
	public static String getRequiredString(String word) {
		if(word.contains(":")) {
			String[] wordArray = word.split(":");
			return wordArray[1].toString().trim();
			
		}
		else {
			return word.trim();
		}
		
		
		
	}
	public static String refineStringCase(String word) {
		String refinedCase = "";
		if(word.length() > 0 && word != null ) {
			String firstLetter = word.substring(0,1).toUpperCase();
			String remainingLetters = word.substring(1).toLowerCase();

			refinedCase = firstLetter + remainingLetters ;
			
		}
		
		
		return refinedCase;
	}
	
	
	
	
	
	
	
	
	
	
	

}
