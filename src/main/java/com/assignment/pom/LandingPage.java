package com.assignment.pom;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LandingPage extends BasePage {
    public LandingPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "coupon_center_dest")
    RemoteWebElement couponCenter;

    @AndroidFindBy(className = "android.widget.TextView")
    RemoteWebElement titleBar;

    public void openCouponCenter() {
        couponCenter.click();
    }

    public String getCouponCenterTitle() {
        return titleBar.getText();
    }
}
