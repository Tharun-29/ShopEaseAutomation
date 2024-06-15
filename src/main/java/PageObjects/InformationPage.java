package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
    WebDriver driver; // WebDriver instance for interacting with the browser
    Actions builder; // Actions instance for performing advanced interactions

    // Constructor to initialize WebDriver, PageFactory, and Actions
    public InformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
        builder = new Actions(driver); // Initialize Actions with WebDriver instance
    }

    // WebElement declarations using @FindBy annotation
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    // Method to submit user information
    public void UserInformationSubmission(String FirstName, String LastName, String PostalCode) {
        firstName.sendKeys(FirstName); // Enter first name in the input field
        lastName.sendKeys(LastName); // Enter last name in the input field
        postCode.sendKeys(PostalCode); // Enter postal code in the input field

        builder.moveToElement(continueButton); // Move the mouse cursor to the 'Continue' button
        builder.click().perform(); // Click the 'Continue' button using Actions
    }
}