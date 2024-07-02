package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //Create an object from WebDriver
        WebDriver driver = new ChromeDriver(); // Polymorphism
        // driver makes a connection between computer and web browser
        driver.get("https://www.facebook.com/");
        String actualTitle = driver.getTitle(); //website
        String expectedTitle = "Facebook - log in or sign up";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");

        driver.close(); //close the page

















    }
}
