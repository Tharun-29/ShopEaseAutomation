package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.InformationPage;
import PageObjects.LoginPage;
import PageObjects.OrderConfirmationPage;
import PageObjects.OverviewPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class OrderCreationTest extends BaseTest {

    // Test method to create an order
    @Test
    public void createOrder() {
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

        // Step 6: Proceed with checkout by submitting user information
        InformationPage ip = new InformationPage(driver);
        ip.UserInformationSubmission(configReader.getProperty("firstName"), configReader.getProperty("lastName"),configReader.getProperty("postalCode"));

        // Step 7: Validate overview page before confirming the order
        OverviewPage op = new OverviewPage(driver);
        op.ValidateOveriewPage(configReader.getProperty("product1"));

        // Step 8: Validate order confirmation after placing the order
        OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
        ocp.ValidateOrderConfirmation();
    }

}