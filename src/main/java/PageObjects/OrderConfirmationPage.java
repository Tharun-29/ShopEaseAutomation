package PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

	WebDriver driver;
    
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	 
	 @FindBy(xpath = "//h2")
	 WebElement confirmationMessage;
	 
	 public void ValidateOrderConfirmation() {
		 assertEquals(confirmationMessage.getText(), "Thank you for your order!");
	 }
	 
}
