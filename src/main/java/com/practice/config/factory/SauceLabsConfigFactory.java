package com.practice.config.factory;

import com.practice.config.config.SauceLabsConfig;
import org.aeonbits.owner.ConfigCache;

public final class SauceLabsConfigFactory {

  private SauceLabsConfigFactory() {
  }

  public static SauceLabsConfig getConfig() {
    return ConfigCache.getOrCreate(SauceLabsConfig.class);
  }
}
