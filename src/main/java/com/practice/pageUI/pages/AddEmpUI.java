package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class AddEmpUI {
    public static final By FIRST_NAME_TEXT_BOX = By.name("firstName");
    public static final By MIDDLE_NAME_TEXT_BOX = By.name("middleName");
    public static final By LAST_NAME_TEXT_BOX = By.name("lastName");
    public static final String EMPLOYEE_ID = "//label[text()='Employee Id']/..//following-sibling::div/input";
    public static final By SUCCESSFUL_SAVE_MESSAGE = By.xpath("//p[text()='Successfully Saved']");


}
