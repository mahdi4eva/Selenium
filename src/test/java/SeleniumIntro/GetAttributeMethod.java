package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttributeMethod {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement username= driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(username.getText());
        System.out.println(username.getAttribute("value"));
        System.out.println(username.getAttribute("placeholder"));



    }
}
