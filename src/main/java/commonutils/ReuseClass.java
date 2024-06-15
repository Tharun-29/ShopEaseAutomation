package commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReuseClass {
    public WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public ReuseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    // WebElement representing the homepage name element
    @FindBy(css = "div[class='app_logo']")
    WebElement HomePageName;

    // Method to get the homepage name and assert its value
    public void getHomePageName() {
        String HomePage = HomePageName.getText(); // Get text of the homepage name element
        Assert.assertEquals(HomePage, "Swag Labs"); // Assert that the homepage name matches "Swag Labs"
    }
}