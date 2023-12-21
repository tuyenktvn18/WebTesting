package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static final By USER_NAME_TEXT_BOX = By.cssSelector("input[placeholder='Username']");
    public static final By PASSWORD_TEXT_BOX = By.cssSelector("input[placeholder='Password']");
    public static final By LOGIN_BTN = By.cssSelector("button[type='submit']");
}
