package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATHLocator {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/abtest");
        //ABSOLUTE XPATH / we never use it
        WebElement header = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText());

        //RELATIVE XPATH




    }
}
