package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    @Test
    public void selectMethods() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement selectBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(selectBox);
        options.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        options.selectByValue("2");
        Thread.sleep(2000);
        options.selectByIndex(1);

        List<WebElement> allOptions = options.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");

        for(int i=0; i<allOptions.size();i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(),expectedOptions.get(i));

        }


    }
}
