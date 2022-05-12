package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BrowserEnum;
import utilities.ConfigConstants;

public class DriverFactory {
	//Fields
	protected static WebDriver driver;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	protected ConfigConstants config = new ConfigConstants();
	protected static WebDriverWait wait;
	
	//Initialize Browser and Driver Instance
	public WebDriver initializeDriver(String browser) {
		if(browser.isEmpty()){
			System.out.println("Please provide a valid browser name in config.properties file");
			return null;
		}
		else
		
		{
			//Launch Chrome Browser
			if(browser.equals(BrowserEnum.chrome.toString())) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
				
			}
			//Launch Firefox Browser
			else if (browser.equals(BrowserEnum.firefox.toString())) {
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
			}
			
			else {
				System.out.println("Please provide valid browser information in config.properties file. Available options are chrome and firefox only");
			}
			
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			
			
			driver = getDriver();
			
			//Initialized Explicit WebDriverWait instance
			wait = new WebDriverWait(driver, config.getExplicitWaitTime());
			return driver;
			
			
		}
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	

}
