package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.enums.pages.LeftMenuEnums;
import com.practice.pageObject.components.LeftMenuComp;

public class HomePage extends BasePage {
    private final LeftMenuComp leftMenuComp;

    public HomePage() {
        this.leftMenuComp = new LeftMenuComp();
    }

    public EmployeeList navigateToEmpListPage() {
        leftMenuComp.clickMenuItem(LeftMenuEnums.PIM);
        return PageGeneratorManager.getEmployeeListPage();
    }
}
