package ActionsClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovingSliders {
    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        WebElement range = driver.findElement(By.xpath("//span[@id=range']"));
        String expectedRange ="3.5";
        while (BrowserUtils.getText(range).equals(expectedRange)){
            slider.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(1000);
        }
        Assert.assertEquals(BrowserUtils.getText(range),expectedRange);


    }
}
