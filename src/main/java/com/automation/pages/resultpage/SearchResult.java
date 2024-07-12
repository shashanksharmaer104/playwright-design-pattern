package com.automation.pages.resultpage;

import com.automation.pages.commonpage.AbstractComponent;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchResult extends AbstractComponent {

    private final String products = "//div[@class='product-thumb']";

    public SearchResult(Page page) {
        super(page);
    }

    public int getSearchResultCount() {
        return this.page.locator(products).count();
    }

    @Override
    public boolean isDisplayed() {
        return page.locator(products).first().isVisible();
    }
}
