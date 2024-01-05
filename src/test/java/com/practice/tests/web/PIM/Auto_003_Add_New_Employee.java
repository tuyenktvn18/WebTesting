package com.practice.tests.web.PIM;

import com.practice.commons.BaseTest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.web.models.AddNewEmployeeCred;
import com.practice.pageObject.pages.AddEmployeePage;
import com.practice.pageObject.pages.EmployeeListPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.practice.pageObject.pages.PageGeneratorManager.*;

public class Auto_003_Add_New_Employee extends BaseTest {
    public String employeeId;

    @BeforeClass
    public void LoginToApplication() {
        getLoginPage().loginToApplication("Admin", "admin123");
    }

    @Test
    public void TC_001_Add_New_Employee() {
        AddNewEmployeeCred addNewEmployeeCred = DataObjectBuilder.
                buildDataObjectBuilder("web\\data\\AddNewEmployee.json", AddNewEmployeeCred.class);
        addNewEmployeeCred.setEmployeeId(String.valueOf(getRandomNumber()));
        employeeId = addNewEmployeeCred.getEmployeeId();
        AddEmployeePage addEmployeePage = getHomePage()
                .navigateToEmpListPage()
                .setAddBtn()
                .fillDetailsInAddNewEmp(addNewEmployeeCred)
                .hitSaveBtn();
        Assert.assertTrue(addEmployeePage.isSuccessSaveMessageDisplayed());
    }

    @Test
    public void TC_002_Upload_Avatar() {
        EmployeeListPage employeeListPage = getEmployeeListPage()
                .uploadAvatar();

        Assert.assertTrue(employeeListPage.isSuccessUpdatedMessageDisplayed());
    }

    @Test
    public void TC_003_Search_Employee() {
        EmployeeListPage employeeListPage = getEmployeeListPage()
                .openTabInPimMenu("Employee List")
                .enterEmployeeId(String.valueOf(employeeId))
                .hitSearchBtn();

        Assert.assertTrue(employeeListPage.isEmployeeDisplayed(String.valueOf(employeeId)));
    }
}
