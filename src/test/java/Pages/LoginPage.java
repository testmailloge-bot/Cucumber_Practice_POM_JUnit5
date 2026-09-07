package Pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username_locator;

	@FindBy(name = "password")
	WebElement password_locator;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login_button_locator;

	public void enter_username(String username_data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(username_locator)).sendKeys(username_data);
	}

	public void enter_password(String password_data) {
		password_locator.sendKeys(password_data);
	}

	public void click_login_button() {
		login_button_locator.click();
	}
}