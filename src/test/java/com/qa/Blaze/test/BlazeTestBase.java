package com.qa.Blaze.test;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BlazeTestBase {

    public WebDriver driver;

@BeforeMethod
    public void setup(){
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver = DriverHelper.getDriver();
          driver.get(ConfigReader.readProperty("qa_blaze_url"));
    }

    @AfterMethod
    public void teardown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blaze");

        }
        //driver.quit();
    }

    /*
    1-Navigate to the website from configuration.properties
    2-Click SignUp button (main page)
    3-Create SignUp Page and fill the information (username and password)
    4-Create SignUp Test to validate the message "Sign up successful."
    NOTE:Complete your TestBase class and comment out driver.quit for now
     */

}
