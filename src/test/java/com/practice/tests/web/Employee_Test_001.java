package com.practice.tests.web;

import com.practice.commons.BaseTest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.models.AddNewEmployeeCred;
import com.practice.pageObject.pages.EmployeeList;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.practice.pageObject.pages.PageGeneratorManager.*;

public class PimTest_001 extends BaseTest {
    private String employeeId;

    @Test
    public void TC_000_LoginToApplication() {
        getLoginPage().loginToApplication("Admin", "admin123");
    }

    @Test(dataProvider = "AddNewEmployeeData")
    public void TC_001_Add_New_Employee(AddNewEmployeeCred addNewEmployeeCred) throws IOException {
        EmployeeList pimPage = getHomePage()
                .navigateToPimPage()
                .clickToAddBtn()
                .fillDetails(addNewEmployeeCred);
        employeeId = pimPage.getEmployeeId();
        Assert.assertTrue(pimPage.isSuccessSaveMessageDisplayed());
    }

    @Test
    public void TC_002_Upload_Avatar() {
        System.out.println("employeeId" + employeeId);
        EmployeeList pimPage = getPimPage()
                .uploadAvatar();

        Assert.assertTrue(pimPage.isSuccessUpdatedMessageDisplayed());

    }

    @DataProvider
    public AddNewEmployeeCred[] AddNewEmployeeData() {
        String filePath = "/src/main/java/com/practice/dataTest/data/AddNewEmployee.json";
        return DataObjectBuilder.buildDataObjectBuilder(filePath, AddNewEmployeeCred[].class);
    }
}
