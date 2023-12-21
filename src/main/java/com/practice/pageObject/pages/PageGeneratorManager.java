package com.practice.pageObject.page;

public class PageGeneratorManager {

    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public static DashboardPage getHomePage() {
        return new DashboardPage();
    }
}
