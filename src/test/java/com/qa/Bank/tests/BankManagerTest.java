package com.qa.Bank.tests;

import com.qa.Bank.pages.BankLoginPage;
import com.qa.Bank.pages.BankManagerLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends TestBase{

    @Test
    public void validateAddCustomerFunctionality(){
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
        bankManagerLoginPage.addCustomer(driver,"Ahmet","Baldir","60143",
                "Customer added successfully");
    }
    @Parameters({"firstName","lastName","postCode","expectedMessage"})
    @Test
    public void validateAddCustomerFunctionalityParameter(String firstName,String lastName,
                                                          String postCode,String expectedMessage){
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();
        BankManagerLoginPage bankManagerLoginPage=new BankManagerLoginPage(driver);
        bankManagerLoginPage.addCustomer(driver,firstName,lastName,postCode, expectedMessage);
    }

    @Test
    public void validateOpenAccountFunctionality(){
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
        bankManagerLoginPage.addCustomer(driver,"Ahmet","Baldir","60143",
                "Customer added successfully");
        bankManagerLoginPage.openAccount(driver,"Ahmet Baldir","Dollar",
                "Account created successfully");
    }

    @Test
    public void validateCustomersFunctionality(){
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
        bankManagerLoginPage.addCustomer(driver,"Ahmet","Baldir","60143",
                "Customer added successfully");

        //Open Account Functionality
        bankManagerLoginPage.openAccount(driver,"Ahmet Baldir","Dollar",
                "Account created successfully");

        //Customers Functionality
        bankManagerLoginPage.customers("Ahmet","Ahmet","Baldir",
                "60143","true");
    }
}