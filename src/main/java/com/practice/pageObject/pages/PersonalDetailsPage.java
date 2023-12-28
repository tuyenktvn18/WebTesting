package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.dataTest.web.models.UpdatePersonalDetailsCred;
import com.practice.pageUI.pages.EmpListUI;
import com.practice.pageUI.pages.PersonalDetailsUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class PersonalDetailsPage extends BasePage {

    private final AddEmployeePage addEmployeePage;
    private List<Boolean> results;

    public PersonalDetailsPage() {
        this.addEmployeePage = new AddEmployeePage();
    }

    public PersonalDetailsPage enterEmployFullName(String firstname, String middleName, String lastName) {
        sleepInsecond(6);
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

    public boolean isErrorMessageDisplayed(String field) {
        By locator = replaceTextInXpath(PersonalDetailsUI.ERROR_REQUIRED_MESSAGE, field);
        waitForElementVisible(locator);
        return isPresentOrSelectedOrEnabled(locator, WebElement::isDisplayed);
    }

    public PersonalDetailsPage selectDateOfBirth(String dateOfBirth) {
        waitForElementVisible(PersonalDetailsUI.DATE_OF_BIRTH);
        sendKeyToElement(PersonalDetailsUI.DATE_OF_BIRTH, dateOfBirth);
        return this;
    }

    public PersonalDetailsPage fillDetailsInPersonalDetails(UpdatePersonalDetailsCred updatePersonalCred) {
        if (updatePersonalCred.getFirstName().isEmpty()) enterEmployFullName("", "", "");
        else {
            enterEmployFullName(updatePersonalCred.getFirstName(), updatePersonalCred.getMiddleName(), updatePersonalCred.getLastName());
            selectNationality(updatePersonalCred.getNationality());
            selectDateOfBirth(updatePersonalCred.getDateOfBirth());
            selectGender(updatePersonalCred.getGender());
            selectSmoker(updatePersonalCred.getSmoker());
        }
        return this;
    }

    public boolean checkMessageDisplayed(UpdatePersonalDetailsCred updatePersonalCred) {
        results = new ArrayList<>();
        if (updatePersonalCred.getFirstName().isEmpty()) {
            results.add(isErrorMessageDisplayed("lastName"));
            results.add(isErrorMessageDisplayed("firstName"));
        } else {
            results.add(isSuccessUpdatedMessageDisplayed());
        }
        return checkResultList(results);
    }

}
