package com.practice.driver.impl;

import com.practice.driver.entity.WebDriverData;
import com.practice.driver.factory.remote.RemoteDriverFactory;
import com.practice.driver.manager.IWebDriver;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver {
  @Override
  public WebDriver getDriver(WebDriverData driverData) {
    return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteModeType(), driverData.getBrowserType());
  }
}
