package TestNGConcept;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceLab {
    @Test
    public void validateHappyPathLoginFunctionality() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs=";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void negativeLoginFunctionality() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("Secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector("//h3"));
        errorMessage.getText();
        String actualMessage = errorMessage.getText().trim();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void validateProductDescription() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        /*
1-Navigate to website https://www.saucedemo.com/
2-Login Successfully with username and password
3-Store all the elements and validate there are 6 items on the website (list.size method might help)
4-Loop through all items and once this element name is "Sauce Labs Bolt T-Shirt" then click and break
5-Validate the header "Sauce Labs Bolt T-Shirt"
6-Validate the description contains(Sauce Labs bolt T-shirt)
7-Validate the price "$15.99"
8-Validate the Add to card is displayed on the page.
*/
        List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(allItems.size(), 6);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals("Sauce Labs Bolt T-Shirt")) {
                item.click();
                break;
            }
            WebElement header = driver.findElement(By.cssSelector(".inventory_details_name"));
            String actualHeader = header.getText().trim();
            String expectedHeader = "Sauce Labs Bolt T-Shirt";
            Assert.assertEquals(actualHeader, expectedHeader);

            WebElement description = driver.findElement(By.cssSelector(".inventory_details_desc"));
            String actualDescription = description.getText().trim();
            String expectedDescription = "Sauce Labs Bolt T-Shirt";
            Assert.assertTrue(actualDescription.contains(expectedDescription));

            WebElement price = driver.findElement(By.cssSelector("//div[@class='inventory_details_price']"));
            String actualPrice = price.getText().trim();
            String expectedPrice = "$15.99";
            Assert.assertEquals(actualPrice, expectedPrice);

            WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart"));
            Assert.assertTrue(addToCart.isDisplayed());

        }
    }

    @Test
    public void validateOrderFunctionality() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals(allItems.size(), 6);
        for (WebElement item : allItems) {
            if (item.getText().trim().equals("Sauce Labs Bolt T-Shirt")) {
                item.click();
                break;
            }
        }
         /*
        1-Click Add to Card button
        2-Click the cart at the top right
        3-Validate the name of the item "Sauce Labs Bolt T-Shirt" header
        4-Click check out button
        5-Provide the information
        6-Add the item total(15.99) and tax(1.28) and validate this number with total(17.27)
        7-Click Finish Button
        8-Validate "Thank you for your order!"
        9-driver.quit()
         */

        WebElement addToCart = driver.findElement(By.cssSelector("#add-to-cart"));
        addToCart.click();
        WebElement cartSign = driver.findElement(By.cssSelector(".shopping_cart_container"));
        cartSign.click();
        WebElement header = driver.findElement(By.cssSelector(".inventory_item_name"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        firstName.sendKeys("Zhuldyz");
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        lastName.sendKeys("Makhadiyeva");
        WebElement zipCode = driver.findElement(By.cssSelector("#postal-code"));
        zipCode.sendKeys("11235");
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();
        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        System.out.println(totalPrice.getText());
        System.out.println(totalPrice.getText().substring(totalPrice.getText().indexOf("$")+1));
        double itemTotal=Double.parseDouble(totalPrice.getText().substring(totalPrice.getText().indexOf("$")+1));
        WebElement tax = driver.findElement(By.cssSelector(".summary_tax_label"));
        double taxCalculator = Double.parseDouble(totalPrice.getText().substring(totalPrice.getText().indexOf("$")+1));
        WebElement totalPriceAll = driver.findElement(By.cssSelector(".summary_total_label"));
        double totalActualResult = Double.parseDouble(totalPriceAll.getText().substring(totalPriceAll.getText().indexOf("$")+1));

        double expectedResult = itemTotal+taxCalculator;

        Assert.assertEquals(totalActualResult,expectedResult);

        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        finishButton.click();

        WebElement successMessage = driver.findElement(By.tagName("h2"));
        String actualMessage = successMessage.getText().trim();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();

    }
}
