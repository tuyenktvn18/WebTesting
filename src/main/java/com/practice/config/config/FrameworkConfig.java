package com.practice.config;

import com.practice.enums.BrowserRemoteModeType;
import com.practice.enums.BrowserType;
import com.practice.enums.BrowserRunMode;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
        "system:properties",
        "system:env",
        "file:./src/test/config.properties",
        "file:./src/test/resources/config/data.properties"})
public interface FrameworkConfig extends Config {

    @DefaultValue("CHROME")
    BrowserType browser();

    BrowserRunMode browserRunMode();

    BrowserRemoteModeType browserRemoteMode();
}
