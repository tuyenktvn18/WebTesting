package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.dataTest.models.AddNewEmployeeCred;
import com.practice.enums.pages.CommonBtn;
import com.practice.pageUI.pages.BasePageUI;
import com.practice.pageUI.pages.PimUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PimPage extends BasePage {
    public PimPage clickToAddBtn() {
        waitForElementClickable(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.ADD.getBtnName()));
        clickToElement(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.ADD.getBtnName()));
        return this;
    }

    public PimPage enterFirstNameTextBox(String firstName) {
        waitForElementClickable(PimUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(PimUI.FIRST_NAME_TEXT_BOX, firstName);
        return this;
    }

    public PimPage enterMiddleNameTextBox(String middleName) {
        waitForElementClickable(PimUI.MIDDLE_NAME_TEXT_BOX);
        sendKeyToElement(PimUI.MIDDLE_NAME_TEXT_BOX, middleName);
        return this;
    }

    public PimPage setLastNameTextBox(String lastName) {
        waitForElementClickable(PimUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(PimUI.LAST_NAME_TEXT_BOX, lastName);
        return this;
    }

    public PimPage enterEmployeeId(String employeeId) {
        waitForElementClickable(By.xpath(PimUI.EMPLOYEE_ID));
        sendKeyToElement(By.xpath(PimUI.EMPLOYEE_ID), employeeId);
        return this;
    }

    public String getEmployeeId() {
        return getElementValueByJsXpath(PimUI.EMPLOYEE_ID);
    }

    public PimPage clickToSaveBtn() {
        waitForElementClickable(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SAVE.getBtnName()));
        clickToElement(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SAVE.getBtnName()));
        return this;
    }

    public PimPage fillDetails(AddNewEmployeeCred addNewEmployeeCred) {
        enterFirstNameTextBox(addNewEmployeeCred.getFirstName());
        enterMiddleNameTextBox(addNewEmployeeCred.getMiddleName());
        setLastNameTextBox(addNewEmployeeCred.getLastName());
        addNewEmployeeCred.setEmployeeId(getEmployeeId());
        clickToSaveBtn();
        return this;
    }

    public boolean isSuccessSaveMessageDisplayed() {
        waitForElementVisible(PimUI.SUCCESSFUL_SAVE_MESSAGE);
        return isPresent(PimUI.SUCCESSFUL_SAVE_MESSAGE, WebElement::isDisplayed);
    }

    public PimPage clickToSearchBtn() {
        waitForElementClickable(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SEARCH.getBtnName()));
        clickToElement(replaceTextInXpath(BasePageUI.COMMON_BTN, CommonBtn.SEARCH.getBtnName()));
        return this;
    }

    public PimPage goToEmployeeDetail(String employeeId) {
        waitForElementClickable(replaceTextInXpath(PimUI.EMPLOYEE_ID_ROW, employeeId));
        clickToElement(replaceTextInXpath(PimUI.EMPLOYEE_ID_ROW, employeeId));
        return this;
    }

    public PimPage clickToAvatar() {
        waitForElementClickable(PimUI.IMAGE_PROFILE);
        clickToElement(PimUI.IMAGE_PROFILE);
        return this;
    }

    public PimPage clickToChangeAvatar() {
        waitForElementClickable(PimUI.CHANGE_IMAGE_PROFILE);
        clickToElement(PimUI.CHANGE_IMAGE_PROFILE);
        return this;
    }

    public PimPage uploadAvatar() {
        clickToAvatar();
        clickToChangeAvatar();
        uploadMultipleFiles(BasePageUI.UPLOAD_FILE, "uploadFile.jpg");
        clickToSaveBtn();
        return this;
    }

    public boolean isSuccessUpdatedMessageDisplayed() {
        waitForElementVisible(PimUI.SUCCESSFUL_UPDATED_MESSAGE);
        return isPresent(PimUI.SUCCESSFUL_UPDATED_MESSAGE, WebElement::isDisplayed);
    }
}
