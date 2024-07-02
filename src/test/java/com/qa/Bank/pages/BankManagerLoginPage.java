package com.qa.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerLoginPage {

    public BankManagerLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomer;
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement userDropDown;
    @FindBy(name = "currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customersButton;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomer;
    @FindBy(css = ".ng-binding")
    List<WebElement> allInformation;



    public void addCustomer(WebDriver driver,String firstName,String lastName,String postCode,String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomer.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void openAccount(WebDriver driver,String customerName,String currency,String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(this.userDropDown,customerName,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void customers(String customerName,String firstName,String lastName,String postCode,String account){
        customersButton.click();
        searchCustomer.sendKeys(customerName);
        List<String> expectedInformation= Arrays.asList(firstName,lastName,postCode,account);

        for(int i=0; i<allInformation.size()-1;i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }
     //   Assert.assertTrue(allInformation.getLast().isDisplayed()); //getLast() -->Will give you the last  Element

    }

}