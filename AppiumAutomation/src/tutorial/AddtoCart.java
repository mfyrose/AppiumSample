package tutorial;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddtoCart extends InvokeApppackage {
	
	WebDriver driver;

	public static void main(String[] args) throws IOException  {
		
		//Create an Android driver object and map it to our capabilities
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Search for product with keyword watches
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/search_text_view']").click();
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/search_text_view']").sendKeys("Watches");
		//Choose from search results suggestion popup
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/keyword_text_view']").click();
		//Click on the product Title
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/productTitle']").click();
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/addCartBUtton']").click();
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/menu_cart_icon']").click();
		//driver.findElementByXPath("//android.widget.TextView[@resource-id='com.snapdeal.main:id/menu_cart_icon']").click();
		//com.snapdeal.main:id/keyword_text_view id
		//com.snapdeal.main:id/productTitle
		//com.snapdeal.main:id/addCartBUtton
		//com.snapdeal.main:id/menu_cart_icon
		//com.snapdeal.main:id/imgProduct

		//APP_PACKAGE //com.snapdeal.main
		//Activity com.snapdeal.ui.material.activity.MaterialMainActivity
	}

}
