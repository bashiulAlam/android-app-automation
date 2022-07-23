package com.assignment.pom;

import com.assignment.utils.Utils;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class CouponPage extends BasePage {
    public CouponPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "filter_button")
    RemoteWebElement filterButton;

    @AndroidFindBy(id = "action_filter")
    RemoteWebElement actionFilter;

    @AndroidFindBy(className = "android.view.ViewGroup")
    List<RemoteWebElement> coupons;

    @AndroidFindBy(id = "done")
    RemoteWebElement submitFilter;

    @AndroidFindBy(id = "constraint_container")
    List<RemoteWebElement> couponCards;

    @AndroidFindBy(className = "android.widget.TextView")
    List<RemoteWebElement> tabTitles;

    @AndroidFindBy(id = "not_activated_button")
    List<WebElement> activateButton;

    @AndroidFindBy(className = "android.widget.LinearLayout")
    List<WebElement> activationBar;

    public int[] getActivatedCouponCountFromCouponCenter() {
        System.out.println(tabTitles.get(1).getText());
        System.out.println(tabTitles.get(2).getText());
        int notActivatedCount = Utils.parseTabTitle(tabTitles.get(1).getText());
        int activatedCount = Utils.parseTabTitle(tabTitles.get(2).getText());
        return new int[] {notActivatedCount, activatedCount};
    }

    public int[] getActivatedCouponCountFromCouponDetails() {
        System.out.println(tabTitles.get(2).getText());
        System.out.println(tabTitles.get(3).getText());
        int notActivatedCount = Utils.parseTabTitle(tabTitles.get(2).getText());
        int activatedCount = Utils.parseTabTitle(tabTitles.get(3).getText());
        return new int[] {notActivatedCount, activatedCount};
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public int getCoupons() {
        return coupons.size();
    }

    public void openSelectedCoupon(int index) {
        for (int i = index; i < coupons.size(); i += 2) {
            System.out.println("checking coupon no : " + i + "\ntotal coupon available : " + coupons.size());
            coupons.get(i).click();
            if (submitFilter.isDisplayed())
                submitFilter.click();

            //appiumDriver.manage().timeouts().implicitlyWait(ofMillis(5000));

            int couponCardCount = getCouponCardsCount();
            System.out.println("available coupon count : " + couponCardCount);

            //int activateButtonCount = activateButton.size();
            //System.out.println("activate button count : " + activateButtonCount);
            if (couponCardCount > 0) {
                activateButton.get(0).click();
                break;
            }
            //actionFilter.click();
            //coupons.get(i).click();
            LandingPage landingPage = new LandingPage(appiumDriver);
            landingPage.goToFeedAndOpenCouponCenter();
            clickFilterButton();
            appiumDriver.manage().timeouts().implicitlyWait(ofMillis(5000));
        }
    }

    public int getCouponCardsCount() {
        return couponCards.size();
    }

    public void openActiveCouponList() {
        appiumDriver.manage().timeouts().implicitlyWait(ofMillis(5000));
        tabTitles.get(3).click();
        tabTitles.get(2).click();
    }
}
