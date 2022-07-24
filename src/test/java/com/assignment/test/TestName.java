package com.assignment.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestName implements BeforeEachCallback {
    private static final Logger log = LogManager.getLogger(TestName.class.getName());

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        extensionContext.getTestMethod().ifPresent(m -> log.info("---------- Test Name :: " + m.getName() + " :: ----------"));
    }
}
