package com.assignment.test;

import com.assignment.utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class.getName());
    public static AppiumDriver appiumDriver;

    public static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Constants.AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.PLATFORM_VERSION);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Constants.APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Constants.APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        try {
            appiumDriver = new AppiumDriver(new URL(Constants.APPIUM_SERVER), capabilities);
            log.info("Appium driver started...");
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
    }

    public static void tearDown() {
        if (null != appiumDriver) {
            appiumDriver.quit();
            log.info("Appium driver stopped...");
        }
    }
}
