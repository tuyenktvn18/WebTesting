package com.practice.constants;

import lombok.Getter;

import java.io.File;

@Getter
public class GlobalConstants {

    private static GlobalConstants globalInstance;

    private GlobalConstants() {
    }

    public static synchronized GlobalConstants getGlobalConstants() {
        return globalInstance = globalInstance == null ? new GlobalConstants() : globalInstance;
    }

    private final String projectPath = System.getProperty("user.dir");
    private final String dataTestPath = projectPath + File.separator + "datatests" + File.separator;
    private final String osName = System.getProperty("os.name");
    private final String javaVersion = System.getProperty("java.version");
    private final String uploadFile = projectPath + File.separator + "uploadFiles" + File.separator;
    private final String downloadFile = projectPath + File.separator + "downloadFiles";
    private final String browserLog = projectPath + File.separator + "browserLogs";
    private final String dragDropHTML5 = projectPath + File.separator + "dragDropHTML5";
    private final String autoITScript = projectPath + File.separator + "autoIT";


    private final String browserUsername = "tuyenthanh_3ynSm5";
    private final String browserAutomateKey = "dMAdjyzEEsvSpdgwhq8B";
    private final String browserStackUrl = "https://" + browserUsername + ":" + browserAutomateKey + "@hub-cloud.browserstack.com/wd/hub";

    private final String adminUserName = "SeleniumPractice";
    private final String adminPassword = "SeleniumPractice";
    private final String userUserName = "seleniumPractice1";
    private final String userPassword = "seleniumPractice1";


    //Database Account / User / Pass/ Port
    private final String dbHostName = "localhost";
    private final String dbName = "seleniumPractice";
    private final String dbUsername = "root";
    private final String dbPassword = "";

    private final long shortTimeout = 5;
    private final long longTimeout = 10;
    private final long retryTestFail = 3;

}
