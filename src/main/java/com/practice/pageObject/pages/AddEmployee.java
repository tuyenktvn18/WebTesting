package com.practice.pageObject.pages;

import com.practice.dataTest.models.AddNewEmployeeCred;
import com.practice.pageUI.pages.AddEmpUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends EmployeeList {

    public AddEmployee enterFirstNameTextBox(String firstName) {
        waitForElementClickable(AddEmpUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.FIRST_NAME_TEXT_BOX, firstName);
        return this;
    }

    public AddEmployee enterMiddleNameTextBox(String middleName) {
        waitForElementClickable(AddEmpUI.MIDDLE_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.MIDDLE_NAME_TEXT_BOX, middleName);
        return this;
    }

    public AddEmployee setLastNameTextBox(String lastName) {
        waitForElementClickable(AddEmpUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(AddEmpUI.LAST_NAME_TEXT_BOX, lastName);
        return this;
    }

    public AddEmployee fillDetails(AddNewEmployeeCred addNewEmployeeCred) {
        enterFirstNameTextBox(addNewEmployeeCred.getFirstName());
        enterMiddleNameTextBox(addNewEmployeeCred.getMiddleName());
        setLastNameTextBox(addNewEmployeeCred.getLastName());
        clickToSaveBtn();
        return PageGeneratorManager.getAddEmployeePage();
    }

    public boolean isSuccessSaveMessageDisplayed() {
        waitForElementVisible(AddEmpUI.SUCCESSFUL_SAVE_MESSAGE);
        return isPresent(AddEmpUI.SUCCESSFUL_SAVE_MESSAGE, WebElement::isDisplayed);
    }

    public String getEmployeeId() {
        return getElementValueByJsXpath(AddEmpUI.EMPLOYEE_ID);
    }




}
