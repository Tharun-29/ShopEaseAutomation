package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;

public class removeProductToCartValidation extends BaseTest {
    
	@Test
	public void verifyProductRemovalfromCart() {
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));

		ProductPage pg = new ProductPage(driver);
		pg.addProducts(configReader.getProperty("product1"));
		pg.checkoutProducts();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.ValidateProducts(configReader.getProperty("product1"));
		cp.removeProduct(configReader.getProperty("product1"));
	}
}
