package Iframe;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedFramePractice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //Get into LEFT FRAME BUT FIRST TOP FRAME BECAUSE IT IS NESTED FRAME(FRAME-SET)
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        //get out from left frame
        driver.switchTo().parentFrame();

        //GET INTO MIDDLE FRAME
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='framemiddle']"));
        driver.switchTo().frame(middleFrame);
        WebElement middleText= driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middleText));

        //GET OUT FROM MIDDLE FRAME
        driver.switchTo().parentFrame();

        //GET INTO RIGHT FRAME(ID-NAME)
        driver.switchTo().frame("frame-right");
        WebElement rightText=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(rightText));

        //GET OUT TWO TIMES BECAUSE OF NESTED FRAME (TOP FRAME and MAIN HTML --> BOTTOM FRAME
        driver.switchTo().parentFrame();//TOP FRAME
        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().frame(1);// TOP FRAME(INDEX 0) --> BOTTOM FRAME(1)
        WebElement bottomText = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomText));


    }
}
