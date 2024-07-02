package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Watchable;
import java.sql.SQLOutput;

public class LocatorIntro2 {
    public static void main(String[] args) {
        //LOCATOR: TAG NAME
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LOCATOR: LINK-TEXT
        WebElement javaLink = driver.findElement((By.linkText("Java")));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText());
        driver.navigate().back();
        WebElement seleniumButton = driver.findElement(By.linkText("Selenium"));
        seleniumButton.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader);
        driver.navigate().back();
        WebElement Cucumber = driver.findElement(By.linkText("Cucumber"));
        Cucumber.click();
        WebElement cucumberHeader = driver.findElement(By.className("font-light"));
        System.out.println(cucumberHeader.getText());
        driver.navigate().back();
        driver.navigate().refresh();

        //LOCATOR: PARTIAL LINK TEXT  // has to be an a tag
        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();

        //LOCATOR: CSS  // #id or class
        WebElement headerCss = driver.findElement(By.cssSelector("#techtorial1")); //id
        System.out.println(headerCss.getText());
        WebElement allTools = driver.findElement(By.cssSelector(".group_checkbox")); //class
        System.out.println(allTools.getText());

        //MY LOCATOR USAGE RINK
        //CSS, XPATH, ID, NAME, CLASS ..
        driver.quit();












    }
}
