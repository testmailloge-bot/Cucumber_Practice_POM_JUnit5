package Step_Definition;

import Base.BaseClass;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest extends BaseClass {

	LoginPage login_obj;

	@When("Enter the username")
	public void enter_the_username() {
		login_obj = new LoginPage(getDriver());
		login_obj.enter_username("Admin");
	}

	@When("Enter the Password")
	public void enter_the_password() {
		login_obj.enter_password("admin123");
	}

	@When("Click the login button")
	public void click_the_login_button() {
		login_obj.click_login_button();
	}

	@Then("Veify the login status")
	public void veify_the_login_status() {
		DashboardPage dashboard_obj = new DashboardPage(getDriver());
		dashboard_obj.verify_login();

		System.out.println("Login verification completed successfully");
		throw new AssertionError("Intentional failure for Jenkins practice");

	}

}
