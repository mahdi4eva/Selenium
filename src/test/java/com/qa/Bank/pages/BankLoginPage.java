package com.qa.Bank.pages;

import Utils.BrowserUtils;
import com.qa.Bank.tests.BankCustomerLoginTest;
import com.qa.Bank.tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerLoginButton;
    @FindBy(xpath = "//button[contains(@ng-click,'customer')]")
    WebElement customerLoginButton;
    @FindBy(css = ".mainHeading")
    WebElement header;


    public void loginPageInformation(WebDriver driver,String expectedHeader,String expectedTitle,String expectedUrl){
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isEnabled() && managerLoginButton.isDisplayed());
        Assert.assertTrue(customerLoginButton.isEnabled() && customerLoginButton.isDisplayed());
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    public void clickManagerLoginButton(){
        managerLoginButton.click();
    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public void clickCustomerLoginButton(){
        customerLoginButton.click();
    }

    //STORY: Testing AddCustomer Functionality
    /*
    1-Navigate website
    2-Click Bank Manager Login Button(under LoginPage)
    3-Create Another Page for BankManagerLogin
    4-Put all the webElements and methods in here
    5-Create a Test Class for BankManagerTest
    6-Call the methods and validate "Customer added successfully" from pop-up and click OK button
     */



}