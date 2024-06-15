package PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

    WebDriver driver;
    Actions builder;

    // Constructor to initialize the driver, PageFactory elements, and Actions class
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        builder = new Actions(driver);
    }

    // Locate all confirmed product names on the overview page
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> confirmedProducts;

    // Locate the finish button
    @FindBy(id = "finish")
    WebElement finishButton;

    // Method to validate the products on the overview page and click the finish button
    public void ValidateOveriewPage(String prod) {
        for (int i = 0; i < confirmedProducts.size(); i++) {
            // Check if the product name contains the specified substring
            if (confirmedProducts.get(i).getText().contains(prod)) {
                assertTrue(true);
            } else {
                assertTrue(false);
            }
        }
        // Move to the finish button and click it
        builder.moveToElement(finishButton);
        builder.click().perform();
    }
}