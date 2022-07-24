# Android App Automation with Appium
***

## Project Tools Used
- **Programming Language:** Java (JDK 1.8)
- **Framework and Tools Used:** Appium, JUnit, Gradle, Apache Log4j Logging
- **IDE:** Intellij Idea

## Project Structure

- The project is implemented with POM (Page Object Model) structure where the page classes have been put under: *{project_root}/src/main/java/com/assignment/pom*
- The test classes have been put under: *{project_root}/src/test/java/com/assignment/test*
- A properties file have been added to *resources* folder for ease of use of access variables
- We also have an *utils* package to maintain the configuration variables, constant values and utility methods

## Prerequisites

- You need to have the following installations in your machine:
    - JDK
    - Appium Server
    - Android SDK
    - Gradle
    - Any IDE of your choice that supports Java
- An *Android* device having the following:
    - The **PAYBACK** app installed and logged in with an user
    - USB debugging allowed
- A browser of your choice to check the HTML report
- A text editor tool of your choice to check the logs
- For windows machine, you will need the following added to your system environment variables:
    - JDK
    - Android SDK
    - Gradle

## Project Import
1. Clone the project from GitHub or download the project and unzip it
2. Open your IDE and import the project as a *Gradle* project

## Before You Run
- Open the **config.properties** file from the path: *src/main/resources* and set the required variables here:
    1. Set the android version of the device that you will use to run the project
    2. Set the *appium server URL* if it is not running from your local machine
    3. Set the index variable to the value from which you want to check the coupons from; ideally the value should be greater than 12

## How to Run
- You can run the project from your IDE by following the steps:
    1. Open the java class **CouponActivationTest.java** from the path: *src/test/java/com/assignment/test/*
    2. Run this class
- You can run the project from command prompt or terminal by executing the following command from your *{project_root}*:

         ./gradlew test

## Report and Logging
1. If you run the project from your IDE you can see the results from your IDE console
2. As we are using *gradle* we will have an HTML report generated after every run which can be found here: *{project_root}/build/reports/tests/test/index.html*`
3. We have logging enabled for better visualization and ease of troubleshooting in case of any error. Log file can be found here: *{project_root}/logs*

## Observations
1. The coupons do not have any distinguishable id which can be used in the automation. That is why *REWE* coupons were not easy to differentiate from others. The implementation was designed such way that we open coupon center and look for an available non-activated coupon one by one. When we find one available we activate and check the count of activated coupon increase to validate
2. The app crashes some time in regular UI transition
3. The app closes if we press back button from coupon center or opened coupon UI
4. The app transition sometimes gets slow and we get error like *element is not present in DOM*
