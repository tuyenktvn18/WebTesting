package com.practice.tests.web.PIM;

import com.practice.commons.BaseTest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.web.models.AddNewEmployeeCred;
import com.practice.dataTest.web.models.UpdatePersonalDetailsCred;
import com.practice.pageObject.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.practice.pageObject.pages.PageGeneratorManager.*;

public class Auto_004_Update_Personal_Details extends BaseTest {

    @BeforeClass
    public void LoginToApplication() {
        AddNewEmployeeCred employeeCred = DataObjectBuilder.buildDataObjectBuilder("web\\data\\AddNewEmployee.json", AddNewEmployeeCred.class);
        employeeCred.setEmployeeId(String.valueOf(getRandomNumber()));
        getLoginPage().loginToApplication("Admin", "admin123");
        getHomePage()
                .navigateToEmpListPage()
                .setAddBtn()
                .fillDetailsInAddNewEmp(employeeCred);
    }

    @Test(dataProvider = "updatePersonalDetails")
    public void TC_004_Update_Personal_Details(UpdatePersonalDetailsCred updatePersonalCred) {
        PersonalDetailsPage personalDetailsPage = getPersonalDetailsPage()
                .fillDetailsInPersonalDetails(updatePersonalCred)
                .hitToSavePersonalDetailsArea();

        Assert.assertTrue(personalDetailsPage.checkMessageDisplayed(updatePersonalCred));
    }

    @DataProvider
    public UpdatePersonalDetailsCred[] updatePersonalDetails() {
        String filePath = "web\\data\\UpdatePersonalDetails.json";
        return DataObjectBuilder.buildDataObjectBuilder(filePath, UpdatePersonalDetailsCred[].class);
    }
}
