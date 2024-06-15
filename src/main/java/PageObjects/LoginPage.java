package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	// Constructor to initialize the driver and PageFactory elements
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	// Locate the username input field
	@FindBy(id = "user-name")
	WebElement Username;
	
	// Locate the password input field
	@FindBy(id = "password")
	WebElement Password;
    
	// Locate the login button
	@FindBy(id = "login-button")
	WebElement LoginButton;
	
	// Locate the menu button (for logout)
	@FindBy(id = "react-burger-menu-btn")
	WebElement menu;
	
	// Locate the logout option
	@FindBy(id = "logout_sidebar_link")
	WebElement LogoutOption;
	
	// Locate the error message element
	@FindBy(xpath = "//h3[@data-test=\"error\"]")
	WebElement errorMessage;
	
	// Method to open the login page with the given base URL
	public void OpenLoginPage(String baserURL) {
		driver.get(baserURL);
	}
	
	// Method to log in to the application with given username and password
	public void LoginToApplication(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
	}
	
	// Method to log out from the application
	public void LogoutFromApplication() {
		menu.click();
		LogoutOption.click();
	}
	
	// Method to get the error message text
	public String getErrorMessage() {
        return errorMessage.getText();
    }

}
