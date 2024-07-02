package com.qa.Bank.tests;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod //It will run before every @Test Annotation
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.navigate().to(ConfigReader.readProperty("qa_url"));
    }

    @AfterMethod //It will run after every @Test Annotation
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"bank");
        }
       // driver.quit();
    }
}