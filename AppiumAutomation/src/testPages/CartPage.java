package testPages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CartPage {
	
	AndroidDriver<AndroidElement> driver = null;
	WebElement element = null;
	
	//Constructor
	public CartPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	//Create Object properties
	String Cart_Product = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/itemAttrs']";
	
	
	//Method to VerifyProduct
	public void ShoppingCart_VerifyProduct()
	{
		int Prod_count = driver.findElementsByXPath(Cart_Product).size();
		if (Prod_count > 0)
		{
			AndroidElement prod_name = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/itemAttrs']");
			
			System.out.println("PASS added product : "+prod_name.getText());
		}
		else
		{
			System.out.println("FAIL");
		}
	}
	
	

}
