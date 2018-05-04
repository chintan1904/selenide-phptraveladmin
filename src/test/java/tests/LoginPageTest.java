package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import pages.LoginPage;
import tests.common.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@BeforeClass
	public void setup() {

		Configuration.baseUrl = "https://www.phptravels.net/admin";
		ScreenShooter.captureSuccessfulTests = true;
	}
	
	@Test
	public void LoginFail_InvalidEmailFormat() {
		
		LoginPage login = new LoginPage();
		login.open()
		.enter_email("ff")
		.enter_password("Test")
		.click_submit_invalid()
		.verify_error_message("The Email field must contain a valid email address");
	}
	
	@Test
	public void LoginFail_EmailNotPresent() {
		
		LoginPage login = new LoginPage();
		login.open()
		.enter_email("abc@testmail.com")
		.enter_password("Test")
		.click_submit_invalid()
		.verify_error_message("Invalid Login Credentials");
	}

	@Test
	public void LoginFail_InvalidPassword() {
		
		LoginPage login = new LoginPage();
		login.open()
		.enter_email("admin@phptravels.com")
		.enter_password("Test")
		.click_submit_invalid()
		.verify_error_message("Invalid Login Credentials");
	}
}
