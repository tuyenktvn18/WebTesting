package com.practice.pageObject.pages;

import com.practice.commons.BasePage;
import com.practice.enums.pages.LeftMenuEnums;
import com.practice.pageObject.components.LeftMenuComp;

public class DashboardPage extends BasePage {
    private final LeftMenuComp leftMenuComp;

    public DashboardPage() {
        this.leftMenuComp = new LeftMenuComp();
    }

    public EmployeeListPage navigateToEmpListPage() {
        leftMenuComp.clickMenuItem(LeftMenuEnums.PIM);
        return PageGeneratorManager.getEmployeeListPage();
    }
}
