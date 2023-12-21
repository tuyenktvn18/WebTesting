package com.practice.driver.manager;


import com.practice.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
  WebDriver getDriver(WebDriverData driverData);
}
