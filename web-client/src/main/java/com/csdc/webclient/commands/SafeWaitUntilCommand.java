package com.csdc.webclient.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.impl.WebElementSource;
import com.csdc.webclient.core.WebElementWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SafeWaitUntilCommand implements Command<WebElementWrapper> {

    private static final Logger LOG = LoggerFactory.getLogger(SafeWaitUntilCommand.class);

    @Override
    public WebElementWrapper execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
        Condition condition = (Condition) args[0];
        Integer timeout = (Integer) args[1];

        try {
            proxy.waitUntil(condition, timeout);
        } catch (ElementNotFound e) {
            LOG.warn(String.format("Safe wait until element with search criteria: %s and condition: %s is true." +
                    " Exception msg: %s", proxy.getSearchCriteria(), condition, e.getLocalizedMessage()));
        }
        return (WebElementWrapper) proxy;
    }
}
