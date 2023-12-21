package com.practice.config;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserType) {
        return BrowserType.valueOf(browserType);
    }
}
