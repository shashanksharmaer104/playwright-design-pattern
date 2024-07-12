package com.automation.pages.homepage;

import com.automation.pages.commonpage.NavigationHeader;
import com.automation.pages.commonpage.SearchWidget;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    private SearchWidget searchWidget;
    private NavigationHeader navigationHeader;

    public HomePage(Page page) {
        this.page = page;
        this.searchWidget = new SearchWidget(page);
        this.navigationHeader = new NavigationHeader(page);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NavigationHeader getNavigationHeader() {
        return navigationHeader;
    }

    public void goTo(final String url) {
        this.page.navigate(url);
    }

}
