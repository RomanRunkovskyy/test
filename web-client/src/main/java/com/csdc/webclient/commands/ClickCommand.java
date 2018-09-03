package com.csdc.webclient.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Click;
import com.codeborne.selenide.impl.WebElementSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClickCommand implements Command<Void> {

    private static final Logger LOG = LoggerFactory.getLogger(ClickCommand.class);

    @Override
    public Void execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
        LOG.info(String.format("Click on element with search criteria: %s", proxy.getSearchCriteria()));
        new Click().execute(proxy, locator, args);
        return null;
    }
}
