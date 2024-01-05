package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.pageUI.pages.LoginPageUI;

public class LoginPage extends BasePage {

    private LoginPage inputToUserName(String userName) {
        waitForElementVisible(LoginPageUI.USER_NAME_TEXT_BOX);
        sendKeyToElement(LoginPageUI.USER_NAME_TEXT_BOX, userName);
        return this;
    }

    private LoginPage inputToPassword(String password) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(LoginPageUI.PASSWORD_TEXT_BOX, password);
        return this;
    }

    private DashboardPage clickToLoginBtn() {
        waitForElementClickable(LoginPageUI.LOGIN_BTN);
        clickToElement(LoginPageUI.LOGIN_BTN);
        return PageGeneratorManager.getHomePage();
    }

    public DashboardPage loginToApplication(String userName, String password) {
        return inputToUserName(userName)
                .inputToPassword(password)
                .clickToLoginBtn();
    }
}
