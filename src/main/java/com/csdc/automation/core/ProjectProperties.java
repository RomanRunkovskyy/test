package com.csdc.automation.core;

public class ProjectProperties {
    private final static String PATH_TO_FILE = "src/main/resources";
    private final static String FILE_NAME = "project.properties";

    private static String getProperty(String key) {
        return PropertiesFactory.init().getPropertyFile(PATH_TO_FILE, FILE_NAME).getProperty(key);
    }

    public static String readString(String key) {
        return getProperty(key);
    }

    public static Integer readInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }

    public static Double readDouble(String key) {
        return Double.valueOf(getProperty(key));
    }

    public static Long readLong(String key) {
        return Long.valueOf(getProperty(key));
    }

    public static Boolean readBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }
}
