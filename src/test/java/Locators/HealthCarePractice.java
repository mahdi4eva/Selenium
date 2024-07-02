package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HealthCarePractice {
    public static void main(String[] args) throws InterruptedException {
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .equals XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement makeApptButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeApptButton.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();
        WebElement facility = driver.findElement(By.xpath("//select[@name='facility']"));
        facility.sendKeys("Seoul CURA Healthcare Center");
        WebElement admission = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (admission.isDisplayed() && admission.isEnabled() && !admission.isSelected()){
            admission.click();
        }
        WebElement healthcareProgram = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        healthcareProgram.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("06/12/2024");
        WebElement comments = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comments.sendKeys("Selenium is fun");
        WebElement bookAppointment = driver.findElement(By.xpath("//button[@type='submit']"));
        bookAppointment.click();
        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Confirmation')]"));
        String actualHeader = header.getText();
        String expectedHeader = "Please be informed that your appointment has been booked as following:";
        System.out.println(actualHeader.equals(expectedHeader) ? "passed" : "failed");
        WebElement program = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(program.getText());
        WebElement homepageButton = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homepageButton.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();














    }
}
