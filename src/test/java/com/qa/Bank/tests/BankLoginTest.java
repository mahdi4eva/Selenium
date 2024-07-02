package com.qa.Bank.tests;

import com.qa.Bank.pages.BankLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest extends TestBase{

    @Test
    public void validateLoginInformation(){
//        //SETUP AUTOMATION
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        //VALIDATE THE LOGIN PAGE INFORMATION
        BankLoginPage bankLoginPage=new BankLoginPage(driver); //to access the methods from this class
        bankLoginPage.loginPageInformation(driver,"XYZ Bank","XYZ Bank",
                "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }










}
