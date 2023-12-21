package com.practice.pageObject.pages;

import com.practice.pageObject.components.LeftMenuComp;

public class PageGeneratorManager {

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    public static LeftMenuComp getLeftMenuComponents() {
        return new LeftMenuComp();
    }
    public static AddEmployee getAddEmployeePage() {
        return new AddEmployee();
    }
    public static EmployeeList getEmployeeListPage() {
        return new EmployeeList();
    }

    public static ReportEmployeePage getReportEmpPage() {
        return new ReportEmployeePage();
    }
}
