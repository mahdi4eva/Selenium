package FileUploads;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    @Test
    public void test(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        //Finding the location and uploading the file
        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");
        WebElement uploadFile =driver.findElement(By.cssSelector("#file-submit"));
        uploadFile.click();

        //This is the proof it is actually uploaded file
        WebElement message=driver.findElement(By.cssSelector("#uploaded-files"));
        System.out.println(BrowserUtils.getText(message));


    }

    @Test
    public void practice(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        //Finding the location of choosefile and handle upload
        WebElement chooseFileButton = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFileButton.sendKeys("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");
        WebElement termsButton = driver.findElement(By.cssSelector("#terms"));
        termsButton.click();
        WebElement submitButton = driver.findElement(By.cssSelector("#submitbutton"));
        submitButton.click();

        //Validate
        WebElement header = driver.findElement(By.tagName("//h3//center"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualHeader,expectedHeader);



    }

}
