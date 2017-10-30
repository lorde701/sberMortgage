package ru.company.autotests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Иванка on 30.10.2017.
 */
public class TestProperties {
    private static TestProperties INSTANCE = null;
    private final Properties  properties = new Properties();

    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./application.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
