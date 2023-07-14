package main_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

	public static void main(String[] args) {
		// Sets the location of the Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\chromedriver_win32\\chromedriver.exe");
								
		// Create a new instance of the Chrome driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);	
		
		// Run tests for Home page
		Home home = new Home(driver);
		home.runAllTests();
		
		driver.close();
	}
}
