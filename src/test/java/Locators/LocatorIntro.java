package Locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIntro {
    public static void main(String[] args) {
        // LOCATOR: ID
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText = header.getText(); // Techtorial Academy
        String expectedTitle = "Techtorial Academy";
        System.out.println(actualText.equals(expectedTitle) ? "Text is Correct" : "Text is Wrong");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //LOCATOR: NAME
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Zhuldyz");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Makhadiyeva");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("9172941326");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("mahdi4eva@gmail.com");

        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("1230 Ave Y");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Brooklyn");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("NY");

        WebElement postCode = driver.findElement(By.name("postalCode"));
        postCode.sendKeys("11235");

        // LOCATOR: CLASS
        WebElement allTools =driver.findElement(By.className("group_checkbox"));
        String actualToolText = allTools.getText();
        String expectedToolText = "All Tools";
        System.out.println(actualToolText.equals(expectedToolText) ? "Text PASSED" : "Text FAILED");

        WebElement javaBox = driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected()); // false
        if (javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected());  // true

        WebElement SeleniumBox = driver.findElement(By.id("cond2"));
        System.out.println(SeleniumBox.isSelected()); // false
        if (SeleniumBox.isDisplayed() && SeleniumBox.isEnabled() && !SeleniumBox.isSelected()){
            SeleniumBox.click();
        }
        System.out.println(SeleniumBox.isSelected());  // true

        WebElement TestNGBox = driver.findElement(By.id("cond3"));
        System.out.println(TestNGBox.isSelected()); // false
        if (TestNGBox.isDisplayed() && TestNGBox.isEnabled() && !TestNGBox.isSelected()){
            TestNGBox.click();
        }
        System.out.println(TestNGBox.isSelected());  // true

        WebElement CucumberBox = driver.findElement(By.id("cond4"));
        System.out.println(CucumberBox.isSelected()); // false
        if (CucumberBox.isDisplayed() && CucumberBox.isEnabled() && !CucumberBox.isSelected()){
            CucumberBox.click();
        }
        System.out.println(CucumberBox.isSelected());  // true
        driver.quit();


    }

}
