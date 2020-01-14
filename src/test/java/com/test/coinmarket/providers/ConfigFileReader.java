package com.test.coinmarket.providers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "config/configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties = new Properties();
            try {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getReportConfigPath() {
        String reportPath=properties.getProperty("reportConfigPath");
        if(reportPath!=null)
            return reportPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
