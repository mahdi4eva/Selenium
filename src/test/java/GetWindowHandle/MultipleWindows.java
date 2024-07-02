package GetWindowHandle;

import Utils.BrowserUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MultipleWindows {

    @Test
    public void practice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        // Click Button4 which opens 3 tabs
        WebElement button4 = driver.findElement(By.cssSelector("newTabsBtn"));
        BrowserUtils.scrollWithJs(driver,button4);
        button4.click();

        //Switching window and validate Success Message
        BrowserUtils.switchWindow(driver, "Basic Controls");
        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Zhuldyz");

        WebElement lastName= driver.findElement(By.cssSelector("lastName"));
        lastName.sendKeys("Makh");

        WebElement gender =driver.findElement(By.cssSelector("#femalerb"));
        BrowserUtils.scrollWithJs(driver,gender);
        gender.click();

        WebElement englishBox = driver.findElement(By.cssSelector("#englishchbox"));
        BrowserUtils.scrollWithJs(driver,englishBox);
        englishBox.click();

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("fgnjb@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("123445");

        WebElement registerButton =driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();

        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String actualMessage = BrowserUtils. getText(message);
        String expectedMessage = " Registeration is Successfull";
        Assert.assertEquals(actualMessage, expectedMessage);
        String actualColor = message.getCssValue("color");
        String expectedColor = "rgba(0, 128, 0, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        //Switching window back to Window handle Practice and validate Header

        BrowserUtils.switchWindow(driver,"Window Handles Practice");
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);

        //Switching window back to AlertsDemo and validate header

        BrowserUtils.switchWindow(driver,"AlertsDemo");
        WebElement alertDemoHeader = driver.findElement(By.xpath("//h1[contains(text),'AlertsDemo']"));
        String actualAlertHeader = BrowserUtils.getText(alertDemoHeader);
        String expectedAlertHeader = "AlertsDemo";
        Assert.assertEquals(actualAlertHeader,expectedAlertHeader);
        WebElement promptBox = driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();





        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful" and color
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
        7-Proud of yourself
 */
    }
}
