package com.practice.config.converter;

import com.practice.enums.BrowserRunMode;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class StringToRunModeBrowserTypeConverter implements Converter<BrowserRunMode> {
    @Override
    public BrowserRunMode convert(Method method, String runMode) {
        return BrowserRunMode.valueOf(runMode.toUpperCase());
    }

}