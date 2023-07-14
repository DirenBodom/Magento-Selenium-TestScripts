package main_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Home {
	private WebDriver driver;
	MagentoUtils mu = new MagentoUtils();
	String url = mu.BASE_URL;
	
	public Home(WebDriver d) {
		driver = d;
	}
	public void signInLinkTest() {
		this.driver.get(url);
		mu.holdScreen(1000);
		
		// Click on the Sign-in link
		WebElement signInLink = driver.findElement(By.className("authorization-link"));
		signInLink.click();
		mu.holdScreen(1000);
		
		// Check if the Sign-In page successfully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		System.out.println("Sign-in page loaded successfully!");
	}
	public void createAccountLinkTest() {
		this.driver.get(url);
		
		// Find and click Create an account link (Link does not have any Id nor class)
		WebElement createAccountLink = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a"));
		createAccountLink.click();
		mu.holdScreen(1000);
		
		// Test whether the create account page loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		System.out.println("Create account page loaded successfully!");
	}
	/**
	 * Runs every test from the Home page
	 */
	public void runAllTests() {
		// Test clicking on Sign-in link
		this.signInLinkTest();
		
		// Test clicking on Create account link
		this.createAccountLinkTest();
	}
}
