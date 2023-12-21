package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class EmpListUI {

    public static final By SUCCESSFUL_UPDATED_MESSAGE = By.xpath("//p[text()='Successfully Updated']");
    public static final String CHECKBOX_BY_EMPLOYEE_ID = "//div[text()='%s']/../..//input";
    public static final String EMPLOYEE_ID_ROW = "//div[text()='%s']";
    public static final By IMAGE_PROFILE = By.cssSelector("div.orangehrm-edit-employee-image img.employee-image");
    public static final By CHANGE_IMAGE_PROFILE = By.cssSelector("div.employee-image-wrapper img.employee-image");
    public static final String TOP_MENU_IN_PIM = "//a[text()='Employee List']/..";

}
