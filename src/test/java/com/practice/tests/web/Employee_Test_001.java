package com.practice.tests.web;

import com.practice.commons.BaseTest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.models.AddNewEmployeeCred;
import com.practice.pageObject.pages.AddEmployeePage;
import com.practice.pageObject.pages.EmployeeListPage;
import com.practice.pageObject.pages.PersonalDetailsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.practice.pageObject.pages.PageGeneratorManager.*;

public class Employee_Test_001 extends BaseTest {
    private String employeeId ;
    @Test
    public void TC_000_LoginToApplication() {
        getLoginPage().loginToApplication("Admin", "admin123");
    }

    @Test(dataProvider = "AddNewEmployeeData")
    public void TC_001_Add_New_Employee(AddNewEmployeeCred addNewEmployeeCred) {
        addNewEmployeeCred.setEmployeeId(String.valueOf(getRandomNumber()));
        employeeId = addNewEmployeeCred.getEmployeeId();
        AddEmployeePage addEmployeePage = getHomePage()
                .navigateToEmpListPage()
                .setAddBtn()
                .fillDetails(addNewEmployeeCred);
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessageDisplayed());
    }

    @Test
    public void TC_002_Upload_Avatar() {
        EmployeeListPage employeeListPage = getEmployeeListPage()
                .uploadAvatar();

        Assert.assertTrue(employeeListPage.isSuccessUpdatedMessageDisplayed());
    }

    @Test
    public void TC_003_Search_Employee(){
        EmployeeListPage employeeListPage = getEmployeeListPage()
                .openTabInPimMenu("Employee List")
                .enterEmployeeId(String.valueOf(employeeId))
                .hitSearchBtn();

        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(String.valueOf(employeeId)));
    }

    @Test
    public void TC_004_Update_Personal_Details(){
        PersonalDetailsPage personalDetailsPage = getEmployeeListPage()
                .goToPersonalDetailPage(employeeId)
                .enterEmployFullName("Rename FirstName","Rename MiddleName","Rename Lastname")
                .selectNationality("Italian")
                .selectSmoker("Yes")
                .selectGender("Male")
                .hitToSavePersonalDetailsArea();

        Assert.assertTrue(personalDetailsPage.isSuccessUpdatedMessageDisplayed());

    }
    @DataProvider
    public AddNewEmployeeCred[] AddNewEmployeeData() {
        String filePath = "/src/main/java/com/practice/dataTest/data/AddNewEmployee.json";
        return DataObjectBuilder.buildDataObjectBuilder(filePath, AddNewEmployeeCred[].class);
    }
}
