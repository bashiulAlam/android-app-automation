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
        plugin = { "pretty", "html:build/reports/tests/cucumber/cucumber-report.html"},
        monochrome = true
)
public class CouponActivationTest {
}
