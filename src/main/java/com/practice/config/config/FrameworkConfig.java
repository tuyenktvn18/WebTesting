package com.practice.config.config;

import com.practice.config.converter.StringToBrowserTypeConverter;
import com.practice.config.converter.StringToRemoteModeBrowserTypeConverter;
import com.practice.config.converter.StringToRunModeTypeConverter;
import com.practice.config.converter.StringToURLConverter;
import com.practice.enums.config.BrowserRemoteModeType;
import com.practice.enums.config.BrowserType;
import com.practice.enums.config.RunModeType;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

import java.net.URL;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
        "file:${user.dir}/src/test/resources/config/config.properties",
        "file:${user.dir}/src/test/resources/config/staging-config.properties",
        "file:${user.dir}/src/test/resources/config/dev-config.properties"})
public interface FrameworkConfig extends Config {

    @DefaultValue("staging")
    String environment();

    @Key("${environment}.webUrl")
    String webUrl();

    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();

    @ConverterClass(StringToRunModeTypeConverter.class)
    RunModeType runModeType();

    @ConverterClass(StringToRemoteModeBrowserTypeConverter.class)
    BrowserRemoteModeType browserRemoteMode();

    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();

    @ConverterClass(StringToURLConverter.class)
    URL selenoidURL();
}
