package TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage LogPage;
     
	public WebDriver initializeDriver() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.setAcceptInsecureCerts(true);
		opt.addArguments("incognito");
		driver = new ChromeDriver(opt);
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage OpenApplication() {
		driver = initializeDriver();
		
		LogPage = new LoginPage(driver);
		return LogPage;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
}
