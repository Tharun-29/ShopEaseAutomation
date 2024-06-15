package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.ConfigReader;

public class ProductPage {
    WebDriver driver;

    // Constructor to initialize the driver and PageFactory elements
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locate all product names on the page
    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> Products;

    // Locate all "Add to cart" buttons for the products
    @FindBy(xpath = "//div[@class='pricebar']//button[text()='Add to cart']")
    List<WebElement> AddCartButton;

    // Locate the checkout icon (shopping cart)
    @FindBy(id = "shopping_cart_container")
    WebElement CheckoutIcon;

    // Method to add specified products to the cart
    public void addProducts(String prod) {
        for (int i = 0; i < Products.size(); i++) {
            String productName = Products.get(i).getText();
            if (productName.contains(prod)) {
                AddCartButton.get(i).click(); // Click the "Add to cart" button for the matching product
            }
        }
    }

    // Method to click the checkout icon and proceed to checkout
    public void checkoutProducts() {
        CheckoutIcon.click();
    }
}
