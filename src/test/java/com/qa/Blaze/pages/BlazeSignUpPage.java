package com.qa.Blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeSignUpPage {

    public BlazeSignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#sign-username")
    WebElement username;

    @FindBy(css="#sign-password") //Command + D = DUPLICATE
    WebElement password;

    @FindBy (xpath="//button[@onclick='register()']")
    WebElement submitButton;

    public void signUp(WebDriver driver,String username, String password,String expectedMessage) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        submitButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedMessage);
        alert.accept();

    }


}
