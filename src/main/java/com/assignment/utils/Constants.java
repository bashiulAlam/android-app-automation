package com.assignment.utils;

public class Constants {
    //read properties value
    public static final String APPIUM_SERVER = ConfigPropertiesUtil.readProperties("APPIUM_SERVER");

    public static final String AUTOMATION_NAME = ConfigPropertiesUtil.readProperties("AUTOMATION_NAME");
    public static final String PLATFORM_NAME = ConfigPropertiesUtil.readProperties("PLATFORM_NAME");
    public static final String DEVICE_NAME = ConfigPropertiesUtil.readProperties("DEVICE_NAME");
    public static final String PLATFORM_VERSION = ConfigPropertiesUtil.readProperties("PLATFORM_VERSION");
    public static final String APP_PACKAGE = ConfigPropertiesUtil.readProperties("APP_PACKAGE");
    public static final String APP_ACTIVITY = ConfigPropertiesUtil.readProperties("APP_ACTIVITY");

    public static final String COUPON_FILTER_START_INDEX = ConfigPropertiesUtil.readProperties("COUPON_FILTER_START_INDEX");

    //other constants
    public static final String COUPON_CENTER_UI_TITLE = "Coupons";
}
