package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {
    WebDriver driver;
    Actions builder;

    // Constructor to initialize the driver, PageFactory elements, and Actions class
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        builder = new Actions(driver);
    }

    // Locate all products listed on the checkout page
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> CheckoutProducts;

    // Locate the checkout button
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    // Locate all remove buttons for the products
    @FindBy(xpath = "//button[text()='Remove']")
    List<WebElement> removeButton;

    // Method to validate that specified products are in the checkout list
    public void ValidateProducts(String prod) {
        for (int i = 0; i < CheckoutProducts.size(); i++) {
            if (CheckoutProducts.get(i).getText().contains(prod)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    // Method to remove specified products from the checkout list
    public void removeProduct(String prod) {
        for (int i = 0; i < CheckoutProducts.size(); i++) {
            if (CheckoutProducts.get(i).getText().contains(prod)) {
                removeButton.get(i).click();
            }
        }
    }

    // Method to perform the checkout action
    public void CheckoutOrder() {
        builder.moveToElement(checkoutButton);
        builder.click();
        builder.perform();
    }
}