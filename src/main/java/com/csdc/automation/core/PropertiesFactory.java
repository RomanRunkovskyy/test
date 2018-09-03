package com.csdc.automation.core;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFactory {
    private static PropertiesFactory propertiesFactory;
    private Map<String, Properties> propertiesMap;

    public static PropertiesFactory init() {
        if (propertiesFactory == null) {
            propertiesFactory = new PropertiesFactory();
            propertiesFactory.propertiesMap = new HashMap<>();
        }
        return propertiesFactory;
    }

    private static Properties createProperties(String pathtoFile, String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(Paths.get(pathtoFile, fileName).toFile()));
        } catch (IOException e) {
            throw new RuntimeException("Error during processing property file '" + fileName + "'", e);
        }
        return properties;
    }

    public Properties getPropertyFile(String pathtoFile, String propertiesFile) {
        if (!propertiesMap.containsKey(propertiesFile)) {
            propertiesMap.put(propertiesFile, createProperties(pathtoFile, propertiesFile));
        }
        return propertiesMap.get(propertiesFile);
    }
}
