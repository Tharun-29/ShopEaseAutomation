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

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@data-test='inventory-item-name']")
	List<WebElement> Products;
	
	@FindBy(xpath = "//div[@class='pricebar']//button[text()='Add to cart']")
	List<WebElement> AddCartButton;
	
	@FindBy(id = "shopping_cart_container")
	WebElement CheckoutIcon;
	
	
	public void addProducts(String prod) {
		 for(int i=0;i<Products.size();i++) {
			 System.out.println(Products.get(i).getText());
		    	String productName = Products.get(i).getText();
		    	if(productName.contains(prod)) {
		    		System.out.println(productName);
		    		AddCartButton.get(i).click();
		    	}
		    }
		}
	
	public void checkoutProducts() {
	    CheckoutIcon.click();
	}
	
	
	
}
