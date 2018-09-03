package com.csdc.webclient.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.SetValue;
import com.codeborne.selenide.impl.WebElementSource;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetValueCommand implements Command<WebElement> {

    private static final Logger LOG = LoggerFactory.getLogger(SetValueCommand.class);

    @Override
    public WebElement execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
        LOG.info(String.format("Set value '%s' to element: %s", args[0], proxy.getSearchCriteria()));
        return new SetValue().execute(proxy, locator, args);
    }
}
