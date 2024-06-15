package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class removeProductToCartValidation extends BaseTest {
    
    // Test method to verify product removal from cart functionality
    @Test
    public void verifyProductRemovalfromCart() {
        // Step 1: Open the login page of the application
        LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
        
        // Step 2: Perform login using valid credentials
        LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));

        // Step 3: Add products to the cart
        ProductPage pg = new ProductPage(driver);
        pg.addProducts(configReader.getProperty("product1"));

        // Step 4: Proceed to checkout
        pg.checkoutProducts();

        // Step 5: Validate products in the checkout page
        CheckoutPage cp = new CheckoutPage(driver);
        cp.ValidateProducts(configReader.getProperty("product1"));

        // Step 6: Remove a product from the cart
        cp.removeProduct(configReader.getProperty("product1"));
    }
}