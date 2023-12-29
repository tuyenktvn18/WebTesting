package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class AddEmpUI {
    public static final By FIRST_NAME_TEXT_BOX = By.xpath("//input[@name = 'firstName']");
    public static final String FIRST_NAME_TEXT_BOX_STRING = "//input[@name = 'firstName']";
    public static final By MIDDLE_NAME_TEXT_BOX = By.xpath("//input[@name = 'middleName']");
    public static final String MIDDLE_NAME_TEXT_BOX_STRING = "//input[@name = 'middleName']";
    public static final By LAST_NAME_TEXT_BOX = By.xpath("//input[@name = 'lastName']");
    public static final String LAST_NAME_TEXT_BOX_STRING = "//input[@name = 'lastName']";
    public static final String EMPLOYEE_ID = "//label[text()='Employee Id']/..//following-sibling::div/input";
    public static final By SUCCESSFUL_SAVE_MESSAGE = By.xpath("//p[text()='Successfully Saved']");


}
