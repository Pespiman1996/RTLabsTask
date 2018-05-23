package com.test.qa.tests;

import com.test.qa.TestBase;
import com.test.qa.pages.ResultsSearchPage;
import com.test.qa.pages.SearchPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static com.test.qa.asserts.AssertsMethods.assertStars;
import static com.test.qa.asserts.AssertsMethods.assertUserNameInSearchResult;
import static com.test.qa.asserts.AssertsMethods.assertProgrammLanguageInSearchResult;

public class gitHubTest extends TestBase {

    SearchPage searchPage;
    ResultsSearchPage resultsSearchPage;

    @Test(enabled = true)
    @Description("Comparison of search results by rating.")
    public void testCompareStars() {
        searchPage = new SearchPage(driver);
        searchPage.typeValueToSearchField("test stars:>10000");
        searchPage.clickToSubmit();
        resultsSearchPage = new ResultsSearchPage(driver);
        assertStars(resultsSearchPage.getListStars(), 10.0);
    }

    @Test(enabled = true)
    @Description("Comparison of search results by name to the user and by the selected programming language.")
    public void testCompareUserNameAndProgrammingLanguage() {
        searchPage = new SearchPage(driver);
        searchPage.typeValueToSearchField("user:defunkt");
        searchPage.clickToSubmit();
        resultsSearchPage = new ResultsSearchPage(driver);
        resultsSearchPage.chooseProgrammLanguage("JavaScript");
        assertProgrammLanguageInSearchResult(resultsSearchPage.getProgrammLanguageInSearchResultList(), "JavaScript");
        assertUserNameInSearchResult(resultsSearchPage.getUserNameInSearchResultList(), "defunkt");
    }




}
