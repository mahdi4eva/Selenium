package com.qa.Bank.pages;

import com.qa.Bank.tests.BankCustomerLoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utils.BrowserUtils;

public class BankCustomerLoginPage {

    public BankCustomerLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement customerSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeHeader;
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @FindBy(xpath = "//button[.='Deposit']")
    WebElement depositClickButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawButton;
    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawClickButton;
    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement depositTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement withDrawTransaction;




    public void loginAsCustomer(String customerName){
        BrowserUtils.selectBy(customerSelect,customerName,"text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeHeader),"Welcome "+customerName+" !!");
    }

    public void deposit(String depositAmount,String expectedMessage,String expectedColor){
        depositButton.click();
        amount.sendKeys(depositAmount);
        depositClickButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
    }

    public void withdraw(String withDrawAmount,String expectedMessage,String expectedColor) throws InterruptedException {
        withdrawButton.click();
        Thread.sleep(2000);
        amount.sendKeys(withDrawAmount);
        withdrawClickButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
    }

    public void transaction() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(2000);
        transactionButton.click();
        Thread.sleep(2000);
        int transactionBalance=Integer.parseInt(BrowserUtils.getText(depositTransaction))
                - Integer.parseInt(BrowserUtils.getText(withDrawTransaction));
        Assert.assertEquals(actualBalance,transactionBalance);
    }

}