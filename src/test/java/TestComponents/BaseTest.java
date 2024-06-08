package TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LoginPage;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage LogPage;
	public ConfigReader configReader;
     
	public WebDriver initializeDriver() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.setAcceptInsecureCerts(true);
		opt.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		
		int implicitWait = Integer.parseInt(configReader.getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage OpenApplication() {
		configReader = new ConfigReader();
		driver = initializeDriver();
		driver.get(configReader.getProperty("baseURL"));
		
		
		LogPage = new LoginPage(driver);
		return LogPage;
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		if (driver != null) {
			driver.quit();
		}
	}
	
	

	// Screenshot Method
	public String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";
	}
	
	
}
