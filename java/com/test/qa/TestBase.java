package com.test.qa;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.test.qa.SomeUsefulMethods.getCurrentTime;

public class TestBase {

    static String baseUrlRemote = "https://github.com/search";
    public static final Logger log = LogManager.getLogger(TestBase.class);
    public static WebDriver driver;

    public static String getBaseUrl() {
        return baseUrlRemote;
    }

    @BeforeMethod
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getBaseUrl());
    }

    @AfterMethod
    public  void tearDown() throws IOException {
        driver.quit();
    }
}
