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

	@Test
	public void createOrder() {
		LogPage.OpenLoginPage(configReader.getProperty("baseURL"));
		LogPage.LoginToApplication(configReader.getProperty("username"), configReader.getProperty("password"));

		ProductPage pg = new ProductPage(driver);
		pg.addProducts(configReader.getProperty("product1"));
		pg.checkoutProducts();

		CheckoutPage cp = new CheckoutPage(driver);
		cp.ValidateProducts(configReader.getProperty("product1"));
		cp.CheckoutOrder();

		InformationPage ip = new InformationPage(driver);
		ip.UserInformationSubmission(configReader.getProperty("firstName"), configReader.getProperty("lastName"),
				configReader.getProperty("postalCode"));

		OverviewPage op = new OverviewPage(driver);
		op.ValidateOveriewPage(configReader.getProperty("product1"));

		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		ocp.ValidateOrderConfirmation();

	}

}
