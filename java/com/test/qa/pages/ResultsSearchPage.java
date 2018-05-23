package com.test.qa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultsSearchPage {

    private final WebDriver driver;


    public ResultsSearchPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().contains("Search")) {
            throw new IllegalStateException("This is not the result search page");
        }
    }

    private String listResultSearch = "//div[@class = 'repo-list-item d-flex flex-justify-start py-4 public source']";
    By listStarsLocators = By.xpath("//a[@class = 'muted-link']");
    By listProgrammLanguage = By.xpath("//ul[@class = 'filter-list small']/li");
    By listProgrammLanguageInSearchResult = By.xpath(""+ listResultSearch + "//div[@class = 'd-table-cell col-2 text-gray pt-2']");
    By listUserNameInSearchResult = By.xpath(""+ listResultSearch + "//a[@class = 'v-align-middle']");


    public List<Double> getListStars() {
        List<Double> doubleList = new ArrayList<>();
        List<WebElement> myList=driver.findElements(listStarsLocators);
        for(int i=0; i < myList.size(); i++) {
            doubleList.add(Double.parseDouble(myList.get(i).getText().replaceAll("k", "")));
        }

        return doubleList;
    }

    public List<WebElement> getWEListProgrammLanguage() {
        List<WebElement> programmLanguageList=driver.findElements(listProgrammLanguage);
        return programmLanguageList;
    }

    @Step
    public void chooseProgrammLanguage(String programmLanguage) {
        for(int i = 0; i < getWEListProgrammLanguage().size(); i++) {
            if (getWEListProgrammLanguage().get(i).getText().contains(programmLanguage)) {
                getWEListProgrammLanguage().get(i).click();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//div[@id = 'js-pjax-loader-bar']"), "class", "pjax-loader-bar"));
    }

    public List<String> getProgrammLanguageInSearchResultList() {
        List<WebElement> WEList=driver.findElements(listProgrammLanguageInSearchResult);
        List<String> listProgrammLanguage = new ArrayList<>();
        for (int i = 0; i < WEList.size(); i++) {
            listProgrammLanguage.add(WEList.get(i).getText());
        }

        return listProgrammLanguage;
    }

    public List<String> getUserNameInSearchResultList() {
        List<WebElement> WEList=driver.findElements(listUserNameInSearchResult);
        List<String> listUserName = new ArrayList<>();

        for (int i = 0; i < WEList.size(); i++) {
            listUserName.add(WEList.get(i).getText().substring(0 , WEList.get(i).getText().lastIndexOf("/")));
        }

        return listUserName;
    }
}
