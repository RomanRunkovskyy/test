package com.csdc.webclient.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.Commands;
import com.csdc.webclient.commands.ClickCommand;
import com.csdc.webclient.commands.ExistsCommand;
import com.csdc.webclient.commands.SafeWaitUntilCommand;
import com.csdc.webclient.commands.SetValueCommand;

public class SelenideConfiguration {

    public static void initWebDriver() {
        Configuration.browser = WebClientProperties.readString("browser");
        Configuration.baseUrl = WebClientProperties.readString("amanda.base.url");
        System.setProperty("webdriver.ie.driver", WebClientProperties.readString("webdriver.ie.path"));
        System.setProperty("webdriver.chrome.driver", WebClientProperties.readString("webdriver.chrome.path"));
    }

    public static void initCommands() {
        Commands.getInstance().add("safeWaitUntil", new SafeWaitUntilCommand());
        Commands.getInstance().add("click", new ClickCommand());
        Commands.getInstance().add("setValue", new SetValueCommand());
        Commands.getInstance().add("exists", new ExistsCommand());
    }
}
