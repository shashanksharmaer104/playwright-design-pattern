package com.automation.pages.commonpage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchWidget extends AbstractComponent {

    //private Page page;

    private final String searchWidget = "//div[@id='search']";
    private final String searchField = "//input";
    private final String searchBtn = "//button";

    public SearchWidget(Page page) {
        super(page);
        //this.page = page;
    }

    @Override
    public boolean isDisplayed() {
        assertThat(page.locator(searchWidget)).isVisible();
        return page.isVisible(searchWidget);
    }

    public void enterKeyword(final String keyword) {
        Locator input = page.locator(searchWidget).locator(searchField);
        input.fill(keyword);
    }

    public void clickSearch() {
        page.locator(searchWidget).locator(searchBtn).click();
    }

    public void searchProduct(final String keyword) {
        this.enterKeyword(keyword);
        this.clickSearch();
    }

}
