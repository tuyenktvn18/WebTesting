package com.practice.tests.web;

import com.practice.commons.BaseTest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.models.AddNewEmployeeCred;
import com.practice.pageObject.pages.AddEmployee;
import com.practice.pageObject.pages.EmployeeList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.practice.pageObject.pages.PageGeneratorManager.*;

public class Employee_Test_001 extends BaseTest {
    private String employeeId;
    @Test
    public void TC_000_LoginToApplication() {
        getLoginPage().loginToApplication("Admin", "admin123");
    }

    @Test(dataProvider = "AddNewEmployeeData")
    public void TC_001_Add_New_Employee(AddNewEmployeeCred addNewEmployeeCred) {
        AddEmployee addEmployee = getHomePage()
                .navigateToEmpListPage()
                .setAddBtn()
                .fillDetails(addNewEmployeeCred);
        employeeId = addEmployee.getEmployeeId();
        Assert.assertTrue(addEmployee.isSuccessSaveMessageDisplayed());
    }

    @Test
    public void TC_002_Upload_Avatar() {
        EmployeeList employeeList = getEmployeeListPage()
                .uploadAvatar();

        Assert.assertTrue(employeeList.isSuccessUpdatedMessageDisplayed());
    }

    @Test
    public void TC_003_Search_Employee(){
        EmployeeList employeeList = getEmployeeListPage()
                .openTabInPimMenu("Employee List")
                .enterEmployeeId(employeeId)
                .setSearchBtn();

        Assert.assertTrue(employeeList.isEmployeeDisplayed(employeeId));
    }

    @DataProvider
    public AddNewEmployeeCred[] AddNewEmployeeData() {
        String filePath = "/src/main/java/com/practice/dataTest/data/AddNewEmployee.json";
        return DataObjectBuilder.buildDataObjectBuilder(filePath, AddNewEmployeeCred[].class);
    }
}
