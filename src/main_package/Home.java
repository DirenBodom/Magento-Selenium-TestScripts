package main_package;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	public void homePageClickTest() {
		this.driver.get(url);
		
		// Click the Luma icon which should take you to the home page
		WebElement LumaIcon = driver.findElement(By.className("logo"));
		LumaIcon.click();
		mu.holdScreen(1000);
	}
	
	
	/////////////////////// Naviation Bar Tests ///////////////////////////////////////////////////
	public void whatsNewLinkTest() {
		this.driver.get(url);
		
		// Click on the What's new link and make sure the page loads correctly
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement linkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		linkButton.click();
		
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
		// Test whether the What's New banner was loaded
		WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base[data-ui-id='page-title-wrapper']")));
		
		// Confirm the correct text messages was loaded
		String bannerText = banner.getText();
		String newText = "What's New";
		assertEquals(bannerText, newText);
		System.out.println("Successfully loaded!!!");
	}
	public void womenMenuTab() {
		// Test clicking on the women tab
		womenTabClickTest();
		
		// Test clicking on the sub-menu item 'tops' works
		topsMenuItemClickTest();
		
		// Test clicking on the sub-menu item 'bottoms' works
		bottomsMenuItemClickTest();
		
		// Test whether clicking on the menu item 'jackets works
		jacketMenuItemClickTest();
	}
	public void womenTabClickTest() {
		driver.get(url);
		// Wait for the element Women tab element to be available then hover over it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		WebElement womenTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4")));
		womenTab.click();
		
		// Test that the page loaded correctly
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
		WebElement womenBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base[data-ui-id=page-title-wrapper]")));
		String womenBannerText = womenBanner.getText();
		String expectedString = "Women";
		
		assertEquals(womenBannerText, expectedString);
		System.out.println("Women page successfully loaded!");
	}
	public void topsMenuItemClickTest() {
		driver.get(url);
		// Wait for the element Women tab element to be available then hover over it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		WebElement womenTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4")));
		Actions action = new Actions(driver);
		action.moveToElement(womenTab).build().perform();
		
		WebElement tops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".level1.nav-2-1.category-item.first.parent.ui-menu-item")));
		tops.click();
		
		// Confirm the page was loaded correctly
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
		WebElement topsBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base[data-ui-id=page-title-wrapper]")));
		String topsBannerText = topsBanner.getText();
		String expectedString = "Tops";
		
		assertEquals(topsBannerText, expectedString);
		System.out.println("Tops page successfully loaded!");
	}
	public void bottomsMenuItemClickTest() {
		driver.get(url);
		// Wait for the element Women tab element to be available then hover over it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		WebElement womenTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4")));
		Actions action = new Actions(driver);
		action.moveToElement(womenTab).build().perform();
		
		WebElement bottoms = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".level1.nav-2-2.category-item.last.parent.ui-menu-item")));
		bottoms.click();
		
		// Confirm the page was loaded correctly
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
		WebElement bottomsBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base[data-ui-id=page-title-wrapper]")));
		String bottomsBannerText = bottomsBanner.getText();
		String expectedString = "Bottoms";
		
		assertEquals(bottomsBannerText, expectedString);
		System.out.println("Bottoms page successfully loaded!");
	}
	public void jacketMenuItemClickTest() {
		driver.get(url);
		
		// Wait for the element Women tab element to be available then hover over it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		WebElement womenTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-4")));
		Actions action = new Actions(driver);
		action.moveToElement(womenTab).build().perform();
		
		WebElement tops = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".level1.nav-2-1.category-item.first.parent.ui-menu-item")));
		action.moveToElement(tops).build().perform();
		
		WebElement jackets = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='level2 nav-2-1-1 category-item first ui-menu-item']")));
		jackets.click();
		
		// Confirm the page was loaded correctly
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
				
		WebElement jacketsBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".base[data-ui-id=page-title-wrapper]")));
		String jacketsBannerText = jacketsBanner.getText();
		String expectedString = "Jackets";
		
		assertEquals(jacketsBannerText, expectedString);
		System.out.println("Jackets page successfully loaded!");		
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
