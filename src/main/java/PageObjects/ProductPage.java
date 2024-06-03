package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	List<WebElement> Products;
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']/../../following-sibling::div//button[text()='Add to cart']")
	WebElement AddCartButton;
	
	@FindBy(id = "shopping_cart_container")
	WebElement CheckoutIcon;
	
	
	public void addProducts() {
		 for(WebElement Product: Products) {
		    	String productName = Product.getText();
		    	if(productName.contains("Sauce Labs Bike Light") || productName.contains("Backpack")) {
		    		AddCartButton.click();
		    	}
		    }
		}
	
	public void checkoutProducts() {
	    CheckoutIcon.click();
	}
	
	
	
}
