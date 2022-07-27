Feature: Coupon Activation

  Scenario: Open Coupon Center
    When User taps on coupon center button
    Then Coupon center UI is loaded

  Scenario: Activate available coupon
    Given User has opened coupon filter UI
    When User checks available coupon that can be activated and taps on the activate button
    Then Coupon has been activated