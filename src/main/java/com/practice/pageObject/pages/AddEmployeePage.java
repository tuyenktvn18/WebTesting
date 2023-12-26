package com.practice.pageObject.pages;

import com.practice.dataTest.web.models.AddNewEmployeeCred;
import com.practice.pageUI.pages.AddEmpUI;
import org.openqa.selenium.WebElement;

public class AddEmployeePage extends EmployeeListPage {

    public AddEmployeePage enterFirstNameTextBox(String firstName) {
        waitForElementClickable(AddEmpUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.FIRST_NAME_TEXT_BOX, firstName);
        return this;
    }

    public AddEmployeePage enterMiddleNameTextBox(String middleName) {
        waitForElementClickable(AddEmpUI.MIDDLE_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.MIDDLE_NAME_TEXT_BOX, middleName);
        return this;
    }

    public AddEmployeePage enterLastNameTextBox(String lastName) {
        waitForElementClickable(AddEmpUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.LAST_NAME_TEXT_BOX, lastName);
        return this;
    }

    public AddEmployeePage fillDetails(AddNewEmployeeCred addNewEmployeeCred) {
        enterFirstNameTextBox(addNewEmployeeCred.getFirstName());
        enterMiddleNameTextBox(addNewEmployeeCred.getMiddleName());
        enterLastNameTextBox(addNewEmployeeCred.getLastName());
        enterEmployeeId((addNewEmployeeCred.getEmployeeId()));
        clickToSaveBtn();
        return this;
    }

    public boolean isSuccessSaveMessageDisplayed() {
        waitForElementVisible(AddEmpUI.SUCCESSFUL_SAVE_MESSAGE);
        return isPresentOrSelectedOrEnabled(AddEmpUI.SUCCESSFUL_SAVE_MESSAGE, WebElement::isDisplayed);
    }

    public String getEmployeeId() {
        return getElementValueByJsXpath(AddEmpUI.EMPLOYEE_ID);
    }

    public void waitForAddToDatabase() {
        waitForElementVisible(AddEmpUI.FIRST_NAME_TEXT_BOX);
    }

}
