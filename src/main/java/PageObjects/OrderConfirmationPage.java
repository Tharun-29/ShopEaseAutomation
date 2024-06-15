package PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    WebDriver driver;

    // Constructor to initialize the driver and PageFactory elements
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locate the order confirmation message element
    @FindBy(xpath = "//h2")
    WebElement confirmationMessage;

    // Method to validate the order confirmation message
    public void ValidateOrderConfirmation() {
        // Assert that the confirmation message text is "Thank you for your order!"
        assertEquals(confirmationMessage.getText(), "Thank you for your order!");
    }
}