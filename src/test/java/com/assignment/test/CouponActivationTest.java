package com.assignment.test;

import com.assignment.pom.CouponPage;
import com.assignment.pom.LandingPage;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CouponActivationTest extends BaseTest {

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        BaseTest.setUp();
    }

    @Test
    @Order(1)
    public void Test_001_openCouponCenter() {
        LandingPage landingPage = new LandingPage(appiumDriver);
        landingPage.openCouponCenter();
        String title = landingPage.getCouponCenterTitle();
        System.out.println("coupon center title : " + title);
        Assertions.assertEquals("Coupons", title);
    }

    @Test
    @Order(2)
    public void Test_002_filterCoupon() {
        CouponPage couponPage = new CouponPage(appiumDriver);
        int[] activationCounts = couponPage.getActivatedCouponCountFromCouponCenter();
        couponPage.clickFilterButton();
        System.out.println("not activated count : " + activationCounts[0]);
        System.out.println("activated count : " + activationCounts[1]);
        System.out.println("total coupon available : " + couponPage.getCoupons());
        couponPage.openSelectedCoupon(10);

        int[] activationCountsBefore = couponPage.getActivatedCouponCountFromCouponDetails();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        couponPage.openActiveCouponList();
        int[] activationCountsAfter = couponPage.getActivatedCouponCountFromCouponDetails();

        int nonActivatedCouponCountDiff = Math.abs(activationCountsAfter[0] - activationCountsBefore[0]);
        int activatedCouponCountDiff = Math.abs(activationCountsAfter[1] - activationCountsBefore[1]);

        Assertions.assertEquals(1, activatedCouponCountDiff);
        Assertions.assertEquals(1, nonActivatedCouponCountDiff);
    }

    /*@Test
    @Order(3)
    public void Test_003_activateCoupon() {
        CouponPage couponPage = new CouponPage(appiumDriver);
        int[] activationCountsBefore = couponPage.getActivatedCouponCountFromCouponDetails();
        //couponPage.activateCoupon();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        couponPage.openActiveCouponList();
        int[] activationCountsAfter = couponPage.getActivatedCouponCountFromCouponDetails();

        int nonActivatedCouponCountDiff = Math.abs(activationCountsAfter[0] - activationCountsBefore[0]);
        int activatedCouponCountDiff = Math.abs(activationCountsAfter[1] - activationCountsBefore[1]);

        Assertions.assertEquals(1, activatedCouponCountDiff);
        Assertions.assertEquals(1, nonActivatedCouponCountDiff);
    }*/

    /*@AfterAll
    public static void tearDown() {
        BaseTest.tearDown();
    }*/
}
