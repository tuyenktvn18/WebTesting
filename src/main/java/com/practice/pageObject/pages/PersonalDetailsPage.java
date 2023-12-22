package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.pageUI.pages.EmpListUI;
import com.practice.pageUI.pages.PersonalDetailsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonalDetailsPage extends BasePage {

    private final AddEmployeePage addEmployeePage;

    public PersonalDetailsPage() {
        this.addEmployeePage = new AddEmployeePage();
    }

    public PersonalDetailsPage enterEmployFullName(String firstname, String middleName, String lastName) {
        addEmployeePage.enterFirstNameTextBox(firstname);
        addEmployeePage.enterMiddleNameTextBox(middleName);
        addEmployeePage.enterLastNameTextBox(lastName);
        return this;
    }

    public PersonalDetailsPage selectNationality(String nationality) {
        By locator = replaceTextInXpath(PersonalDetailsUI.NATIONALITY_OPTION_DROPDOWN, nationality);
        selectItemDropDown(PersonalDetailsUI.NATIONALITY_DROPDOWN, locator, nationality);
        return this;
    }

    public PersonalDetailsPage selectGender(String gender) {
        By locator = replaceTextInXpath(PersonalDetailsUI.GENDER_RADIO_BTN, gender);
        clickToElement(locator);
        return this;
    }

    public PersonalDetailsPage selectSmoker(String option) {
        By locator = replaceTextInXpath(PersonalDetailsUI.SMOKER_CHECK_BOX, option);
//        if (!isPresentOrSelectedOrEnabled(locator, WebElement::isSelected))
        clickToElementWithWait(locator);
        return this;
    }

    public PersonalDetailsPage hitToSavePersonalDetailsArea() {
        clickToElementWithWait(PersonalDetailsUI.SAVE_BTN_PERSONAL_DETAILS);
        return this;
    }

    public boolean isSuccessUpdatedMessageDisplayed() {
        waitForElementVisible(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE);
        return isPresentOrSelectedOrEnabled(EmpListUI.SUCCESSFUL_UPDATED_MESSAGE, WebElement::isDisplayed);
    }
}
