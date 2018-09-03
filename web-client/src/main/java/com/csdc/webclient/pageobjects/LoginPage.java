package com.csdc.webclient.pageobjects;

import com.codeborne.selenide.Condition;
import com.csdc.webclient.core.BasePageObject;

import com.csdc.webclient.core.WebController;
import com.csdc.webclient.core.WebElementWrapper;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.csdc.webclient.core.WebController.*;

@Component
public class LoginPage extends BasePageObject {

    private WebElementWrapper userIdIpf = $("input[placeholder='UserID']");
    private WebElementWrapper passwordIpf = $("input[placeholder='Password']");
    private WebElementWrapper signInBtn = $("a[title='Sign in']");
    private WebElementWrapper signInConflictLbl = $(By.xpath("//span[text()='Sign in Conflict']"));
    private WebElementWrapper createNewSessionBtn = $("input[value='LOGIN_WITH_CONFLICT']");
    private WebElementWrapper getSignInConflictOkBtn = $(By.xpath("//button[text()='OK']"));

    public LoginPage open() {
        return WebController.open("login.zul", LoginPage.class);
    }

    public LoginPage selectDB(String dbName) {
        $("span[title='" + dbName + "']").click();
        userIdIpf.should(Condition.appear);
        passwordIpf.should(Condition.appear);
        return this;
    }

    public LoginPage signIn(String userId, String pass) {
        userIdIpf.setValue(userId);
        passwordIpf.setValue(pass);
        signInBtn.click();
        createNewSessionIfSignInConflictPresent();
        return this;
    }

    public LoginPage createNewSessionIfSignInConflictPresent() {
        signInConflictLbl.safeWaitUntil(Condition.appear, 200);
        if (signInConflictLbl.exists()) {
            createNewSessionBtn.click();
            getSignInConflictOkBtn.click();
        }

        return this;
    }
}
