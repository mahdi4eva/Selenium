package SelectClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MidLevelTask {
    @Test
    public void validateOrderFunctionality() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='pasCount']"));
//        Select passenger = new Select(passengerBox);
//        passenger.selectByVisibleText("4");
        BrowserUtils.selectBy(passengerBox,"4","text");

        WebElement fromPortBox = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPort = new Select(fromPortBox);
        WebElement defaultOption = fromPort.getFirstSelectedOption();
        String actualDefault = BrowserUtils.getText(defaultOption);
        String expectedDefault = "Acapulco";
        Assert.assertEquals(actualDefault,expectedDefault);
        fromPort.selectByValue("Paris");

        WebElement fromMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select fromMonth = new Select(fromMonthBox);
//        fromMonth.selectByVisibleText("August");
        BrowserUtils.selectBy(fromMonthBox,"August", "text");

        WebElement fromDayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select fromDay = new Select(fromDayBox);
//        fromDay.selectByValue("15");
        BrowserUtils.selectBy(fromDayBox,"15","value");

        WebElement toPortBox = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select toPort = new Select(toPortBox);
//        toPort.selectByIndex(6);
        BrowserUtils.selectBy(toPortBox,"6","index");

        WebElement toMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select toMonth = new Select(toMonthBox);
//        toMonth.selectByValue("12");
        BrowserUtils.selectBy(toMonthBox,"12","value");

        WebElement toDayBox = driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select toDay = new Select(fromDayBox);
//        toDay.selectByVisibleText("15");
        BrowserUtils.selectBy(toDayBox,"15","text");

        WebElement firstClassButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassButton.click();

        WebElement airlineBox = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline = new Select(airlineBox);
        List<WebElement> allOptions = airline.getOptions(); //actual
        List<String> expectedOptions = Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");

        for(int i=0; i<allOptions.size();i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(),expectedOptions.get(i));
        }
        airline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(7000);
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "After flight finder - No Seats Available";
        Assert. assertEquals(actualHeader,expectedHeader);


        /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passengers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText
 */
    }



}
