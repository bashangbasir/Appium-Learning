import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    public static AppiumDriver driver;

    @BeforeTest
    @Parameters({"OS"})
    public static void setUp(@Optional("android") String OS) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        if(OS.equalsIgnoreCase("android")){
            caps.setCapability("platformName","Android");
            caps.setCapability("platformVersion", "9.0");
            caps.setCapability("deviceName", "Pixel_XL_API_28");
            caps.setCapability("app", System.getProperty("user.dir") + "/apps/ToDo.apk");
            caps.setCapability("unicodeKeyboard", true);
            caps.setCapability("resetKeyboard", true);
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } else if(OS.equalsIgnoreCase("iOS")){
            caps.setCapability("platformName","iOS");
            caps.setCapability("platformVersion", "14.5");
            caps.setCapability("deviceName", "iPhone 12 Pro");
            caps.setCapability("app", System.getProperty("user.dir") + "/apps/DailyCheck.zip");
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
        }

    }

    @AfterTest
    public void tearDown(){
        if (null != this.driver) {
            this.driver.quit();
        }
    }


}
