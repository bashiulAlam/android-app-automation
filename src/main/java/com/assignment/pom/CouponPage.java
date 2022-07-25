package com.assignment.pom;

import com.assignment.utils.Constants;
import com.assignment.utils.Utils;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofMillis;

public class CouponPage extends BasePage {
    private static final Logger log = LogManager.getLogger(CouponPage.class.getName());

    public CouponPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    List<RemoteWebElement> titleBarTexts;

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
        log.info("Not activated coupon tab title : " + tabTitles.get(1).getText());
        log.info("Activated coupon tab title : " + tabTitles.get(2).getText());
        int notActivatedCount = Utils.parseTabTitle(tabTitles.get(1).getText());
        int activatedCount = Utils.parseTabTitle(tabTitles.get(2).getText());
        return new int[]{notActivatedCount, activatedCount};
    }

    public int[] getActivatedCouponCountFromCouponDetails() {
        log.info("Not activated coupon tab title : " + tabTitles.get(2).getText());
        log.info("Activated coupon tab title : " + tabTitles.get(3).getText());
        int notActivatedCount = Utils.parseTabTitle(tabTitles.get(2).getText());
        int activatedCount = Utils.parseTabTitle(tabTitles.get(3).getText());
        return new int[]{notActivatedCount, activatedCount};
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public String getFilterUITitle() {
        return titleBarTexts.get(0).getText();
    }

    public int getCoupons() {
        return coupons.size();
    }

    public void openSelectedCoupon(int index) {
        int availabilityFlag = 0;
        for (int i = index; i < coupons.size(); i += 2) {
            log.info("checking coupon no : " + i);
            log.info("total coupon available : " + coupons.size());
            coupons.get(i).click();
            //WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofMillis(15000));
            //appiumDriver.manage().timeouts().implicitlyWait(ofMillis(15000));
            //if (titleBarTexts.get(0).getText().equals(Constants.FILTER_UI_TITLE))
            submitFilter.click();

            //appiumDriver.manage().timeouts().implicitlyWait(ofMillis(5000));

            int couponCardCount = getCouponCardsCount();
            log.info("available coupon count for activation : " + couponCardCount);

            //int activateButtonCount = activateButton.size();
            //log.info("activate button count : " + activateButtonCount);
            if (couponCardCount > 0) {
                activateButton.get(0).click();
                availabilityFlag = 1;
                break;
            }
            //actionFilter.click();
            //coupons.get(i).click();
            LandingPage landingPage = new LandingPage(appiumDriver);
            landingPage.goToFeedAndOpenCouponCenter();
            clickFilterButton();
            appiumDriver.manage().timeouts().implicitlyWait(ofMillis(5000));
        }

        if (availabilityFlag == 0)
            log.error("There is no coupon available to activate...");
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
