package com.practice.tests.web;

import com.practice.annotations.FrameworkAnnotation;
import com.practice.commons.BaseTest;
import com.practice.driver.manager.DriverManager;
import com.practice.enums.config.CategoryType;
import com.practice.pageObject.pages.HomePage;
import com.practice.pageObject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
    @FrameworkAnnotation(category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    @Test(groups = {"SMOKE", "REGRESSION"})
    public void testHomePageComponents() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.loginToApplication("Admin", "admin123");

        Assert.assertEquals(homePage.getHeaderName(),"Dashboard");
    }
}

