package com.qa.Blaze.pages;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeLoginPage {

    public BlazeLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#loginusername")
    WebElement loginUsername;
    @FindBy(css = "#loginpassword")
    WebElement loginPassword;
    @FindBy(xpath = "//button[.='Log in']")
    WebElement submitLogin;

    public void login(){
        loginUsername.sendKeys(ConfigReader.readProperty("username"));
        loginPassword.sendKeys(ConfigReader.readProperty("password"));
        submitLogin.click();
    }
}
