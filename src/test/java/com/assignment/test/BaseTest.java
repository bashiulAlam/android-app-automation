package com.assignment.test;

import com.assignment.pom.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AppiumDriver appiumDriver;

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "My Device");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "de.payback.client.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "de.payback.app.deeplinks.StarterActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        appiumDriver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown() {
        if (null != appiumDriver) {
            appiumDriver.quit();
        }
    }
}
