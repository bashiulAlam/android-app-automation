package com.assignment.pom;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CouponCenterPage extends BasePage {
    public CouponCenterPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    WebElement couponCenter = appiumDriver.findElement(By.id("de.payback.client.android:id/coupon_center_dest"));

    public void openCouponCenter() {
        couponCenter.click();
    }
}
