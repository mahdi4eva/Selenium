package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); //4

        for(WebElement box : allBoxes ){
            if (box.isDisplayed() && box.isEnabled() && !box.isSelected()){
                Assert.assertFalse(box.isSelected());
                box.click();
                Assert.assertTrue(box.isSelected());
            }
            System.out.println(box.isSelected() ? "SELECTED" : "NOT SELECTED");

        }

    }
}
