package com.csdc.webclient.core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public interface WebElementWrapper extends SelenideElement {

    void safeWaitUntil(Condition condition, Integer timeout);

}
