package com.automation.pages.commonpage;

import com.microsoft.playwright.Page;

public abstract class AbstractComponent {

    protected Page page;

    private double timeout;

    public AbstractComponent(final Page page) {
        this.page = page;
        timeout = 60000;
    }

    public abstract boolean isDisplayed();

}
