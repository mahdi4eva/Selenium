package SeleniumIntro;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {
    /*
    1-driver.get()
    2-driver.getTitle()
    3-driver.getCurrentUrl()
    4-driver.close()
    5-driver.manage.window.maximize()
    6-driver.navigate.to()
    7-driver.navigate.refresh()
    8-driver.navigate.forward()
    9-driver.navigate.back()
    10-driver.getPageSource()
    11-driver.quit()
     */
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back(); // google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward(); //facebook
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
        driver.quit();






    }
}
