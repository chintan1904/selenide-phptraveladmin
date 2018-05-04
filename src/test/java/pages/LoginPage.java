package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;

public class LoginPage {
	
	public LoginPage open() {
		Selenide.open("/");
		return this;
	}
	
	public LoginPage enter_email(String email) {
		$(By.name("email")).setValue(email);
		return this;
	}
	
	public LoginPage enter_password(String password) {
		$(By.name("password")).setValue(password);
		return this;
	}
	
	private void click_submit() {
		$(byText("Login")).click();
	}
	
	public LoginPage click_submit_invalid() {
		click_submit();
		return this;
	}
	
	public LoginPage verify_error_message(String errorMsg) {
		
		$(".resultlogin div")
		.should(exist)
		.shouldBe(visible)
		.shouldHave(text(errorMsg));
		return this;
	}
	
	

}
