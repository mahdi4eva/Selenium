package AlertInterface;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceptAndGetText(){

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JSAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        JSAlert.click();

        // switching your driver to alert
        Alert alert=driver.switchTo().alert();
        alert.accept();// click ok button

        //validate the message
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You successfully clicked an alerts";
       // Assert.assertEquals(actualMessage,expectedMessage);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage,expectedMessage);

        //TASK1
        //Finding the alert and handle with Alert class
        WebElement JSConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        JSConfirm.click();
        alert = driver.switchTo().alert(); //re-assign the alert
        System.out.println(alert.getText()); //it gets the test from pop-up
        alert.dismiss(); // it clicks button from pop-up

        //validate the message
        message=driver.findElement(By.cssSelector("#result"));
        String actualMessageJS = BrowserUtils.getText(message);
        String expectedMessageJS = "You clicked: Cancel";
        //Assert.assertEquals(actualMessage,expectedMessage);
        softAssert.assertEquals(expectedMessageJS,expectedMessageJS);

        //TASK2
        // Finding the prompt element and handle alert
        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPrompt.click();
        alert.sendKeys("I love Selenium");
        alert.accept();

        //validate message
        message=driver.findElement(By.cssSelector("#result"));
        String actualMessageJsPrompt = BrowserUtils.getText(message);
        String expectedMessageJsPrompt = "You entered: I love Selenium";
       // Assert.assertEquals(actualMessage,expectedMessage);
        softAssert.assertEquals(actualMessageJsPrompt,expectedMessageJsPrompt);

    }
}

