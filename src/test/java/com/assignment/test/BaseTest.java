package com.assignment.test;

import com.assignment.pom.BasePage;
import com.assignment.utils.Constants;
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
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Constants.AUTOMATION_NAME);
        capabilities.setCapability("platformName", Constants.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.PLATFORM_VERSION);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constants.APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        appiumDriver = new AppiumDriver(new URL(Constants.APPIUM_SERVER), capabilities);
    }

    public static void tearDown() {
        if (null != appiumDriver) {
            appiumDriver.quit();
        }
    }
}
