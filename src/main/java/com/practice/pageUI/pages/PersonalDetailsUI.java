package com.practice.pageUI.pages;

import org.openqa.selenium.By;

public class PersonalDetailsUI {
    public static final By NATIONALITY_DROPDOWN = By.xpath("//label[text()='Nationality']/..//following-sibling::div//i");
    public static final By NATIONALITY_VALUE = By.xpath("//label[text()='Nationality']/..//following-sibling::div//div[@class='oxd-select-text-input']");
    public static final By DATE_OF_BIRTH = By.xpath("//label[text()='Date of Birth']/..//following-sibling::div//input");
    public static final String NATIONALITY_OPTION_DROPDOWN = "//div[@role='option']//span[text()='%s']";
    public static final String GENDER_RADIO_BTN = "//label[text()='%s']/span";
    public static final String SMOKER_CHECK_BOX = "//label[text()='%s']/span";
    public static final By SAVE_BTN_PERSONAL_DETAILS = By.xpath("//h6[text()='Personal Details']/..//button");
    public static final String ERROR_REQUIRED_MESSAGE = "//input[@name='%s']/..//following-sibling::span[text()='Required']";

}
