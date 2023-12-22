package com.practice.pageObject.pages;

import com.practice.pageObject.components.LeftMenuComp;

public class PageGeneratorManager {

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public static DashboardPage getHomePage() {
        return new DashboardPage();
    }

    public static LeftMenuComp getLeftMenuComponents() {
        return new LeftMenuComp();
    }
    public static AddEmployeePage getAddEmployeePage() {
        return new AddEmployeePage();
    }
    public static EmployeeListPage getEmployeeListPage() {
        return new EmployeeListPage();
    }

    public static ReportEmployeePage getReportEmpPage() {
        return new ReportEmployeePage();
    }

    public static PersonalDetailsPage getPersonalDetailsPage() {
        return new PersonalDetailsPage();
    }
}
