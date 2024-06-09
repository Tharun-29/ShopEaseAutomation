package TestPack;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.ProductPage;
import TestComponents.BaseTest;


public class addProductToCartValidation extends BaseTest {
      
	 @Test
	 public void verifyProductAdditionToCart() {
		    LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
			LogPage.LoginToApplication(configReader.getProperty("username"),configReader.getProperty("password"));
	       
			
			ProductPage pg = new ProductPage(driver);
			pg.addProducts(configReader.getProperty("product1"));
			pg.checkoutProducts();
			
			CheckoutPage cp = new CheckoutPage(driver);
			cp.ValidateProducts(configReader.getProperty("product1"));
			
			
	    }
	
	
}
