package com.assignment.test;

import com.assignment.pom.CouponPage;
import com.assignment.pom.LandingPage;
import com.assignment.utils.Constants;
import com.assignment.utils.Utils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import java.time.Duration;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(com.assignment.test.TestName.class)
@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",
        glue = {"com/assignment/stepDefinition"},
        plugin = { "pretty", "html:target/cucumber-html-reports.html"},
        monochrome = true
)
public class CouponActivationTest {
    // set up appium driver and start it


    // open the coupon center


    // check coupons one by one and activate the first available one
    // validation is done using the number of activated and non-activated coupons before and after the activation
    // this difference should be 1


    // stop appium driver
}
