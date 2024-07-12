package com.automation.pages.resultpage;

import com.microsoft.playwright.Page;

public class ResultPage {

    private Page page;
    private SearchResult searchResult;

    public ResultPage(Page page) {
        this.page = page;
        this.searchResult = new SearchResult(page);
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }
}
