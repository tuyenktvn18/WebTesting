package com.practice.commons;

import com.practice.driver.manager.Driver;
import com.practice.driver.manager.DriverManager;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.practice.config.reportConfig.VerificationFailures;

import java.io.File;
import java.util.Random;

import static com.practice.pageObject.pages.PageGeneratorManager.getLoginPage;

public class BaseTest {

    @BeforeSuite
    public void initBeforeSuite() {
        deleteAllFileInFolder();
    }

    @BeforeClass
    public synchronized void startDriver() {
        Driver.initDriverForWeb();
        DriverManager.getDriver().manage().window().maximize();
        System.out.println("Current Thread info = " + Thread.currentThread().getId() + ", Driver = " + DriverManager.getDriver());
    }

    public void openPage(String pageUrl){
        DriverManager.getDriver().get(pageUrl);
    }
    public void deleteAllFileInFolder() {
        try {
            String pathFolderDownload = GlobalConstants.getGlobalConstants().getProjectPath() + "/allure-results";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(999999);
    }

    @AfterClass(alwaysRun = true)
    protected void closeBrowserAndDriver() {
        Driver.quitDriver();
    }

    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return String.valueOf(month);
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }

    protected String getToday() {
        return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }

    protected String getTodayFormat() {
        return getCurrentYear() + "/" + getCurrentMonth() + "/" + getCurrentDay();
    }


    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

}
