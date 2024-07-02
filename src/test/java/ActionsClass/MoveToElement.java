package ActionsClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MoveToElement {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allNames = driver.findElements(By.tagName("//h5"));
        List<WebElement> allImages = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(400,400).perform();

        for(int i=0;i<allNames.size();i++){
            actions.moveToElement(allImages.get(i)).perform(); //hover overs the pictures from 1-3
            Thread.sleep(2000);
            System.out.println(BrowserUtils.getText(allNames.get(i)));//get the text of each picture1-3
            Assert.assertEquals(BrowserUtils.getText(allNames.get(i)),expectedNames.get(i));
        }
        driver.quit();
    }
    @Test
    public void practiceHoverOver() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(2000);
        WebElement acceptCookies = driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        acceptCookies.click();
        Actions actions = new Actions(driver);

        List<WebElement> allImages = driver.findElements(By.tagName("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.tagName("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.tagName("//div[@class='product-description']//p"));
        Map<String,String> productInformation = new HashMap<>();

        for(int i=0; i<allNames.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            Thread.sleep(300);
            productInformation.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));

        }
        System.out.println(productInformation);

        /*
        1-Navigate to the website
        2-Accept Cookies if it popups.(Be careful about timing)
        3-Use actions.scrollByAmount(400,400) or any number to make sure the items look good on your screen if it necessary
        4-Get the all images location as a list
        5-Get the all Names location as a list
        6-Get the all Price location as a list
        7-Inside of regular loop Use actions move to element and put in the map (Key will be name , Value will be Price)
        8-Outside of loop, print out Map
        9-Proud of Yourself
         */

    }

}
