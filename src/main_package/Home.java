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
	public void signInOpenTest() {
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
}
