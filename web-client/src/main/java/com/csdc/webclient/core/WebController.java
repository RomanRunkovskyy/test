package com.csdc.webclient.core;

import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.ElementFinder;
import com.csdc.webclient.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    public static WebElementWrapper getElement(By criteria) {
        log.debug(String.format("Trying to find element using criteria %s", criteria));
        return ElementFinder.wrap(WebElementWrapper.class, null, criteria, 0);
    }

    public static WebElementWrapper getElement(By criteria, int index) {
        log.debug(String.format("Trying to find element using criteria %s and index %s", criteria), index);
        return ElementFinder.wrap(WebElementWrapper.class, null, criteria, index);
    }

    public static void open(String relativeOrAbsoluteUrl) {
        Selenide.open(relativeOrAbsoluteUrl, "", "", "");
    }

    public static <PageObjectClass> PageObjectClass open(String relativeOrAbsoluteUrl,
                                                         Class<PageObjectClass> pageObjectClassClass) {
        return Selenide.open(relativeOrAbsoluteUrl, pageObjectClassClass);
    }

    public static WebElementWrapper $(By seleniumSelector) {
        return getElement(seleniumSelector);
    }

    public static WebElementWrapper $(String cssSelector) {
        return getElement(By.cssSelector(cssSelector));
    }

    public static void main(String[] args) {
    }
}
