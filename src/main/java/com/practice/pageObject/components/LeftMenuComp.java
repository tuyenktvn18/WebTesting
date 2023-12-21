package com.practice.pageObject.components;

import com.practice.commons.BasePage;
import com.practice.enums.pages.LeftMenuEnums;
import com.practice.pageUI.components.LeftMenuComp;
import org.openqa.selenium.By;

public class LeftMenuComponents extends BasePage {
    public void clickMenuItem(LeftMenuEnums menuType) {
        String xpath = String.format(LeftMenuComp.MENU, menuType.getName());
        clickToElement(By.xpath(xpath));
    }
}
