package tutorial;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReport {
	WebDriver driver;
	static String projectpath = System.getProperty("user.dir");
	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Reports/AddtoCart.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("AddtoCart","This is to if user is able to add a product to cart in <b>SNAPDEAL</b> Android App");
		System.out.println("TESTING");
		 test1.pass("PHP travels site launched");
		 test1.pass("Email Address Entered");
		 test1.fail("Product is in Cart Page", MediaEntityBuilder.createScreenCaptureFromPath(projectpath+"/Screenshots/Cart.png").build());
		 System.out.println(projectpath+"/Screenshots/Cart.png");
		 test1.addScreenCaptureFromPath(projectpath+"/Screenshots/Cart.png");
		 extent.flush();
		 

	}

}
