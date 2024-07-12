package com.automation.pages.commonpage;

import com.microsoft.playwright.Page;

public class NavigationHeader extends AbstractComponent {

    private final String navBar = "//ul[@class='nav navbar-nav']";
    private final String desktops = "Desktops";

    public NavigationHeader(Page page) {
        super(page);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
