package utils;

import io.cucumber.java.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Setup {

        public static WebDriver driver;

        @Before
        public void SetWebDriver() {

            String browser = System.getProperty("browser");

            if (browser == null) {
                browser = "chrome";
            }
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();

                    break;

                case "firefox":
                    FirefoxProfile profile = new FirefoxProfile();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("platform", Platform.WIN10);
                    firefoxOptions.setProfile(profile);
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();

                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setCapability("platform", Platform.WIN10);
                    driver = new EdgeDriver(edgeOptions);
                    driver.manage().window().maximize();
                    break;

                default:
                    throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported");

            }

        }

        public static WebDriver getDriver() {
            return driver;
        }
    }


