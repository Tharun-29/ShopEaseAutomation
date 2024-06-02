package TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PageObjects.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
     
	public WebDriver initializeDriver() {
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public LoginPage openApplication() {
		driver = initializeDriver();
		
		LoginPage LogPage = new LoginPage(driver);
		LogPage.openLoginPage();
		return LogPage;
	}
	
	
	
}
