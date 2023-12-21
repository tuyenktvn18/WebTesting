package com.practice.driver.manager;

import com.practice.driver.entity.WebDriverData;
import com.practice.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

import static com.practice.config.factory.ConfigFactory.getConfig;

public final class Driver {

  private Driver() {}

  public static void initDriverForWeb() {
    if (Objects.isNull(DriverManager.getDriver())) {
      WebDriverData driverData = new WebDriverData(getConfig().browser(), getConfig().browserRemoteMode());
      WebDriver driver = DriverFactory
        .getDriverForWeb(getConfig().runModeType())
        .getDriver(driverData);
      DriverManager.setDriver(driver);
      loadURL();
    }
  }

  public static void loadURL() {
    DriverManager.getDriver().get(getConfig().webUrl());
  }

  public static void quitDriver() {
    if (Objects.nonNull(DriverManager.getDriver())) {
      DriverManager.getDriver()
        .quit();
      DriverManager.unload();
    }
  }
}
