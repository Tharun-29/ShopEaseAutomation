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
	
	@FindBy(id = "react-burger-menu-btn")
	WebElement menu;
	
	@FindBy(id = "logout_sidebar_link")
	WebElement LogoutOption;
	
	@FindBy(xpath = "//h3[@data-test=\"error\"]")
	WebElement errorMessage;

	public void OpenLoginPage(String baserURL) {
		driver.get(baserURL);
	}
	
	public void LoginToApplication(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
	}
	
	public void LogoutFromApplication() {
		menu.click();
		LogoutOption.click();
	}
	
	public String getErrorMessage() {
        return errorMessage.getText();
    }

}
