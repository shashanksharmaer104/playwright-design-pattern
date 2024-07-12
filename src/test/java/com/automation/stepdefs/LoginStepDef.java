package com.automation.stepdefs;

import com.automation.pages.homepage.HomePage;
import com.automation.pages.resultpage.ResultPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    private HomePage homePage;
    private ResultPage resultPage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();

        // Initialize pages
        this.homePage = new HomePage(page);
        this.resultPage = new ResultPage(page);
    }

    @After
    public void tearDown() {
        if (page != null) {
            // close sessions
            page.close();
            browser.close();
            playwright.close();
        }
    }

    @Given("I am on OpenCart login page")
    public void i_am_on_open_cart_login_page() {
        this.homePage.goTo("https://naveenautomationlabs.com/opencart/index.php");
    }

    @When("I search a product")
    public void i_search_a_product() {
        Assert.assertTrue(this.homePage.getSearchWidget().isDisplayed());
        this.homePage.getSearchWidget().searchProduct("samsung");
    }

    @Then("Verify results count")
    public void verifyResultsCount() {
        Assert.assertTrue(this.resultPage.getSearchResult().isDisplayed());
        int resultCount = this.resultPage.getSearchResult().getSearchResultCount();
        System.out.println("Count is:: " + resultCount);

        Assert.assertEquals(resultCount, 2, "Got incorrect search count");
    }
}
