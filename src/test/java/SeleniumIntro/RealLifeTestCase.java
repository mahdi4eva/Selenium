package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeTestCase {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        String actualTitle = driver.getTitle(); //website
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");

        driver.close();
    }
}
