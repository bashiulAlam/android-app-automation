package com.assignment.bdd;

import com.assignment.pom.LandingPage;
import com.tngtech.jgiven.Stage;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WhenSomeAction openCouponCenter() {
        LandingPage landingPage = new LandingPage(appiumDriver);
        landingPage.openCouponCenter();
        return self();
    }
}
