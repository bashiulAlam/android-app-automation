package com.assignment.test;

import com.assignment.pom.CouponCenterPage;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

public class CouponActivationTest extends BaseTest {

    public CouponCenterPage couponCenterPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        BaseTest.setUp();
    }

    @Test
    public void couponActivationTest() {
        couponCenterPage = new CouponCenterPage(appiumDriver);
        couponCenterPage.openCouponCenter();
    }

    @AfterAll
    public static void tearDown() {
        BaseTest.tearDown();
    }
}
