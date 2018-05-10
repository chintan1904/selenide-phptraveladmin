package tests.common;


import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;

@Listeners({ScreenShooter.class})
public class BaseTest {
	
	public RemoteWebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setBrowserEnvironment(String browser) throws MalformedURLException {
		driver = Browser.getRemoteDriver(browser);
		WebDriverRunner.setWebDriver(driver);
	}
	
	@AfterTest
	public void destroyBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	
//	@BeforeTest
//	@Parameters({"browser"})
//	public void setBrowserEnvironment(String browser) throws MalformedURLException {
//		
//		if("chrome".equalsIgnoreCase(browser)) 
//			System.setProperty("selenide.browser", "chrome");
//	}
}
