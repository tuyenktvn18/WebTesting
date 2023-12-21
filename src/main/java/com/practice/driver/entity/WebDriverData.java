package com.practice.driver.entity;


import com.practice.enums.config.BrowserRemoteModeType;
import com.practice.enums.config.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {
  private BrowserType browserType;
  private BrowserRemoteModeType browserRemoteModeType;
}
