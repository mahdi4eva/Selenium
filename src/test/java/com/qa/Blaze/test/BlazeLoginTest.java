package com.qa.Blaze.test;

import com.qa.Bank.pages.BankLoginPage;
import com.qa.Blaze.pages.BlazeLoginPage;
import com.qa.Blaze.pages.BlazeMainPage;
import org.testng.annotations.Test;

public class BlazeLoginTest extends BlazeTestBase{

    @Test
    public void validateLoginFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.clickLoginButton();
        BlazeLoginPage loginPage = new BlazeLoginPage(driver);
        loginPage.login();
        blazeMainPage.headerInformation("Welcome");
    }
}
