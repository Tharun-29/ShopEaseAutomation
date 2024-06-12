package TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import PageObjects.LoginPage;
import Resources.ReportGeneration;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage LogPage;
	public ConfigReader configReader;
	
	// Constructor to initialize configReader
    public BaseTest() {
        configReader = new ConfigReader();
    }

	public WebDriver initializeDriver() {
		
		// Initialize configReader
	    

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: configReader.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			opt.addArguments("start-maximized");
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("incognito");
			
			// Check if headless mode is enabled
		    if (browserName.contains("headless")) {
		        opt.addArguments("headless");
		        WebDriverManager.chromedriver().setup();
		    }
			
			driver = new ChromeDriver(opt);
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//FirefoxOptions opt = new FirefoxOptions();
			//opt.addArguments("start-maximized");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("start-maximized");
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("incognito");
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver(opt);
		}

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
