package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li//a"));
        for(WebElement link : allLinks){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            link.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
        }
        System.out.println(allLinks.size());

        for(WebElement link : allLinks){
            if (link.getText().length() >=12){
                System.out.println(link.getText());
                //counter++;
            }
           // System.out.println(counter);
        }
    }
}
