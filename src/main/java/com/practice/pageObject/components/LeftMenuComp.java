package com.practice.pageObject.components;

import com.practice.commons.BasePage;
import com.practice.enums.pages.LeftMenuEnums;
import com.practice.pageUI.components.LeftMenuCompUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeftMenuComp extends BasePage {
    public void clickMenuItem(LeftMenuEnums menuType) {
        By xpath = By.xpath(String.format(LeftMenuCompUI.MENU, menuType.getName()));
        waitForElementClickable(xpath);
        clickToElement(xpath);
    }

    public boolean isMenuItemDisplayed(String menuType) {
        String xpath = String.format(LeftMenuCompUI.MENU, menuType);
        waitForElementVisible(By.xpath(xpath));
        return isPresentOrSelectedOrEnabled(By.xpath(xpath),WebElement::isDisplayed);
    }
}
