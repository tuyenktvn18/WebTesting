package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class PimUI {
    public static final By FIRST_NAME_TEXT_BOX = By.name("firstName");
    public static final By MIDDLE_NAME_TEXT_BOX = By.name("middleName");
    public static final By LAST_NAME_TEXT_BOX = By.name("lastName");
    public static final String EMPLOYEE_ID = "//label[text()='Employee Id']/..//following-sibling::div/input";
    public static final By SUCCESSFUL_SAVE_MESSAGE = By.xpath("//p[text()='Successfully Saved']");
    public static final By SUCCESSFUL_UPDATED_MESSAGE = By.xpath("//p[text()='Successfully Updated']");
    public static final String CHECKBOX_BY_EMPLOYEE_ID = "//div[text()='%s']/../..//input";
    public static final String EMPLOYEE_ID_ROW = "//div[text()='%s']";
    public static final By IMAGE_PROFILE = By.cssSelector("div.orangehrm-edit-employee-image img.employee-image");
    public static final By CHANGE_IMAGE_PROFILE = By.cssSelector("div.employee-image-wrapper img.employee-image");

}
