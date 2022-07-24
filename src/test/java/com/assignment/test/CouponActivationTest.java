package com.assignment.test;

import com.assignment.bdd.GivenSomeState;
import com.assignment.bdd.ThenSomeOutcome;
import com.assignment.bdd.WhenSomeAction;
import com.assignment.pom.CouponPage;
import com.assignment.pom.LandingPage;
import com.assignment.utils.Constants;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestName;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(com.assignment.test.TestName.class)
public class CouponActivationTest extends BaseTest, ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    @Rule
    TestName testName = new TestName();

    private static final Logger log = LogManager.getLogger(CouponActivationTest.class.getName());

    // set up appium driver and start it
    @BeforeAll
    public static void setUp() {
        BaseTest.setUp();
    }

    // open the coupon center
    @Test
    @Order(1)
    public void Test_001_openCouponCenter() {
        LandingPage landingPage = new LandingPage(appiumDriver);
        landingPage.openCouponCenter();
        String title = landingPage.getCouponCenterTitle();
        log.info("Coupon center title : " + title);
        Assertions.assertEquals(Constants.COUPON_CENTER_UI_TITLE, title);
    }

    // check coupons one by one and activate the first available one
    // validation is done using the number of activated and non-activated coupons before and after the activation
    // this difference should be 1
    @Test
    @Order(2)
    public void Test_002_filterAndActivateCoupon() {
        CouponPage couponPage = new CouponPage(appiumDriver);
        int[] activationCounts = couponPage.getActivatedCouponCountFromCouponCenter();
        couponPage.clickFilterButton();
        String title = couponPage.getFilterUITitle();
        log.info("Filter UI title : " + title);
        Assertions.assertEquals(Constants.FILTER_UI_TITLE, title);

        log.info("Total not activated coupon count : " + activationCounts[0]);
        log.info("Total activated count : " + activationCounts[1]);
        log.info("Total coupon services available : " + couponPage.getCoupons());
        couponPage.openSelectedCoupon(Integer.parseInt(Constants.COUPON_FILTER_START_INDEX));

        int[] activationCountsBefore = couponPage.getActivatedCouponCountFromCouponDetails();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        couponPage.openActiveCouponList();
        int[] activationCountsAfter = couponPage.getActivatedCouponCountFromCouponDetails();

        int nonActivatedCouponCountDiff = Math.abs(activationCountsAfter[0] - activationCountsBefore[0]);
        int activatedCouponCountDiff = Math.abs(activationCountsAfter[1] - activationCountsBefore[1]);
        log.info("Number of coupons moved from non-activated state : " + nonActivatedCouponCountDiff);
        log.info("Number of coupons moved to activated state : " + activatedCouponCountDiff);

        Assertions.assertEquals(1, activatedCouponCountDiff);
        Assertions.assertEquals(1, nonActivatedCouponCountDiff);
    }

    // stop appium driver
    @AfterAll
    public static void tearDown() {
        BaseTest.tearDown();
    }
}
