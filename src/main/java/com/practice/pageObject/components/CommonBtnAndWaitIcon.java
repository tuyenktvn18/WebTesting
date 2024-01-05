package com.practice.pageObject.components;

import com.practice.commons.BasePage;
import com.practice.enums.pages.CommonBtn;
import com.practice.pageUI.components.CommonBtnAndWaitUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonBtnAndWaitIcon extends BasePage {

    public void waitUntilLoadIconDisappear() {
        List<WebElement> loadingIcon = getListWebElement(CommonBtnAndWaitUI.LOADING_ICON);
        if(loadingIcon.size()>0){
            waitForAllElementInvisible(loadingIcon.get(0));
        }
    }

    public void clickToSaveBtn() {
        By locator = replaceTextInXpath(CommonBtnAndWaitUI.COMMON_BTN, CommonBtn.SAVE.getBtnName());
        waitForElementClickable(locator);
        clickToElement(locator);
    }

    public void clickToSearchBtn() {
        By locator = replaceTextInXpath(CommonBtnAndWaitUI.COMMON_BTN, CommonBtn.SEARCH.getBtnName());
        waitForElementClickable(locator);
        clickToElement(locator);
    }

    public void clickToAddBtn() {
        By locator = replaceTextInXpath(CommonBtnAndWaitUI.COMMON_BTN, CommonBtn.ADD.getBtnName());
        waitForElementClickable(locator);
        clickToElement(locator);
    }
}
