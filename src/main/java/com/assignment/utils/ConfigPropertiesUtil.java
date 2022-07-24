package com.assignment.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesUtil {
    public static String readProperties(String key) {
        Properties properties = new Properties();
        String configFilePath = "src/main/resources/config.properties";
        try {
            FileInputStream propsInput = new FileInputStream(configFilePath);
            properties.load(propsInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty(key);
    }
}
