package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    //Singleton Pattern Design
    // You can not create an object from this class (private)
    //We will apply Encapsulation

    private static WebDriver driver;

    private DriverHelper() {
    }

    ; // to not create an object from this class(Unique driver)

    public static WebDriver getDriver() {
        if (driver == null || ((RemoteWebDriver)driver).getSessionId()==null) {
            switch (ConfigReader.readProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
}

