package commonutils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ReuseClass {
	public WebDriver driver;
	
	public ReuseClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='app_logo']")
	WebElement HomePageName;
	
	public void getHomePageName() {
		String HomePage = HomePageName.getText();
		Assert.assertEquals(HomePage, "Swag Labs");
	}
	 
}
