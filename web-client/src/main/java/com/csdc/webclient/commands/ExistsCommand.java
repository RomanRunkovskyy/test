package com.csdc.webclient.commands;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Exists;
import com.codeborne.selenide.impl.WebElementSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExistsCommand implements Command<Boolean> {

    private static final Logger LOG = LoggerFactory.getLogger(ExistsCommand.class);

    @Override
    public Boolean execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
        LOG.info(String.format("Click on element with search criteria: %s", proxy.getSearchCriteria()));
        return new Exists().execute(proxy, locator, args);
    }
}
