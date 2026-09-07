package Pages;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class DashboardPage extends BaseClass{
	
private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboard_page_heading_locator;

	public void verify_login() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean enabled = wait.until(ExpectedConditions.visibilityOf(dashboard_page_heading_locator)).isDisplayed();
		
			Assertions.assertTrue(enabled);
			System.out.println("The User is successfully logged in");
		
			//System.err.println("The User is not logged in due to invalid credentials");
		
	}
}
