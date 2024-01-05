package com.practice.tests.web.Dashboard;

import com.practice.commons.BaseTest;
import com.practice.enums.pages.LeftMenuEnums;
import com.practice.pageObject.components.LeftMenuComp;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.practice.pageObject.pages.PageGeneratorManager.getLeftMenuComponents;
import static com.practice.pageObject.pages.PageGeneratorManager.getLoginPage;

public class Auto_002_Left_Menu_Component_Test extends BaseTest {

    @Test
    public void TC_001_Left_Menu_Component_View() {
        getLoginPage().loginToApplication("Admin", "admin123");
        LeftMenuComp leftMenuComp = getLeftMenuComponents();
        for (int i = 0; i < LeftMenuEnums.MenuTypeNames.size(); i++) {
            Assert.assertTrue(leftMenuComp.isMenuItemDisplayed(LeftMenuEnums.MenuTypeNames.get(i)));
        }
    }
}
