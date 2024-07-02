package ActionsClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        acceptCookies.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualText= BrowserUtils.getText(orangeBox);
        String expectedText="... Or here.";
        Assert.assertEquals(actualText,expectedText);
        String actualColor = orangeBox.getCssValue("background-color");
        System.out.println(orangeBox.getCssValue("background-color"));
        String expectedColor="rgba(238, 111, 11, 1)"; // 111, 11
        Assert.assertEquals(actualColor,expectedColor);
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.dragAndDrop(blueCircle, orangeBox).perform();
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        actualText = BrowserUtils.getText(orangeBox);
        expectedText = "You did great!";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void ClickAndHold(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement acceptCookies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        acceptCookies.click();
     //   actions.scrollByAmount(300,300).perform();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualText = BrowserUtils.getText(blueBox);
        String expectedText = "Drag the small circle here ...";
        Assert.assertEquals(actualText, expectedText);
        String  actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
     //   actions.clickAndHold(blueCircle).moveToElement(blueBox).release().perform();
        actualText = BrowserUtils.getText(blueBox);
        expectedText = "You did great!";
        Assert.assertEquals(actualText,expectedText);

    }
}
