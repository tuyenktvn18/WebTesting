package com.practice.driver.impl;

import com.practice.driver.entity.WebDriverData;
import com.practice.driver.factory.local.LocalDriverFactory;
import com.practice.driver.manager.IWebDriver;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver {

  @Override
  public WebDriver getDriver(WebDriverData driverData) {
    return LocalDriverFactory.getDriver(driverData.getBrowserType());
  }
}
