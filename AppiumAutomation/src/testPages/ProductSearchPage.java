package testPages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductSearchPage {
	
	AndroidDriver<AndroidElement> driver = null;
	WebElement element = null;
	
	//Constructor
	public ProductSearchPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	//Create Object properties
	String Product_Title = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/productTitle']";
	String AddtoCart = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/addCartBUtton']";
	String Cart_icon = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/menu_cart_icon']";
	
	//Method to Enter product text
	public void ChooseProduct()
	{
		driver.findElementByXPath(Product_Title).click();
	}
	
	//Method Click on search Box
	public void Addtocart()
	{
		driver.findElementByXPath(AddtoCart).click();
	}
	//Navigate to shopping cart
	public void GotoShoppingCart()
	{
		driver.findElementByXPath(Cart_icon).click();
	}

}
