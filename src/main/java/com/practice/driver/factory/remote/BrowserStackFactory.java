package com.practice.driver.factory.remote;

import com.practice.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.practice.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.practice.enums.config.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class BrowserStackFactory {

  private BrowserStackFactory() {
  }

  private static final Map<BrowserType, Supplier<WebDriver>> MAP =
    new EnumMap<>(BrowserType.class);

  static {
    MAP.put(BrowserType.CHROME, BrowserStackChromeManager::getDriver);
    MAP.put(BrowserType.FIREFOX, BrowserStackFirefoxManager::getDriver);
  }

  public static WebDriver getDriver(BrowserType browserType) {
    return MAP.get(browserType).get();
  }
}
