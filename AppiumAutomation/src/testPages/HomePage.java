package testPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	AndroidDriver<AndroidElement> driver = null;
	WebElement element = null;
	
	//Constructor
	public HomePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Create Object properties
	
	String Search_text = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/search_text_view']";
	String Select_prod = "//android.widget.TextView[@resource-id='com.snapdeal.main:id/keyword_text_view']";
	
	//Method to Enter product text
	public void EnterText(String Text)
	{
		driver.findElementByXPath(Search_text).sendKeys("Watches");
	}
	
	//Method Click on search Box
	public void ClickSearchBox()
	{
		driver.findElementByXPath(Search_text).click();
	}
	
	//Select Product from Search Suggestion
	public void Select_searchItem()
	{
		driver.findElementByXPath(Select_prod).click();
	}

}
