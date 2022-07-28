package com.assignment.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",
        glue = {"com/assignment/stepDefinition"},
        plugin = { "pretty", "html:build/reports/tests/cucumber/cucumber-report.html"},
        monochrome = true
)
public class CouponActivationTest {
}
