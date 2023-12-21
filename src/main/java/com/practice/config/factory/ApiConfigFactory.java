package com.practice.config.factory;


import com.practice.config.config.ApiConfig;
import org.aeonbits.owner.ConfigCache;

public final class ApiConfigFactory {

  private ApiConfigFactory() {
  }

  public static ApiConfig getConfig() {
    return ConfigCache.getOrCreate(ApiConfig.class);
  }
}
