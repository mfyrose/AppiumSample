package testClasses;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import testPages.CartPage;
import testPages.HomePage;
import testPages.ProductSearchPage;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class SnapDeal_Test  {

	AndroidDriver<AndroidElement> driver = null;
	static String projectpath = System.getProperty("user.dir");
	public static ExtentReports extent;
	public static ExtentTest test1;
	public static ExtentTest test2;

	@BeforeClass
	public void Setup() throws IOException {
		//Setup Extent Reports

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports/AddtoCart.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Search Product","This is to if user is able to Search in <b>SNAPDEAL</b> Android App");
		ExtentTest test2 = extent.createTest("Add Product to Cart","This is to if user is able to add product to Shopping in <b>SNAPDEAL</b> Android App");

		//Setup Android driver
		driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void AddtoCart() throws IOException {
		// Search for product with keyword watches
		
		HomePage home = new HomePage(driver);
		home.ClickSearchBox();
		home.EnterText("Watches");
		home.Select_searchItem();
		test1.log(Status.PASS,"Successfully searched for a product");
		
		//Choose Product,Add to cart & Navigate to Shopping cart

		ProductSearchPage product = new ProductSearchPage(driver);
		product.ChooseProduct();
		product.Addtocart();
		product.GotoShoppingCart();
		test2.log(Status.PASS,"Successfully Added product to Shopping Cart");
		
		//Validate if product is added to shopping cart
		CartPage cart = new CartPage(driver);
		cart.ShoppingCart_VerifyProduct();
		test2.log(Status.PASS, "Product is added to cart");  
	}

	@AfterClass
	public void Teardown() {
		extent.flush();
		//Close the App
		driver.closeApp();
	}
	//Method setup Android Mobile driver Capabilities
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "NexusDemo");
		//If Android real Device--
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.snapdeal.main");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.snapdeal.ui.material.activity.MaterialMainActivity");
		//Create ANdroid driver
		AndroidDriver<AndroidElement>  driver;
	    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	    return driver;
	}

}
