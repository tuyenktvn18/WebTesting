package com.practice.tests.web;

import com.practice.annotations.FrameworkAnnotation;
import com.practice.commons.BaseTest;
import com.practice.enums.config.CategoryType;
import com.practice.pageObject.pages.DashboardPage;
import com.practice.pageObject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Dashboard_Page_Test extends BaseTest {
    @FrameworkAnnotation(category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SMOKE", "REGRESSION"})
    public void testHomePageComponents() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.loginToApplication("Admin", "admin123");

        Assert.assertEquals(dashboardPage.getHeaderName(),"Dashboard");
    }
}

