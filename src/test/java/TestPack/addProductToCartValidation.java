package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class addProductToCartValidation extends BaseTest {
    
    // Test method to verify adding a product to the cart functionality
    @Test
    public void verifyProductAdditionToCart() {
        // Open the login page of the application
        LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
        
        // Perform login using provided credentials
        LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));
        
        // Instantiate ProductPage object using WebDriver instance
        ProductPage pg = new ProductPage(driver);
        
        // Add a specified product to the cart
        pg.addProducts(configReader.getProperty("product1"));
        
        // Proceed to checkout from the product page
        pg.checkoutProducts();
        
        // Instantiate CheckoutPage object using WebDriver instance
        CheckoutPage cp = new CheckoutPage(driver);
        
        // Validate that the specified product is in the checkout page
        cp.ValidateProducts(configReader.getProperty("product1"));
    }
}