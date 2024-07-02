package Locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");

        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Zhuldyz");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Makhadiyeva");
        WebElement jobTitle = driver.findElement(By.cssSelector("#job-title"));
        jobTitle.sendKeys("SDET");

        WebElement education = driver.findElement(By.cssSelector("#radio-button-2"));
            if(education.isDisplayed() && education.isEnabled() && !education.isSelected()) {
            education.click();
        }
        WebElement sex = driver.findElement(By.cssSelector("#checkbox-1"));
            if(sex.isDisplayed() && sex.isEnabled() && !sex.isSelected()) {
                sex.click();
        }
        WebElement experience = driver.findElement(By.cssSelector("#select-menu"));
        experience.sendKeys("2-4");

        WebElement date = driver.findElement(By.cssSelector("#datepicker"));
        date.sendKeys("05/04/2024");

        WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.cssSelector(".alert-success"));
        String actualMessage = message.getText();
        String expectedMessage = "The form was successfully submitted!";
        System.out.println(actualMessage.equals(expectedMessage) ? "passed" : "failed");

    }
}
