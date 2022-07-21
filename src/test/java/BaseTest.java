import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    static AppiumDriver appiumDriver;

    /*private String url = "http://localhost:4723/wd/hub";

    public BaseTest(String url) {
        this.url = url;
    }*/

    @Test
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5 API 31");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "de.payback.client.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "de.payback.app.deeplinks.StarterActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Calculator");

        appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        /*appiumDriver.findElement(By.id("digit_1")).click();
        appiumDriver.findElement(By.id("op_add")).click();
        appiumDriver.findElement(By.id("digit_3")).click();
        appiumDriver.findElement(By.id("eq")).click();
        Assertions.assertEquals(appiumDriver.findElement(By.id("result")).getText(),"4");*/
    }

    @AfterAll
    public static void tearDown() {
        if (null != appiumDriver) {
            appiumDriver.quit();
        }
    }
}
