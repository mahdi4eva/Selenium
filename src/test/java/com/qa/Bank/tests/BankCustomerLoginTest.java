package com.qa.Bank.tests;

import Utils.ConfigReader;
import com.qa.Bank.pages.BankCustomerLoginPage;
import com.qa.Bank.pages.BankLoginPage;
import com.qa.Bank.pages.BankManagerLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class BankCustomerLoginTest extends TestBase{

    @Test
    public void validateCustomerTransaction() throws InterruptedException {
//        //SETUP AUTOMATION
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        //Click BankManagerLogin Button from LoginPage
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        //Provide All details in AddCustomer Button from BankManager Page
        BankManagerLoginPage bankManagerLoginPage=new BankManagerLoginPage(driver);
        bankManagerLoginPage.addCustomer(driver, ConfigReader.readProperty("firstname"),
                                                 ConfigReader.readProperty("lastname"),
                                                 ConfigReader.readProperty("postcode"),
                                                 ConfigReader.readProperty("message"));

        //Open Account Functionality
        bankManagerLoginPage.openAccount(driver,"Ahmet Baldir","Dollar",
                "Account created successfully");

        //Customers Functionality
        bankManagerLoginPage.customers("Ahmet","Ahmet","Baldir",
                "60434","true");

        //CustomerLogin And Validate  Message
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();
        BankCustomerLoginPage bankCustomerLoginPage=new BankCustomerLoginPage(driver);
        bankCustomerLoginPage.loginAsCustomer("Ahmet Baldir");
        bankCustomerLoginPage.deposit("500","Deposit Successful","rgba(255, 0, 0, 1)");
        bankCustomerLoginPage.withdraw("300","Transaction successful","rgba(255, 0, 0, 1)");
        bankCustomerLoginPage.transaction();
    }
}