package SelectClass;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
        public void validateLowToHighFunctionality() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
        Thread.sleep(2000);

        WebElement closeButton=driver.findElement(By.cssSelector(".banner-close-button"));
        closeButton.click();

        WebElement newUsed=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsed,"new_cpo","value");

        WebElement makes=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makes,"Lexus","text");

        WebElement model=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");
        WebElement priceBox=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select price=new Select(priceBox);

        WebElement defaultPrice=price.getFirstSelectedOption();
        String actualDefault=BrowserUtils.getText(defaultPrice);
        String expectedDefault="No max price";
        Assert.assertEquals(actualDefault,expectedDefault);

        WebElement distance=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");

        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear(); //clear the box
        Thread.sleep(5000);
        zipCode.sendKeys("60056", Keys.ENTER);

//        WebElement header =driver.findElement(By.tagName("h1"));
//        String actualHeader = BrowserUtils.getText(header);
//        String expectedHeader = "New and certified used Lexus RX 350";
//        Assert.assertTrue(actualHeader.contains(expectedHeader));
//
//        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));
//
//        for (WebElement title : allTitles){
//            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
//        }
//


        WebElement sortingDropDown=driver.findElement(By.cssSelector("#sort-dropdown"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sortingDropDown,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));

        List<Double> actualPrices=new ArrayList<>();  //I am going to store prices from website to my List.
        List<Double> expectedPrices=new ArrayList<>();

        for(int i=1;i<allPrices.size();i++){
            System.out.println(BrowserUtils.getText(allPrices.get(i)));
            actualPrices.add(Double.parseDouble
                    (BrowserUtils.getText(allPrices.get(i)).replace("$","")
                            .replace(",",".")));//allPrices.get(i).getText()
            expectedPrices.add(Double.parseDouble
                    (BrowserUtils.getText(allPrices.get(i)).replace("$","")
                            .replace(",",".")));//allPrices.get(i).getText()
        }
        System.out.println(actualPrices);
        System.out.println(expectedPrices);
        Collections.sort(expectedPrices); //ascending order
        System.out.println(expectedPrices);
        System.out.println(actualPrices);
        Assert.assertEquals(actualPrices,expectedPrices);
    }
}
