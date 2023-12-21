package com.practice.config.factory;

import com.practice.config.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {
    private ConfigFactory() {}

    public static FrameworkConfig getConfig(){
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }
}
