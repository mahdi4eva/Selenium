package AlertInterface;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeAlert {

    @Test
    public void practiceHtmlAndJS(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");

        //Finding the previewJS and handle with JS Alert
        WebElement preview = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview.click();
        Alert alert = driver.switchTo().alert(); //because of pop-up
        System.out.println(alert.getText());
        alert.accept();

        //Finding previewHTML and handle with HTML Alert
        WebElement previewHTML = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewHTML.click();
        WebElement text =driver.findElement(By.xpath("//div[@role='dialog']"));
        System.out.println(BrowserUtils.getText(text));
        WebElement OkButton= driver.findElement(By.xpath("//button[.='OK']"));
        OkButton.click();

    }
}
