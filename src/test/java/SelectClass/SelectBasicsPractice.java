package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SelectBasicsPractice {
    public void practice() throws InterruptedException {

        /*
        1-Validate the default value is "UNITED STATES"
        2-Choose Your own country with "VisibleText" Method Thread.sleep to see how it is changing
        3-Choose your favorite country with "value" method Thread.sleep
        4-Choose the country you do not want to visit "index" Thread.sleep
        5-Validate the number of countries is 264
        6-Print out all the countries
        7-driver.quit()
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/linarbolatov/Downloads/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);
        WebElement defaultOption =country.getFirstSelectedOption();
        String actualDefault = defaultOption.getText();
        String expectedDefault = "UNITED STATES";
        Assert.assertEquals(actualDefault,expectedDefault);
        country.selectByVisibleText("TURKEY");
        Thread.sleep(2000);
        country.selectByValue("100"); //JAPAN
        Thread.sleep(2000);
        country.selectByIndex(31); // BRAZIL
        Thread.sleep(2000);
        List<WebElement> allCountries = country.getOptions();
        Assert.assertEquals(allCountries.size(),264);
        for (WebElement countrySingle:allCountries){
            System.out.println(countrySingle.getText());
        }

    }
}
