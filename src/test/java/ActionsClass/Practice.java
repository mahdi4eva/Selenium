package ActionsClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {

    @Test
    public void practiceDragAndDrop(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox = driver.findElement(By.tagName("//div[@class='simple-drop-container']//div[@id='droppable']"));
        String actualText = BrowserUtils.getText(dropBox);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText,expectedText);
        WebElement dragMe = driver.findElement(By.tagName("#drabbale"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropBox).perform();
        actualText = BrowserUtils.getText(dropBox);
        expectedText = "Dropped!";
        Assert.assertEquals(actualText,expectedText);
        String actualColor = dropBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        /*
        1-navigate to the website
        2-Validate the box text is "Drop here"
        3-Drag and Drop the "Drag me" Box
        4-Validate the text changed to "Dropped!"
        5-Color changed to navy blue.(rgba(70, 130, 180, 1))
         */

    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions = new Actions(driver);
        actions.click(acceptButton).perform();
        Thread.sleep(5000);
        WebElement box = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualText = BrowserUtils.getText(box);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);
        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        Thread.sleep(2000);
        actions.clickAndHold(notAcceptable).moveToElement(box).release().perform();
        Thread.sleep(2000);
        actualText = BrowserUtils.getText(box);
        expectedText = "Drop here";
        Assert.assertEquals(actualText, expectedText);
        WebElement acceptable=driver.findElement(By.cssSelector("#acceptable"));
        actions.clickAndHold(acceptable).moveToElement(box).release().perform();
        actualText = BrowserUtils.getText(box);
        expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);
        /*
        1-Navigate to the website
        2-Validate the text is Box text is "Drop here"
        3-Click and Hold Not acceptable box and release into Box
        4-Validate the box text is still "Drop here"
        5-Click and Hold Acceptable box and release into Box
        6-Validate box text is "Dropped!"

         */
    }

}
