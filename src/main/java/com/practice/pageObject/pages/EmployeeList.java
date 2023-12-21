package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.pageUI.pages.AddEmpUI;
import com.practice.pageUI.pages.BasePageUI;
import com.practice.pageUI.pages.EmpListUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeList extends BasePage {

    public AddEmployee setAddBtn(){
        clickToAddBtn();
        return PageGeneratorManager.getAddEmployeePage();
    }

    public EmployeeList setSearchBtn(){
        clickToSearchBtn();
        return PageGeneratorManager.getEmployeeListPage();
    }

    public EmployeeList goToEmployeeDetail(String employeeId) {
        waitForElementClickable(replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId));
        clickToElement(replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId));
        return this;
    }

    public EmployeeList clickToAvatar() {
        waitForElementClickable(EmpListUI.IMAGE_PROFILE);
        clickToElement(EmpListUI.IMAGE_PROFILE);
        return this;
    }

    public EmployeeList clickToChangeAvatar() {
        waitForElementClickable(EmpListUI.CHANGE_IMAGE_PROFILE);
        clickToElement(EmpListUI.CHANGE_IMAGE_PROFILE);
        return this;
    }

    public EmployeeList uploadAvatar() {
        clickToAvatar();
        clickToChangeAvatar();
        uploadMultipleFiles(BasePageUI.UPLOAD_FILE, "uploadFile.jpg");
        clickToSaveBtn();
        return this;
    }

    public boolean isSuccessUpdatedMessageDisplayed() {
        waitForElementVisible(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE);
        return isPresent(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE, WebElement::isDisplayed);
    }

    public EmployeeList enterEmployeeId(String employeeId) {
        waitForElementClickable(By.xpath(AddEmpUI.EMPLOYEE_ID));
        sendKeyToElement(By.xpath(AddEmpUI.EMPLOYEE_ID), employeeId);
        return this;
    }

    public EmployeeList openTabInPimMenu(String pageTab) {
        waitForElementClickable(replaceTextInXpath(EmpListUI.TOP_MENU_IN_PIM,pageTab));
        clickToElement(replaceTextInXpath(EmpListUI.TOP_MENU_IN_PIM,pageTab));
        switch (pageTab) {
            case "Employee List":
                return PageGeneratorManager.getEmployeeListPage();
            case "Add Employee":
                return PageGeneratorManager.getAddEmployeePage();
            case "Reports":
                return PageGeneratorManager.getReportEmpPage();
            default:
                throw new RuntimeException("Invalid page name at My account Page");
        }
    }

    public boolean isEmployeeDisplayed(String employeeId) {
        waitForElementVisible(replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId));
        return isPresent(replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId), WebElement ::isDisplayed);
    }
}
