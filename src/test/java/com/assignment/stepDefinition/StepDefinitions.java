package com.assignment.stepDefinition;

import com.assignment.pom.CouponPage;
import com.assignment.pom.LandingPage;
import com.assignment.test.BaseTest;
import com.assignment.utils.Constants;
import com.assignment.utils.Utils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class StepDefinitions extends BaseTest {
    private static final Logger log = LogManager.getLogger(StepDefinitions.class.getName());
    public int[] activationCountsBefore = new int[2];
    public int[] activationCountsAfter = new int[2];
    public int[] activationCounts = new int[2];

    // set up appium driver and start it
    @BeforeAll
    public static void setUp() {
        BaseTest.setUp();
        log.info("Test run started at : " + Utils.getCurrentTime());
    }

    // stop appium driver
    @AfterAll
    public static void tearDown() {
        BaseTest.tearDown();
        log.info("Test run ended at : " + Utils.getCurrentTime());
    }

    // open the coupon center
    @When("^User taps on coupon center button$")
    public void userTapsOnCouponCenterButton() {
        LandingPage landingPage = new LandingPage(appiumDriver);
        landingPage.openCouponCenter();
    }

    // validate coupon center by UI title
    @Then("^Coupon center UI is loaded$")
    public void couponCenterUIIsLoaded() {
        LandingPage landingPage = new LandingPage(appiumDriver);
        String title = landingPage.getCouponCenterTitle();
        log.info("Coupon center title : " + title);
        Assertions.assertEquals(Constants.COUPON_CENTER_UI_TITLE, title);
    }

    // open filter UI and validate the title
    @Given("^User has opened coupon filter UI$")
    public void userHasOpenedCouponFilterUI() {
        CouponPage couponPage = new CouponPage(appiumDriver);
        activationCounts = couponPage.getActivatedCouponCountFromCouponCenter();
        log.info("Total not activated coupon count : " + activationCounts[0]);
        log.info("Total activated count : " + activationCounts[1]);
        log.info("Total coupon services available : " + couponPage.getCoupons());

        couponPage.clickFilterButton();
        String title = couponPage.getFilterUITitle();
        log.info("Filter UI title : " + title);
        Assertions.assertEquals(Constants.FILTER_UI_TITLE, title);
    }

    // check coupons one by one and activate the first available one
    @When("^User checks available coupon that can be activated and taps on the activate button$")
    public void userChecksAvailableCouponThatCanBeActivatedAndTapsOnTheActivateButton() {
        CouponPage couponPage = new CouponPage(appiumDriver);
        couponPage.openSelectedCoupon(Integer.parseInt(Constants.COUPON_FILTER_START_INDEX));

        activationCountsBefore = couponPage.getActivatedCouponCountFromCouponDetails();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        couponPage.openActiveCouponList();
        activationCountsAfter = couponPage.getActivatedCouponCountFromCouponDetails();
    }

    // validation is done using the number of activated and non-activated coupons before and after the activation
    // this difference should be 1
    @Then("^Coupon has been activated$")
    public void couponHasBeenActivated() {
        int nonActivatedCouponCountDiff = Math.abs(activationCountsAfter[0] - activationCountsBefore[0]);
        int activatedCouponCountDiff = Math.abs(activationCountsAfter[1] - activationCountsBefore[1]);
        log.info("Number of coupons moved from non-activated state : " + nonActivatedCouponCountDiff);
        log.info("Number of coupons moved to activated state : " + activatedCouponCountDiff);

        Assertions.assertEquals(1, activatedCouponCountDiff);
        Assertions.assertEquals(1, nonActivatedCouponCountDiff);
    }
}
