package com.practice.pageObject.pages;

import com.practice.pageObject.components.CommonBtnAndWaitIcon;
import com.practice.pageUI.pages.AddEmpUI;
import com.practice.pageUI.pages.EmpListUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeListPage extends CommonBtnAndWaitIcon {

    public AddEmployeePage setAddBtn(){
        clickToAddBtn();
        return PageGeneratorManager.getAddEmployeePage();
    }

    public EmployeeListPage hitSearchBtn(){
        clickToSearchBtn();
        return this;
    }

    public PersonalDetailsPage goToPersonalDetailPage(String employeeId) {
        enterEmployeeId(employeeId);
        hitSearchBtn();
        By locator = replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId);
        waitForElementClickable(locator);
        clickToElement(locator);
        return PageGeneratorManager.getPersonalDetailsPage();
    }

    public EmployeeListPage clickToAvatar() {
        waitForElementClickable(EmpListUI.IMAGE_PROFILE);
        clickToElement(EmpListUI.IMAGE_PROFILE);
        waitForElementClickable(EmpListUI.CHANGE_IMAGE_PROFILE);
        return this;
    }

    public EmployeeListPage uploadAvatar() {
        clickToAvatar();
        uploadMultipleFiles( "uploadFile.jpg");
        clickToSaveBtn();
        return this;
    }

    public boolean isSuccessUpdatedMessageDisplayed() {
        waitForElementVisible(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE);
        return isPresentOrSelectedOrEnabled(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE, WebElement::isDisplayed);
    }

    public EmployeeListPage enterEmployeeId(String employeeId) {
        waitForElementClickable(By.xpath(AddEmpUI.EMPLOYEE_ID));
        sendKeyToElement(By.xpath(AddEmpUI.EMPLOYEE_ID), employeeId);
        return this;
    }

    public EmployeeListPage openTabInPimMenu(String pageTab) {
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
        return isPresentOrSelectedOrEnabled(replaceTextInXpath(EmpListUI.EMPLOYEE_ID_ROW, employeeId), WebElement ::isDisplayed);
    }


}
