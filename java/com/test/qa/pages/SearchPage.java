package com.test.qa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SearchPage {

    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        if (!driver.getTitle().contains("Code Search")) {
            throw new IllegalStateException("This is not the search page");
        }
    }

    By searchFieldLocator = By.xpath("//input[@aria-label = 'Search GitHub']");
    By submitButtonLocator = By.xpath("//div[@class = 'TableObject-item']/button[@class]");

    @Step
    public SearchPage typeValueToSearchField(String value) {
        driver.findElement(searchFieldLocator).sendKeys(value);
        return this;
    }

    @Step
    public ResultsSearchPage clickToSubmit() {
        driver.findElement(submitButtonLocator).submit();
        return new ResultsSearchPage(driver);
    }



}
