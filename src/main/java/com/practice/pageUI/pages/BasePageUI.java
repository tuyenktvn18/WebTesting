package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class BasePageUI {
    public static final By HEADER_NAME = By.xpath("//h6");
    public static final By UPLOAD_FILE = By.xpath("//input[@type='file']");
    public static final By LOADING_ICON = By.cssSelector("div.oxd-form-loader>div");
    public static final String COMMON_BTN = "//button[text()=' %s ']";
}
