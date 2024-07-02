package SeleniumIntro;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethodPractice {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.wikipedia.org/");
        System.out.println();
        driver.quit();
    }
}
