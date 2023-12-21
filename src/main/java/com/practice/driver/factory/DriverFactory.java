package com.practice.driver.factory;

import com.practice.driver.impl.LocalWebDriverImpl;
import com.practice.driver.impl.RemoteWebDriverImpl;
import com.practice.driver.manager.IWebDriver;
import com.practice.enums.config.RunModeType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

  private DriverFactory() {
  }

  private static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);

  static {
    WEB.put(RunModeType.LOCAL, LocalWebDriverImpl::new);
    WEB.put(RunModeType.REMOTE, RemoteWebDriverImpl::new);
  }

  public static IWebDriver getDriverForWeb(RunModeType runModeType) {
    return WEB.get(runModeType).get();
  }

}
