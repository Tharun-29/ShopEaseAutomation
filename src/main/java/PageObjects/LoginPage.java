package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "login-button")
	WebElement LoginButton;

	public void openLoginPage() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public void LoginToApplication() {
		Username.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		LoginButton.click();
	}

}
