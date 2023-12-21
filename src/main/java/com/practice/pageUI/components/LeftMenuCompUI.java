package com.practice.pageUI.components;

import org.openqa.selenium.By;

public class LeftMenuCompUI {
    public static final By LOGO = By.cssSelector("img[alt='client brand banner']");
    public static final String MENU = "//span[text()='%s']/..";
}
