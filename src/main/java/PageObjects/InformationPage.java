package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
	WebDriver driver;
	Actions builder;
	
	public InformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		builder = new Actions(driver);
	}
	
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement postCode;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public void UserInformationSubmission(String FirstName, String LastName,String PostalCode) {
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		postCode.sendKeys(PostalCode);
	  
		builder.moveToElement(continueButton);
		builder.click().perform();
		
	}
	
}
