package tutorial;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class InvokeApppackage {
	
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
